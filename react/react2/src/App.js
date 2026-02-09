import {BrowserRouter} from 'react-router-dom';
import { Link } from "react-router-dom";
import "./menu.css"; 

function MapApp() {
  return (
    <BrowserRouter>
    <div className="a">
      <div className="a"><link>메뉴1</link></div>
      <div className="a"><link>메뉴2</link></div>
      <div className="a"><link>메뉴3</link></div>
    </div>
    </BrowserRouter>
  );
}

export default MapApp;