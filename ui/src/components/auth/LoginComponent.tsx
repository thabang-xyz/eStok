import CustomInput from '../form/CustomInput';

const LoginComponent = () => {
  return (
    <div className='w-1/3 p-2 bg-gray-200 border-2 rounded'>
      <h1>Login</h1>

      <CustomInput placeholder='Username..' />
    </div>
  );
};

export default LoginComponent;
