import React from 'react';
import PropTypes from 'prop-types';
const banner = require('../assets/banner.png');
const HomeComponent = () => {
  return (
    <div>
      <img src={banner} alt='banner' className='w-full h-auto' />
    </div>
  );
};

export default HomeComponent;
