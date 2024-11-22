import { FC } from 'react';
import { Link } from 'react-router-dom';

interface LinkProps {
  href: string;
  title: string;
}
const CustomLink: FC<LinkProps> = ({ href = '', title = '' }) => {
  return (
    <li>
      <Link
        to={href}
        className='block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-brand-primary md:p-0 md:dark:hover:text-blue-500 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700 uppercase'
      >
        {title}
      </Link>
    </li>
  );
};
export default CustomLink;
