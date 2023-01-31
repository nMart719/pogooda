import logo from "./logo.svg";
// import "./App.css";
import "./Nav.css";
import "./Message.css";
import "./Actual.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { icon, library } from "@fortawesome/fontawesome-svg-core";
import { faHome } from "@fortawesome/free-solid-svg-icons";
import { fab } from "@fortawesome/free-solid-svg-icons";
import cloudy from "./images/cloudy.png";
import wind from "./images/wind.png";
import humidity from "./images/humidity.png";
import pression from "./images/pression.png";
//import bigRain from "./images/big_rain.png";
import dewPoint from "./images/dew_point.png";
import uv from "./images/uv.png";
import pollution from "./images/pollution.png";
import { Outlet, Link } from "react-router-dom";
import { Line } from "react-chartjs-2";
import {
  faCalendar,
  faClock,
  faChartBar,
  faPowerOff,
  faSun,
  faExclamationCircle,
  faLocationArrow,
} from "@fortawesome/fontawesome-free-solid";
library.add(
  faCalendar,
  faClock,
  faChartBar,
  faPowerOff,
  faSun,
  faExclamationCircle,
  faLocationArrow
);

const Layout = () => {
  return (
    <div id="main">
      <aside>
        <div id="logo">
          poG
          <FontAwesomeIcon icon={["fas", "sun"]} />
          <FontAwesomeIcon icon={["fas", "sun"]} />
          Da
        </div>
        <nav>
          <ul>
            <li className="nav">
              <Link to="/">
                <FontAwesomeIcon icon={["fas", "clock"]} />
              </Link>
            </li>
            <li>
              <Link to="/forecast">
                <FontAwesomeIcon icon={["fas", "calendar"]} />
              </Link>
            </li>
            <li>
              <a>
                <FontAwesomeIcon icon={["fas", "chart-bar"]} />
              </a>
            </li>
            <li>
              <a>
                <FontAwesomeIcon icon={["fas", "power-off"]} />
              </a>
            </li>
          </ul>
        </nav>
      </aside>
      <Outlet />
    </div>
  );
};

export default Layout;
