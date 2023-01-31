import logo from "./logo.svg";
// import "./App.css";

import React from "react";
import "./Nav.css";
import "./Message.css";
import "./Forecast.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { icon, library } from "@fortawesome/fontawesome-svg-core";
import { faHome } from "@fortawesome/free-solid-svg-icons";
import { fab } from "@fortawesome/free-solid-svg-icons";
import cloudy from "./images/small/cloudy.png";
import wind from "./images/wind.png";
import humidity from "./images/humidity.png";
import pression from "./images/pression.png";
//import bigRain from "./images/big_rain.png";
import dewPoint from "./images/dew_point.png";
import uv from "./images/uv.png";
import pollution from "./images/pollution.png";
import flash from "./images/small/flash.png";
import rain from "./images/small/rain.png";
import sunny from "./images/small/sunny.png";
import { Outlet, Link } from "react-router-dom";
import { Line } from "react-chartjs-2";
import ForecastBadge from "./ForecastBadgeComponent";

import {
  faCalendar,
  faClock,
  faChartBar,
  faPowerOff,
  faSun,
  faExclamationCircle,
  faLocationArrow,
} from "@fortawesome/fontawesome-free-solid";
import {WeatherControllerApi} from "./api/WeatherControllerApi";
import {ApiClient} from "./ApiClient";
import ReactDOM from "react-dom";
library.add(
  faCalendar,
  faClock,
  faChartBar,
  faPowerOff,
  faSun,
  faExclamationCircle,
  faLocationArrow
);

class Forecast extends React.Component {
  constructor(props, context) {
    super(props, context);
    this.forecast = null;
    const api = new WeatherControllerApi(new ApiClient());
    this.fetchWeatherForecast(api);
  }

  fetchWeatherForecast(weatherControllerApi) {
    weatherControllerApi.getTenDaysForecast(
        (error, data, response) => {
          if (error) {
            console.error(error);
            ReactDOM.render(
                <div id="main">
                  <p className="loading_info">Błąd połączenia z serwerem. Spróbuj ponownie później. </p>
                  )
                </div>,
                document.getElementById("updatePlace"));
          }
          else {
            console.log('API called successfully. Returned data: ' + data);
            this.forecast = data
            ReactDOM.render(
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
                      {this.forecast.prognozy.map((dayForecast, i) => <li><ForecastBadge danePogodoweDto={dayForecast} /></li>)}
                    </ul>
                  </main>
                </div>,
                document.getElementById("updatePlace")
            )
          }
        }
    )
  }

  render() {
    return (
        <div id="updatePlace">
          <div id="main">
            <p class="loading_info">Pobieranie danych z serwera...</p>
          </div>
        </div>
    );
  }
}


export default Forecast;
