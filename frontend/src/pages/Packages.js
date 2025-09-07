import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

const Packages = () => {
  const [packages, setPackages] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchPackages = async () => {
      try {
        const response = await axios.get('http://localhost:8000/api/packages/');
        setPackages(response.data);
      } catch (error) {
        console.error('Error fetching packages:', error);
      } finally {
        setLoading(false);
      }
    };

    fetchPackages();
  }, []);

  if (loading) {
    return <div className="container mt-5 text-center">Loading packages...</div>;
  }

  return (
    <div className="container mt-5">
      <h1 className="mb-4">Travel Packages</h1>
      <div className="row">
        {packages.map((pkg) => (
          <div key={pkg.id} className="col-md-4 mb-4">
            <div className="card h-100">
              <div className="card-body">
                <h5 className="card-title">{pkg.name}</h5>
                <p className="card-text">{pkg.description}</p>
                <p className="card-text"><strong>Price: ${pkg.price}</strong></p>
                <p className="card-text"><small className="text-muted">Duration: {pkg.duration} days</small></p>
                <Link to={`/packages/${pkg.id}`} className="btn btn-primary">
                  View Details
                </Link>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Packages;
