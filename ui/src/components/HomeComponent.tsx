import { Link } from 'react-router-dom';
import Box from './services/Box';

const banner = require('../assets/banner.png');
const HomeComponent = () => {
  return (
    <div className=' ustify-center'>
      <Link className='w-full h-100' to='/login'>
        <img src={banner} alt='banner' className='w-full h-100' />
      </Link>

      <div className='flex flex-wrap mt-6'>
        <Box
          title='EStok'
          image={require('../assets/banner.png')}
          description='EStok is a simple stock management app. You can use it to manage your stocks and keep track of your finances.'
        />
        <Box
          title='EStok'
          image={require('../assets/banner.png')}
          description='EStok is a simple stock management app. You can use it to manage your stocks and keep track of your finances.'
        />
      </div>
    </div>
  );
};

export default HomeComponent;
