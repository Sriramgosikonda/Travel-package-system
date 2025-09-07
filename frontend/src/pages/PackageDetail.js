import React, { useState, useEffect, useContext } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';
import { AuthContext } from '../context/AuthContext';

const PackageDetail = () => {
  const { id } = useParams();
  const { user } = useContext(AuthContext);
  const navigate = useNavigate();
  const [pkg, setPkg] = useState(null);
  const [loading, setLoading] = useState(true);
  const [booking, setBooking] = useState(false);

  useEffect(() => {
    const fetchPackage = async () => {
      try {
        const response = await axios.get(`http://localhost:8000/api/packages/${id}/`);
        setPkg(response.data);
      } catch (error) {
        console.error('Error fetching package:', error);
      } finally {
        setLoading(false);
      }
    };

    fetchPackage();
  }, [id]);

  const handleBook = async () => {
    if (!user) {
      navigate('/login');
      return;
    }

    setBooking(true);
    try {
      await axios.post('http://localhost:8000/api/bookings/', {
        package: id,
        // Add other booking details as needed
      });
      alert('Booking successful!');
      navigate('/bookings');
    } catch (error) {
      console.error('Error booking package:', error);
      alert('Booking failed. Please try again.');
    } finally {
      setBooking(false);
    }
  };

  if (loading) {
    return <div className="container mt-5 text-center">Loading package details...</div>;
  }

  if (!pkg) {
    return <div className="container mt-5 text-center">Package not found.</div>;
  }

  return (
    <div className="container mt-5">
      <div className="row">
        <div className="col-md-8">
          <h1>{pkg.name}</h1>
          <p className="lead">{pkg.description}</p>
          <h4>Price: ${pkg.price}</h4>
          <p>Duration: {pkg.duration} days</p>
          <p>Destination: {pkg.destination}</p>
          <p>Available from: {pkg.start_date} to {pkg.end_date}</p>
          <button
            className="btn btn-primary btn-lg"
            onClick={handleBook}
            disabled={booking}
          >
            {booking ? 'Booking...' : 'Book Now'}
          </button>
        </div>
        <div className="col-md-4">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Package Details</h5>
              <ul className="list-group list-group-flush">
                <li className="list-group-item">Includes: {pkg.includes}</li>
                <li className="list-group-item">Excludes: {pkg.excludes}</li>
                <li className="list-group-item">Max Group Size: {pkg.max_group_size}</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PackageDetail;
