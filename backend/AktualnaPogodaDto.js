/*
 * API back-endu aplikacji PoGOODa
 * Back-end aplikacji PoGOODa do użycia na projekcie z przedmiotu \"Projektowanie oprogramowania\". API zgodne z OAS v3.
 *
 * OpenAPI spec version: 1.0.0
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 *
 * Swagger Codegen version: 3.0.37
 *
 * Do not edit the class manually.
 *
 */
import {ApiClient} from '../ApiClient';
import {DanePogodoweDto} from './DanePogodoweDto';

/**
 * The AktualnaPogodaDto model module.
 * @module model/AktualnaPogodaDto
 * @version 1.0.0
 */
export class AktualnaPogodaDto {
  /**
   * Constructs a new <code>AktualnaPogodaDto</code>.
   * @alias module:model/AktualnaPogodaDto
   * @class
   * @param miejsce {String} 
   * @param najnowszyPomiar {module:model/DanePogodoweDto} 
   */
  constructor(miejsce, najnowszyPomiar) {
    this.miejsce = miejsce;
    this.najnowszyPomiar = najnowszyPomiar;
  }

  /**
   * Constructs a <code>AktualnaPogodaDto</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/AktualnaPogodaDto} obj Optional instance to populate.
   * @return {module:model/AktualnaPogodaDto} The populated <code>AktualnaPogodaDto</code> instance.
   */
  static constructFromObject(data, obj) {
    if (data) {
      obj = obj || new AktualnaPogodaDto();
      if (data.hasOwnProperty('miejsce'))
        obj.miejsce = ApiClient.convertToType(data['miejsce'], 'String');
      if (data.hasOwnProperty('najnowszyPomiar'))
        obj.najnowszyPomiar = DanePogodoweDto.constructFromObject(data['najnowszyPomiar']);
    }
    return obj;
  }
}

/**
 * @member {String} miejsce
 */
AktualnaPogodaDto.prototype.miejsce = undefined;

/**
 * @member {module:model/DanePogodoweDto} najnowszyPomiar
 */
AktualnaPogodaDto.prototype.najnowszyPomiar = undefined;
