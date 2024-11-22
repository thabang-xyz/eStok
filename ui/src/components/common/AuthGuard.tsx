import React from 'react';
import { Navigate } from 'react-router-dom';

const ProtectedRoute = ({
  isAuthenticated,
  children,
}: {
  isAuthenticated: boolean;
  children: React.ReactElement;
}) => {
  if (!isAuthenticated) {
    return <Navigate to='/login' replace />;
  }
  return children;
};

export default ProtectedRoute;
