import { ReactNode } from 'react';
import DashboardHeaderComponent from '../components/DashboardHeader';

const DashboardLayout = ({ children }: { children: ReactNode }) => {
  return (
    <>
      <DashboardHeaderComponent />
      <div className='flex flex-col min-h-screen'>
        <main className='flex-grow container mx-auto px-4 py-8 max-w-screen-xl'>
          {children}
        </main>
      </div>
    </>
  );
};

export default DashboardLayout;
