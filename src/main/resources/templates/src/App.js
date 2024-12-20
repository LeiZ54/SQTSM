import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import SignUpPage from './pages/SignUpPage';
import LoginPage from './pages/LoginPage';
import HomePage from './pages/HomePage';
import ProfilePage from './pages/ProfilePage';
import CartPage from './pages/CartPage';
import AdDetailsPage from './pages/AdDetailsPage';
import AdminDashboard from './pages/AdminDashboard';
import ProductDetailsPage from './pages/ProductDetailsPage';
import OrderDetailsPage from './pages/OrderDetailsPage';
import { ToastContainer } from 'react-toastify';

function App() {

  return (
    <Router>
      <Routes>
        <Route
          path="/login"
          element={<LoginPage />}
        />
        <Route
          path="/signup"
          element={<SignUpPage />}
        />
        <Route
          path="/"
          element={<HomePage />}
        />
        <Route path="/ad/:adId" element={<AdDetailsPage />} />
        <Route
          path="/profile"
          element={<ProfilePage />}
        />
        <Route path="/product/:productId" element={<ProductDetailsPage />} />
        <Route
          path="/cart"
          element={<CartPage />}
        />
        <Route path="/orders/:orderNumber" element={<OrderDetailsPage />} />
        <Route path="/admin" element={<AdminDashboard />} />
      </Routes>
      <ToastContainer
        position="top-center"
        autoClose={5000}
        hideProgressBar={true}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover
      />
    </Router>
  );
}

export default App;
