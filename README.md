# Travel Package System

This project is a Travel Package System built with the following tech stack:

- Frontend: React.js, Bootstrap, Tailwind CSS, Responsive Web Design
- Backend: Django (authentication, booking logic, admin panel), FastAPI (microservices & APIs)
- Databases: MySQL (structured data), MongoDB (unstructured data)
- Programming Languages: Python, JavaScript, SQL, HTML5, CSS3
- Tools: Git, GitHub, Postman, VS Code

## Project Structure

- `backend/django_project/` - Django backend for main app (auth, booking, admin)
- `backend/fastapi_service/` - FastAPI microservices for APIs
- `frontend/react_app/` - React frontend with Bootstrap and Tailwind CSS
- `docker/` - Docker configuration files (optional)
- `.env` - Environment variables

## Features

- User registration & login (JWT authentication)
- Browse/search/filter travel packages by location, budget, category
- Package details page with images, description, itinerary, price
- Booking system with cart & secure payment integration
- Admin dashboard for CRUD operations on packages, manage users/bookings
- REST APIs for frontend-backend communication
- Responsive and modern UI with React, Bootstrap, Tailwind CSS

## Setup Instructions

### Prerequisites
- Python 3.11+
- Node.js 16+
- MySQL (optional, SQLite used by default)
- MongoDB (optional)

### Backend Setup
1. Navigate to the backend directory:
   ```bash
   cd backend/django_project
   ```

2. Create and activate virtual environment:
   ```bash
   python -m venv ../venv
   ../venv/Scripts/activate  # On Windows
   ```

3. Install dependencies:
   ```bash
   pip install -r requirements.txt
   ```

4. Run migrations:
   ```bash
   python manage.py makemigrations
   python manage.py migrate
   ```

5. Create superuser:
   ```bash
   python manage.py createsuperuser
   ```

6. Run the server:
   ```bash
   python manage.py runserver
   ```

### Frontend Setup
1. Navigate to the frontend directory:
   ```bash
   cd frontend/react_app
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the development server:
   ```bash
   npm start
   ```

### Environment Variables
Copy `.env` file and update the values as needed.

## API Endpoints

### Authentication
- `POST /api/accounts/register/` - User registration
- `POST /api/accounts/login/` - User login
- `GET /api/accounts/profile/` - User profile (authenticated)

### Packages
- `GET /api/packages/packages/` - List packages
- `GET /api/packages/packages/{id}/` - Package details
- `GET /api/packages/categories/` - List categories

### Bookings
- `GET /api/bookings/` - List user bookings (authenticated)
- `POST /api/bookings/` - Create booking (authenticated)
- `GET /api/bookings/{id}/` - Booking details (authenticated)

## Testing

Run the Django server and test the APIs using Postman or curl:

```bash
# Test package list
curl http://127.0.0.1:8000/api/packages/packages/

# Test user registration
curl -X POST http://127.0.0.1:8000/api/accounts/register/ \
  -H "Content-Type: application/json" \
  -d '{"username": "testuser", "email": "test@example.com", "password": "password123"}'
```

## Deployment

TBD - Add Docker configuration
