const OurStoryComponent = () => {
  return (
    <div className='p-2'>
      <h1 className='text-brand-primary font-bold text-2xl mb-4 uppercase'>
        Our Story
      </h1>
      <hr className='w-48 h-1 mx-auto my-1 bg-gray-100 border-0 rounded md:my-4 dark:bg-gray-700' />
      <h3 className='text-gray-500 font-bold text-xl mb-4'>
        Welcome to eSkot - Where Tradition Meets Innovation!
      </h3>
      <p className='font-normal text-gray-500 mb-6'>
        At eSkot, we're redefining the way South Africans come together to save,
        invest, and grow their wealth through stokvels. Inspired by the
        deep-rooted tradition of collective financial support, we've created a
        modern, digital platform that makes managing stokvels simpler, more
        transparent, and accessible to everyone.
      </p>
      <h3 className='text-gray-500 font-bold text-xl mb-4 mt-4'>Our Mission</h3>
      <div className=''>
        <p className='font-normal text-gray-500'>
          We aim to empower individuals and communities by blending technology
          with the spirit of togetherness. eSkot is here to make it easy for
          everyone, from first-time savers to seasoned stokvel groups, to
          achieve their financial goals securely and efficiently.
        </p>

        <ul className='space-y-1 text-gray-500 list-disc list-inside dark:text-gray-400 mt-4'>
          <li>
            <b>Convenience</b> : Manage your stokvel from anywhere, anytime,
            with just a few taps on your device.
          </li>
          <li>
            <b>Transparency</b> : Real-time updates on contributions,
            payouts,and group balances ensure trust within the group.
          </li>
          <li>
            <b>Security</b> : Your funds and data are protected using the latest
            technology, giving you peace of mind.
          </li>
          <li>
            <b>Inclusivity</b> : Whether you're part of a savings stokvel,
            grocery group, or investment club, eSkot caters to all.
          </li>
        </ul>
      </div>

      <h3 className='text-gray-500 font-bold text-xl mb-4 mt-4'>Our Vision</h3>
      <div className=''>
        <p className='font-normal text-gray-500'>
          We envision a future where every individual can harness the power of
          collective saving and investing to build a better financial future for
          themselves and their communities.
        </p>
      </div>

      <h3 className='text-gray-500 font-bold text-xl mb-4 mt-4'>Our values</h3>
      <div className=''>
        <p className='font-normal text-gray-500'>
          We envision a future where every individual can harness the power of
          collective saving and investing to build a better financial future for
          themselves and their communities.
        </p>

        <ul className='space-y-1 text-gray-500 list-disc list-inside dark:text-gray-400 mt-4'>
          <li>
            <b>Communicate First</b> : We believe in the power of unity and
            collaboration
          </li>
          <li>
            <b>Innovation</b> : Bridging the gap between tradition and
            technology.
          </li>
          <li>
            <b>Trust</b> : Transparency and security are the cornerstones of
            eSkot.
          </li>
          <li>
            <b>Empowerment</b> : Enabling people to take control of their
            financial journeys.
          </li>
        </ul>
      </div>

      <p className='font-normal text-gray-500 mt-6 '>
        Join the eSkot family today and experience the stokvel revolution.
        Together, let's turn shared dreams into reality.
      </p>

      <h2 className='text-brand-primary font-bold text-xl mb-4 mt-6'>
        eSkot - Your Digital Stokvel Partner
      </h2>
    </div>
  );
};

export default OurStoryComponent;
