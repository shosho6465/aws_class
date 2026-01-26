import ReactDOM from 'react-dom/client';
import App from './App';
import App2 from './App2';
import App3 from './App3';
import App6 from './App6';

// id가 id인 요소를 찾아 리액트 DOM 루트로 만듬
const root = ReactDOM.createRoot(document.getElementById('root'));
//최상위 요소 안에 App 컴포넌트를 배치해서 렌더링해라.
root.render(
    //<App />
    //<App2 />
    //<App3 />
    //<App4 />
    //<App6 />
    <App7 />
);

