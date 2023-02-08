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
import {ApiClient} from '../ApiClient';

/**
 * The HintDto model module.
 * @module model/HintDto
 * @version 1.0.0
 */
export class HintDto {
  /**
   * Constructs a new <code>HintDto</code>.
   * @alias module:model/HintDto
   * @class
   */
  constructor() {
  }

  /**
   * Constructs a <code>HintDto</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/HintDto} obj Optional instance to populate.
   * @return {module:model/HintDto} The populated <code>HintDto</code> instance.
   */
  static constructFromObject(data, obj) {
    if (data) {
      obj = obj || new HintDto();
      if (data.hasOwnProperty('title'))
        obj.title = ApiClient.convertToType(data['title'], 'String');
      if (data.hasOwnProperty('description'))
        obj.description = ApiClient.convertToType(data['description'], 'String');
    }
    return obj;
  }
}

/**
 * @member {String} title
 */
HintDto.prototype.title = undefined;

/**
 * @member {String} description
 */
HintDto.prototype.description = undefined;
