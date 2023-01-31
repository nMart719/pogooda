import logo from "./logo.svg";
// import "./App.css";
import "./Nav.css";
import "./Message.css";
import "./Forecast.css";
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
import flash from "./images/flash.png";
import rain from "./images/rain.png";
import sunny from "./images/sunny.png";
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

const Forecast = () => {
  return (
    <div id="main">
      {/* <div className="message">
        <h1>
          <FontAwesomeIcon icon={["fas", "exclamation-circle"]} />
          &nbsp; Add some minerals!
        </h1>
        <p>
          There will be too rainy and your plants are going to be sick soon!
        </p>
      </div> */}

      <main>
        <ul id="days">
          <li>
            <header className="center biggerText">SUN</header>
            <img src={cloudy} alt="cloudy" height={"100px"} />
            <p className="center biggerText">+15&#176;C</p>
            <p>
              <img
                src={wind}
                alt="wind icon"
                height={"20px"}
                className="smallIcon"
              />
              12 km/h
            </p>
            <p>
              <img
                src={humidity}
                alt="humidity icon"
                height={"18px"}
                className="smallIcon"
              />
              2%
            </p>
          </li>
          <li>
            <header className="center biggerText">SUN</header>
            <img src={cloudy} alt="cloudy" height={"100px"} />
            <p className="center biggerText">+15&#176;C</p>
            <p>
              <img
                src={wind}
                alt="wind icon"
                height={"20px"}
                className="smallIcon"
              />
              12 km/h
            </p>
            <p>
              <img
                src={humidity}
                alt="humidity icon"
                height={"18px"}
                className="smallIcon"
              />
              2%
            </p>
          </li>
          <li>
            <header className="center biggerText">SUN</header>
            <img src={cloudy} alt="cloudy" height={"100px"} />
            <p className="center biggerText">+15&#176;C</p>
            <p>
              <img
                src={wind}
                alt="wind icon"
                height={"20px"}
                className="smallIcon"
              />
              12 km/h
            </p>
            <p>
              <img
                src={humidity}
                alt="humidity icon"
                height={"18px"}
                className="smallIcon"
              />
              2%
            </p>
          </li>
          <li>
            <header className="center biggerText">SUN</header>
            <img src={cloudy} alt="cloudy" height={"100px"} />
            <p className="center biggerText">+15&#176;C</p>
            <p>
              <img
                src={wind}
                alt="wind icon"
                height={"20px"}
                className="smallIcon"
              />
              12 km/h
            </p>
            <p>
              <img
                src={humidity}
                alt="humidity icon"
                height={"18px"}
                className="smallIcon"
              />
              2%
            </p>
          </li>
        </ul>
      </main>
    </div>
  );
};

export default Forecast;
