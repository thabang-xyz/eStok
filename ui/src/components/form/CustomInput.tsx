import { ChangeEvent, FC, KeyboardEvent } from 'react';

interface SearchInputProps {
  placeholder?: string;
  onChange?: (event: ChangeEvent<HTMLInputElement>) => void;
  value?: string;
  onKeyUp?: (event: KeyboardEvent<HTMLInputElement>) => void;
}

const CustomInput: FC<SearchInputProps> = ({
  placeholder = '...',
  onChange,
  value,
  onKeyUp,
}) => {
  return (
    <div className='relative w-full mb-4'>
      <input
        type='text'
        className='block pl-10 pr-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-green-900 focus:border-green-900 sm:text-sm h-14 md:w-full lg:w-1/3'
        placeholder={placeholder}
        value={value}
        onChange={onChange}
        onKeyUp={onKeyUp}
      />
    </div>
  );
};

export default CustomInput;
