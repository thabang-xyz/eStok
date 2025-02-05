const OurServiceComponent = () => {
  return (
    <div className='p-2'>
      <h1 className='text-brand-primary font-bold text-2xl mb-4 uppercase'>
        Our Services
      </h1>
      <p className='text-normal text-gray-500'>
        At eSkot, we offer a comprehensive range of services tailored to
        simplify and enhance your stokvel experience. Whether you're a group
        organizer or a member, our platform provides the tools and features you
        need to manage and grow your stokvel effortlessly.
      </p>

      <div className='flex flex-wrap mt-6'>
        <div className='lg:w-[49%] md:w-full rounded-lg shadow border md:mt-0 xl:p-0 border-brand-primary mx-[0.5%] my-2'>
          <h1 className='text-xl font-bold leading-tight tracking-tight md:text-2xl text-brand-primary p-2'>
            Digital Stokvel Management
          </h1>
          <p className='p-2'>
            <ul className='space-y-1 text-gray-500 list-disc list-inside dark:text-gray-400'>
              <li className='text-normal text-gray-500'>
                Create and manage stokvel groups with ease.
              </li>
              <li className='text-normal text-gray-500'>
                Define group rules, contribution schedules, and payout cycles.
              </li>
              <li className='text-normal text-gray-500'>
                Track all financial activities in real-time with automated
                record-keeping.
              </li>
            </ul>
          </p>
        </div>
        <div className='lg:w-[49%] md:w-full rounded-lg shadow border md:mt-0 xl:p-0 border-brand-primary mx-[0.5%] my-2'>
          <h1 className='text-xl font-bold leading-tight tracking-tight md:text-2xl text-brand-primary p-2'>
            Secure Contributions and Payouts
          </h1>
          <p className='p-2'>
            <ul className='space-y-1 text-gray-500 list-disc list-inside dark:text-gray-400'>
              <li className='text-normal text-gray-500'>
                Enable members to contribute funds securely through multiple
                payment options, including bank transfers, mobile money, and
                debit orders.
              </li>
              <li className='text-normal text-gray-500'>
                Schedule payouts based on group policies and ensure timely
                disbursements to members.
              </li>
            </ul>
          </p>
        </div>
        <div className='lg:w-[49%] md:w-full rounded-lg shadow border md:mt-0 xl:p-0 border-brand-primary mx-[0.5%] my-2'>
          <h1 className='text-xl font-bold leading-tight tracking-tight md:text-2xl text-brand-primary p-2'>
            Financial Reporting and Insights
          </h1>
          <p className='p-2'>
            <ul className='space-y-1 text-gray-500 list-disc list-inside dark:text-gray-400'>
              <li className='text-normal text-gray-500'>
                Generate detailed reports on group finances, including
                contributions, withdrawals, and overall fund growth.
              </li>
              <li className='text-normal text-gray-500'>
                Access visual analytics to help members make informed financial
                decisions.
              </li>
            </ul>
          </p>
        </div>

        <div className='lg:w-[49%] md:w-full rounded-lg shadow border md:mt-0 xl:p-0 border-brand-primary mx-[0.5%] my-2'>
          <h1 className='text-xl font-bold leading-tight tracking-tight md:text-2xl text-brand-primary p-2'>
            Dispute Resolution and Governance Tools
          </h1>
          <p className='p-2'>
            <ul className='space-y-1 text-gray-500 list-disc list-inside dark:text-gray-400'>
              <li className='text-normal text-gray-500'>
                Built-in tools to handle member disputes and ensure group
                governance.
              </li>
              <li className='text-normal text-gray-500'>
                Vote on major group decisions digitally, with transparent
                outcomes.
              </li>
            </ul>
          </p>
        </div>

        <div className='lg:w-[49%] md:w-full rounded-lg shadow border md:mt-0 xl:p-0 border-brand-primary mx-[0.5%] my-2'>
          <h1 className='text-xl font-bold leading-tight tracking-tight md:text-2xl text-brand-primary p-2'>
            Customizable Savings and Investment Plans
          </h1>
          <p className='p-2'>
            <ul className='space-y-1 text-gray-500 list-disc list-inside dark:text-gray-400'>
              <li className='text-normal text-gray-500'>
                Tailor stokvel plans to fit specific goals, such as savings,
                investments, or bulk purchasing.
              </li>
              <li className='text-normal text-gray-500'>
                Collaborate with financial partners to explore additional
                investment opportunities.
              </li>
            </ul>
          </p>
        </div>
      </div>
    </div>
  );
};
export default OurServiceComponent;
