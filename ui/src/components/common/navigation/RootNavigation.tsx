import { Routes, Route, Outlet } from 'react-router-dom';

import HomeView from '../../../views/HomeView';
import RegisterView from '../../../views/auth/RegisterView';
import ForgotPasswordView from '../../../views/auth/ForgotPasswordView';
import DashboardLayout from '../../../layout/DashboardLayout';
import ProtectedRoute from '../AuthGuard';
import Index from '../../../views/dashboard/Index';
import OurStoryView from '../../../views/basics/OurStoryView';
import OurServicesView from '../../../views/basics/OurServicesView';
import PublicLayout from '../../../layout/PublicLayout';
import LoginView from '../../../views/auth/LoginView';

const RootNavigation = () => {
  const isAuthenticated = true;
  return (
    <Routes>
      <Route
        element={
          <PublicLayout>
            <Outlet />
          </PublicLayout>
        }
      >
        <Route path='' element={<HomeView />} />
        <Route path='login' element={<LoginView />} />
        <Route path='register' element={<RegisterView />} />
        <Route path='forgot-password' element={<ForgotPasswordView />} />
        <Route path='our-story' element={<OurStoryView />} />
        <Route path='our-services' element={<OurServicesView />} />
      </Route>
      <Route
        element={
          <DashboardLayout>
            <Outlet />
          </DashboardLayout>
        }
      >
        <Route
          path='dashboard'
          element={
            <ProtectedRoute isAuthenticated={isAuthenticated}>
              <Index />
            </ProtectedRoute>
          }
        />
        <Route
          path='wallet'
          element={
            <ProtectedRoute isAuthenticated={isAuthenticated}>
              <Index />
            </ProtectedRoute>
          }
        />
      </Route>
    </Routes>
  );
};

export default RootNavigation;
