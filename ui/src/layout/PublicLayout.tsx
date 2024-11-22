import { ReactNode } from 'react';
import HeaderComponent from '../components/HeaderComponent';

const PublicLayout = ({ children }: { children: ReactNode }) => {
  return (
    <>
      <HeaderComponent />
      <div className='flex flex-col min-h-screen'>
        <main className='flex-grow container mx-auto px-4 py-8'>
          {children}
        </main>
      </div>
    </>
  );
};

export default PublicLayout;
