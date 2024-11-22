import { Routes, Route } from 'react-router-dom';

import HomeView from '../../../views/HomeView';
import RegisterView from '../../../views/auth/RegisterView';

const RootNavigation = () => {
  return (
    <Routes>
      <Route path='' element={<HomeView />} />
      <Route path='register' element={<RegisterView />} />
    </Routes>
  );
};

export default RootNavigation;
