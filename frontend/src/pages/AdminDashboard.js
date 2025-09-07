import React, { useState, useEffect, useContext } from 'react';
import axios from 'axios';
import { AuthContext } from '../context/AuthContext';

const AdminDashboard = () => {
  const { user } = useContext(AuthContext);
  const [packages, setPackages] = useState([]);
  const [bookings, setBookings] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const [packagesRes, bookingsRes] = await Promise.all([
          axios.get('http://localhost:8000/api/packages/'),
          axios.get('http://localhost:8000/api/bookings/'),
        ]);
        setPackages(packagesRes.data);
        setBookings(bookingsRes.data);
      } catch (error) {
        console.error('Error fetching data:', error);
      } finally {
        setLoading(false);
      }
    };

    if (user && user.is_staff) {
      fetchData();
    }
  }, [user]);

  if (!user || !user.is_staff) {
    return <div className="container mt-5 text-center">Access denied. Admin only.</div>;
  }

  if (loading) {
    return <div className="container mt-5 text-center">Loading dashboard...</div>;
  }

  return (
    <div className="container mt-5">
      <h1>Admin Dashboard</h1>
      <div className="row">
        <div className="col-md-6">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Total Packages</h5>
              <p className="card-text display-4">{packages.length}</p>
            </div>
          </div>
        </div>
        <div className="col-md-6">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Total Bookings</h5>
              <p className="card-text display-4">{bookings.length}</p>
            </div>
          </div>
        </div>
      </div>

      <div className="mt-5">
        <h2>Recent Bookings</h2>
        <div className="table-responsive">
          <table className="table table-striped">
            <thead>
              <tr>
                <th>ID</th>
                <th>Package</th>
                <th>User</th>
                <th>Status</th>
                <th>Booking Date</th>
              </tr>
            </thead>
            <tbody>
              {bookings.slice(0, 10).map((booking) => (
                <tr key={booking.id}>
                  <td>{booking.id}</td>
                  <td>{booking.package_name}</td>
                  <td>{booking.user}</td>
                  <td>{booking.status}</td>
                  <td>{new Date(booking.booking_date).toLocaleDateString()}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default AdminDashboard;
