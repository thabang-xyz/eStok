import React from 'react';
interface ButtonProps {
  label: string;
  onClick?: () => void;
  type?: 'button' | 'submit' | 'reset';
  variant?: 'primary' | 'secondary' | 'danger';
  size?: 'small' | 'medium' | 'large';
  active?: boolean;
}

const CustomButton: React.FC<ButtonProps> = ({
  label,
  onClick,
  type = 'button',
  variant = 'primary',
  size = 'medium',
}) => {
  const baseStyles =
    'font-semibold rounded focus:outline-none focus:ring-2 focus:ring-offset-2 transition ease-in-out duration-150 h-12 sm:w-auto w-full';

  let sizeStyles = '';
  if (size === 'small') sizeStyles = 'px-2 py-1 text-sm';
  if (size === 'medium') sizeStyles = 'px-5 py-2 text-base';
  if (size === 'large') sizeStyles = 'px-6 py-3 text-lg';

  let variantStyles = '';
  switch (variant) {
    case 'primary':
      variantStyles = 'bg-green-900 text-white hover:bg-green-700 h-10';
      break;
    case 'secondary':
      variantStyles =
        'bg-brand-primary hover:bg-green-900 hover:text-white h-10 text-white';
      break;
    case 'danger':
      variantStyles = 'bg-red-600 text-white hover:bg-red-700 h-10';
      break;
    default:
      variantStyles = 'bg-blue-600 text-white hover:bg-blue-700 h-10';
  }

  return (
    <button
      type={type}
      onClick={onClick}
      className={`${baseStyles} ${sizeStyles} ${variantStyles}`}
    >
      {label}
    </button>
  );
};

export default CustomButton;
