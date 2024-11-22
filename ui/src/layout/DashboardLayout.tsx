import { ReactNode } from 'react';
import DashboardHeaderComponent from '../components/DashboardHeader';

const PublicLayout = ({ children }: { children: ReactNode }) => {
  return (
    <>
      <DashboardHeaderComponent />
      <div className='flex flex-col min-h-screen'>
        <main className='flex-grow container mx-auto px-4 py-8'>
          {children}
        </main>
      </div>
    </>
  );
};

export default PublicLayout;
