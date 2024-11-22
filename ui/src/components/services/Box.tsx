const Box = ({
  title,
  description,
  image,
}: {
  title: string;
  description: string;
  image: string;
}) => {
  return (
    <div className='w-[49%] rounded-lg shadow border md:mt-0 xl:p-0 border-brand-primary mx-[0.5%] my-2'>
      <img src={image} alt={title} className='rounded-t-lg' />
      <div className='h-10 bg-brand-primary'>
        <h1 className='text-xl font-bold leading-tight tracking-tight md:text-2xl text-white p-2'>
          {title}
        </h1>
      </div>

      <p className='p-2'>{description}</p>
    </div>
  );
};
export default Box;
