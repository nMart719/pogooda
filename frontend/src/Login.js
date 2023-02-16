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

class Login extends React.Component {
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
							<div className="nickname">
								<label for="nick-field" className="placeholder">
									Your nickname
								</label>
								<input id="nick-field" type="text" />
							</div>
							<div className="password">
								<label for="pass-field" className="placeholder">
									Your password
								</label>
								<input id="pass-field" type="text" />
							</div>
							<div>
								<button type="submit">&nbsp;&nbsp;Log in&nbsp;&nbsp;</button>
								<Link to="/register">
									<button type="submit">Register</button>
								</Link>
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
					<p class="loading_info">Getting data from server...</p>
				</div>
			</div>
		);
	}
}

export default Login;
