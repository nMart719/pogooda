import logo from "./logo.svg";
// import "./App.css";
import "./global.css";
import "./Layout.css";
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
import dewPoint from "./images/dew_point.png";
import uv from "./images/uv.png";
import pollution from "./images/pollution.png";
import { Outlet, Link } from "react-router-dom";
import { Line } from "react-chartjs-2";
import React from "react";
import BigIcon from "./BigIconComponent";
import {
	showSuccessMessage,
	showErrorMessage,
	showInfoMessage,
	showWarningMessage,
} from "./notifications/notofications";

import location from "./images/small/location.png";
import {
	faCalendar,
	faClock,
	faChartBar,
	faPowerOff,
	faSun,
	faExclamationCircle,
	faLocationArrow,
} from "@fortawesome/fontawesome-free-solid";
import { WeatherControllerApi } from "./api/WeatherControllerApi";
import { ApiClient } from "./ApiClient";
import { AktualnaPogodaDto } from "./model/AktualnaPogodaDto";
import ReactDOM from "react-dom";
import { HintsControllerApi } from "./api/HintsControllerApi";
import { wait } from "@testing-library/user-event/dist/utils";
library.add(
	faCalendar,
	faClock,
	faChartBar,
	faPowerOff,
	faSun,
	faExclamationCircle,
	faLocationArrow
);

class Location extends React.Component {
	constructor(props, context) {
		super(props, context);
		this.actualWeather = null;
		const weatherApi = new WeatherControllerApi(new ApiClient());
		this.fetchActualWeatherInfo(weatherApi);
		const hintsApi = new HintsControllerApi(new ApiClient());
		this.fetchHints(hintsApi);
	}

	fetchHints(hintsApi) {
		hintsApi.readActualHints((error, data, response) => {
			if (error) console.error(error);
			else {
				console.log("Hints API called successfully. Returned data: " + data);
				var actualTime = 0;
				data.forEach((hint) => {
					wait(actualTime).then(() =>
						showWarningMessage(hint.title, hint.description)
					);
					actualTime += 3000;
				});
			}
		});
	}

	fetchActualWeatherInfo(weatherControllerApi) {
		weatherControllerApi.getActualWeatherInfo((error, data, response) => {
			if (error) {
				console.error(error);
				ReactDOM.render(
					<div id="main">
						<p className="loading_info">Error connecting to server. </p>
					</div>,
					document.getElementById("updatePlace")
				);
			} else {
				console.log("Weather API called successfully. Returned data: " + data);
				this.actualWeather = data;
				ReactDOM.render(
					<div id="main">
						<section>
							<div id="gap"></div>
							<div>
								<label for="location" class="placeholder">
									<img
										src={location}
										alt="wind icon"
										height={"25px"}
										className="smallIcon"
									/>
									&nbsp;Change location to:
								</label>

								<select id="location">
									<option>Kyiv</option>
									<option>Kharkiv</option>
								</select>
							</div>
						</section>

						<div id="snackbar-fixed-container"></div>
					</div>,
					document.getElementById("updatePlace")
				);
			}
		});
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

export default Location;
