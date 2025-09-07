import React from 'react';
import { Link } from 'react-router-dom';

const Home = () => {
  return (
    <div className="container mt-5">
      <div className="jumbotron bg-light p-5 rounded">
        <h1 className="display-4">Welcome to Travel Package System</h1>
        <p className="lead">Discover amazing travel packages and book your next adventure!</p>
        <hr className="my-4" />
        <p>Explore our curated collection of travel packages from around the world.</p>
        <Link className="btn btn-primary btn-lg" to="/packages" role="button">
          Explore Packages
        </Link>
      </div>

      <div className="row mt-5">
        <div className="col-md-4">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Diverse Destinations</h5>
              <p className="card-text">Choose from a wide range of destinations worldwide.</p>
            </div>
          </div>
        </div>
        <div className="col-md-4">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Easy Booking</h5>
              <p className="card-text">Simple and secure booking process.</p>
            </div>
          </div>
        </div>
        <div className="col-md-4">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Best Prices</h5>
              <p className="card-text">Competitive prices and great deals.</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;
