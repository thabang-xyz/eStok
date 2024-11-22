import PublicLayout from '../layout/PublicLayout';
import AuthComponent from '../components/auth/AuthComponent';
const HomeView = () => {
  return (
    <PublicLayout>
      <AuthComponent />
    </PublicLayout>
  );
};

export default HomeView;
