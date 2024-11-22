import { BrowserRouter } from 'react-router-dom';
import { initFlowbite } from 'flowbite';
import './app.css';
import RootNavigation from './components/common/navigation/RootNavigation';
import { useEffect } from 'react';

function App() {
  useEffect(() => {
    initFlowbite();
  }, []);
  return (
    <BrowserRouter>
      <RootNavigation />;
    </BrowserRouter>
  );
}

export default App;
