import { Link } from 'react-router-dom';
import CustomLink from './form/Link';

const logo = require('../assets/estok-logo.png');

const HeaderComponent = () => {
  return (
    <div className='h-16 p-4 bg-green-600 text-center align-middle'>
      <nav className='bg-white dark:bg-gray-900 fixed w-full z-20 top-0 start-0 border-b border-gray-200 dark:border-gray-600'>
        <div className='max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4'>
          <a
            href='/'
            className='flex items-center space-x-3 rtl:space-x-reverse'
          >
            <img src={logo} className='h-8' alt='estok' />
            <span className='self-center text-2xl font-semibold whitespace-nowrap dark:text-white'>
              EStok
            </span>
          </a>
          <div className='flex md:order-2 space-x-3 md:space-x-0 rtl:space-x-reverse'>
            <Link
              type='button'
              to='/login'
              className='text-white bg-brand-primary hover:bg-green-600 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800'
            >
              Login
            </Link>
            <button
              data-collapse-toggle='navbar-sticky'
              type='button'
              className='inline-flex items-center p-2 w-10 h-10 justify-center text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600'
              aria-controls='navbar-sticky'
              aria-expanded='false'
            >
              <span className='sr-only'>Open main menu</span>
              <svg
                className='w-5 h-5'
                aria-hidden='true'
                xmlns='http://www.w3.org/2000/svg'
                fill='none'
                viewBox='0 0 17 14'
              >
                <path
                  stroke='currentColor'
                  strokeLinecap='round'
                  strokeLinejoin='round'
                  strokeWidth='2'
                  d='M1 1h15M1 7h15M1 13h15'
                />
              </svg>
            </button>
          </div>
          <div
            className='items-center justify-between hidden w-full md:flex md:w-auto md:order-1'
            id='navbar-sticky'
          >
            <ul className='flex flex-col p-4 md:p-0 mt-4 font-medium border border-gray-100 rounded-lg bg-gray-50 md:space-x-8 rtl:space-x-reverse md:flex-row md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700'>
              <CustomLink href='/' title='Home' />
              <CustomLink href='/our-story' title='Our Story' />
              <CustomLink href='/our-services' title='Our Services' />
              <CustomLink href='/faq' title='faq' />
            </ul>
          </div>
        </div>
      </nav>
    </div>
  );
};

export default HeaderComponent;
