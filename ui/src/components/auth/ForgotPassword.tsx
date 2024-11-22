import { useState } from 'react';
import CustomButton from '../form/CustomButton';
import CustomInput from '../form/CustomInput';
import PasswordInput from '../form/PasswordInput';

const ForgotPasswordComponent = () => {
  const [isLoading, setIsLoading] = useState(false);
  const [email, setEmail] = useState('');

  const handleSubmit = () => {
    console.log('details ', email);
  };

  return (
    <div className='flex justify-center px-6 py-8 mx-auto lg:py-0'>
      <div className='w-full rounded-lg shadow border md:mt-0 sm:max-w-md xl:p-0 border-brand-primary'>
        <div className='p-6 space-y-4 md:space-y-6 sm:p-8'>
          <h1 className='text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl text-brand-primary'>
            Reset your password
          </h1>
          <form className='space-y-4 md:space-y-6' action='#'>
            <div>
              <label className='block mb-2 text-sm font-medium text-gray-900 text-brand-primary'>
                Your email
              </label>
              <CustomInput
                placeholder='person@example.co.za'
                type='number'
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
            </div>
            <CustomButton
              label='Submit'
              variant='secondary'
              onClick={handleSubmit}
            />
            <p className='text-sm font-light text-brand-primary text-white-400'>
              Already have an account yet?{' '}
              <a
                href='/'
                className='font-medium text-primary-600 hover:underline dark:text-primary-500 hover:text-green-500 visited:text-green-400'
              >
                Signin
              </a>
            </p>
          </form>
        </div>
      </div>
    </div>
  );
};

export default ForgotPasswordComponent;
