/*
 * API back-endu aplikacji PoGOODa
 * Back-end aplikacji PoGOODa do użycia na projekcie z przedmiotu \"Projektowanie oprogramowania\". API zgodne z OAS v3.
 *
 * OpenAPI spec version: 1.0.0
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 *
 * Swagger Codegen version: 3.0.36
 *
 * Do not edit the class manually.
 *
 */
import { ApiClient } from "../ApiClient";
import { AktualnaPogodaDto } from "../model/AktualnaPogodaDto";
import { PrognozaPogodyDto } from "../model/PrognozaPogodyDto";

/**
 * WeatherController service.
 * @module api/WeatherControllerApi
 * @version 1.0.0
 */
export class WeatherControllerApi {
	/**
    * Constructs a new WeatherControllerApi. 
    * @alias module:api/WeatherControllerApi
    * @class
    * @param {module:ApiClient} [apiClient] Optional API client implementation to use,
    * default to {@link module:ApiClient#instanc
    e} if unspecified.
    */
	constructor(apiClient) {
		this.apiClient = apiClient || ApiClient.instance;
	}

	/**
	 * Callback function to receive the result of the getActualWeatherInfo operation.
	 * @callback moduleapi/WeatherControllerApi~getActualWeatherInfoCallback
	 * @param {String} error Error message, if any.
	 * @param {module:model/AktualnaPogodaDto{ data The data returned by the service call.
	 * @param {String} response The complete HTTP response.
	 */

	/**
	 * @param {module:api/WeatherControllerApi~getActualWeatherInfoCallback} callback The callback function, accepting three arguments: error, data, response
	 * data is of type: {@link <&vendorExtensions.x-jsdoc-type>}
	 */
	getActualWeatherInfo(callback) {
		debugger;
		let postBody = null;

		let pathParams = {};
		let queryParams = {};
		let headerParams = {};
		let formParams = {};

		let authNames = [];
		let contentTypes = [];
		let accepts = ["*/*"];
		let returnType = AktualnaPogodaDto;

		return this.apiClient.callApi(
			"/weather/actual",
			"GET",
			pathParams,
			queryParams,
			headerParams,
			formParams,
			postBody,
			authNames,
			contentTypes,
			accepts,
			returnType,
			callback
		);
	}
	/**
	 * Callback function to receive the result of the getTenDaysForecast operation.
	 * @callback moduleapi/WeatherControllerApi~getTenDaysForecastCallback
	 * @param {String} error Error message, if any.
	 * @param {module:model/PrognozaPogodyDto{ data The data returned by the service call.
	 * @param {String} response The complete HTTP response.
	 */

	/**
	 * @param {module:api/WeatherControllerApi~getTenDaysForecastCallback} callback The callback function, accepting three arguments: error, data, response
	 * data is of type: {@link <&vendorExtensions.x-jsdoc-type>}
	 */
	getTenDaysForecast(callback) {
		let postBody = null;

		let pathParams = {};
		let queryParams = {};
		let headerParams = {};
		let formParams = {};

		let authNames = [];
		let contentTypes = [];
		let accepts = ["*/*"];
		let returnType = PrognozaPogodyDto;

		return this.apiClient.callApi(
			"/weather/forecast",
			"GET",
			pathParams,
			queryParams,
			headerParams,
			formParams,
			postBody,
			authNames,
			contentTypes,
			accepts,
			returnType,
			callback
		);
	}
}
