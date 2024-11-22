import { useState } from 'react';
import CustomButton from '../form/CustomButton';
import CustomInput from '../form/CustomInput';
import PasswordInput from '../form/PasswordInput';

const LoginComponent = () => {
  const [isLoading, setIsLoading] = useState(false);
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = () => {
    console.log('details ', email, password);
  };

  const handleChange = (name: string, value: string) => {
    switch (name) {
      case 'email':
        setEmail(value);
        break;
      default:
        setPassword(value);
        break;
    }
  };

  return (
    <div className='flex justify-center px-6 py-8 mx-auto lg:py-0'>
      <div className='w-full rounded-lg shadow border md:mt-0 sm:max-w-md xl:p-0 border-brand-primary'>
        <div className='p-6 space-y-4 md:space-y-6 sm:p-8'>
          <h1 className='text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl text-brand-primary'>
            Sign in to your account
          </h1>
          <form className='space-y-4 md:space-y-6' action='#'>
            <div>
              <label className='block mb-2 text-sm font-medium text-gray-900 text-brand-primary'>
                Your email
              </label>
              <CustomInput
                placeholder='name@company.com'
                type='email'
                value={email}
                onChange={(e) => handleChange('email', e.target.value)}
              />
            </div>
            <div>
              <label className='block mb-2 text-sm font-medium text-gray-900 text-brand-primary visited:text-green-400'>
                Password
              </label>
              <PasswordInput
                placeholder='****************'
                value={password}
                onChange={(e) => handleChange('password', e.target.value)}
              />
            </div>
            <div className='flex items-center justify-between'>
              <div className='flex items-start'>
                <div className='flex items-center h-5'>
                  <input
                    id='remember'
                    aria-describedby='remember'
                    type='checkbox'
                    className='w-4 h-4 border border-gray-300 rounded bg-gray-50 focus:ring-3 focus:ring-primary-300 dark:bg-gray-700 dark:border-gray-600 dark:focus:ring-primary-600 dark:ring-offset-gray-800'
                  />
                </div>
                <div className='ml-3 text-sm'>
                  <label className='text-black-500 dark:text-black-300'>
                    Remember me
                  </label>
                </div>
              </div>
              <a
                href='/forgot-password'
                className='text-sm font-medium text-black-600 hover:underline text-primary-500 visited:text-green-400'
              >
                Forgot password?
              </a>
            </div>
            <CustomButton
              label='Sign in'
              variant='secondary'
              onClick={handleSubmit}
            />
            <p className='text-sm font-light text-brand-primary text-white-400'>
              Don't have an account yet? {''}
              <a
                href='/register'
                className='font-medium text-primary-600 hover:underline dark:text-primary-500 hover:text-green-500 visited:text-green-400'
              >
                Signup
              </a>
            </p>
          </form>
        </div>
      </div>
    </div>
  );
};

export default LoginComponent;
