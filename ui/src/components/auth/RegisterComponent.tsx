import { useState } from 'react';
import CustomButton from '../form/CustomButton';
import CustomInput from '../form/CustomInput';
import PasswordInput from '../form/PasswordInput';

const RegisterComponent = () => {
  const [isLoading, setIsLoading] = useState(false);
  const [name, setName] = useState('');
  const [cellNumber, setCellNumber] = useState('');
  const [idNumber, setIdNumber] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');

  const handleSubmit = () => {
    console.log(
      'details ',
      name,
      cellNumber,
      idNumber,
      password,
      confirmPassword
    );
  };

  const handleChange = (name: string, value: string) => {
    switch (name) {
      case 'name':
        setName(value);
        break;
      case 'idNumber':
        setIdNumber(value);
        break;
      case 'cellNumber':
        setCellNumber(value);
        break;
      case 'password':
        setPassword(value);
        break;
      case 'confirmPassword':
        setConfirmPassword(value);
        break;
      default:
        break;
    }
  };
  return (
    <div className='flex justify-center px-6 py-8 mx-auto lg:py-0'>
      <div className='w-full rounded-lg shadow border md:mt-0 sm:max-w-md xl:p-0 border-brand-primary'>
        <div className='p-6 space-y-4 md:space-y-6 sm:p-8'>
          <h1 className='text-xl font-bold leading-tight tracking-tight text-gray-900 text-2xl text-brand-primary'>
            Sign up
          </h1>
          <form className='space-y-4 md:space-y-6' action='#'>
            <div>
              <label className='block mb-2 text-sm font-medium text-gray-900 text-brand-primary'>
                Full name
              </label>
              <CustomInput
                placeholder='john doe'
                value={name}
                onChange={(e) => handleChange('name', e.target.value)}
              />
            </div>
            <div>
              <label className='block mb-2 text-sm font-medium text-gray-900 text-brand-primary'>
                Cell number
              </label>
              <CustomInput
                placeholder='0731234567'
                value={cellNumber}
                onChange={(e) => handleChange('cellNumber', e.target.value)}
              />
            </div>
            <div>
              <label className='block mb-2 text-sm font-medium text-gray-900 text-brand-primary'>
                Id Number
              </label>
              <CustomInput
                placeholder='name@company.com'
                value={idNumber}
                onChange={(e) => handleChange('idNumber', e.target.value)}
              />
            </div>
            <div>
              <label className='block mb-2 text-sm font-medium text-gray-900 text-brand-primary'>
                Password
              </label>
              <PasswordInput
                placeholder='****************'
                value={password}
                onChange={(e) => handleChange('password', e.target.value)}
              />
            </div>

            <div>
              <label className='block mb-2 text-sm font-medium text-gray-900 text-brand-primary'>
                Confirm Password
              </label>
              <PasswordInput
                placeholder='****************'
                value={confirmPassword}
                onChange={(e) =>
                  handleChange('confirmPassword', e.target.value)
                }
              />
            </div>

            <CustomButton
              label='Sign up'
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

export default RegisterComponent;
