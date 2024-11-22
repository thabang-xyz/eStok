import { ChangeEvent, FC, KeyboardEvent } from 'react';

interface SearchInputProps {
  placeholder?: string;
  onChange?: (event: ChangeEvent<HTMLInputElement>) => void;
  value?: string;
  onKeyUp?: (event: KeyboardEvent<HTMLInputElement>) => void;
  type?: string;
  maxLength?: number;
}

const CustomInput: FC<SearchInputProps> = ({
  placeholder = '...',
  onChange,
  value,
  onKeyUp,
  type = 'text',
  maxLength = 100,
}) => {
  return (
    <div className='relative w-full mb-4'>
      <input
        type={type}
        className='block p-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-green-900 focus:border-green-900 sm:text-sm h-12 w-full'
        placeholder={placeholder}
        value={value}
        onChange={onChange}
        onKeyUp={onKeyUp}
        maxLength={maxLength}
      />
    </div>
  );
};

export default CustomInput;
