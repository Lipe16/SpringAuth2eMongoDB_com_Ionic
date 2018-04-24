
import { Injectable } from '@angular/core';
import { Http, RequestOptions } from '@angular/http';
import { Utils } from '../../entity/Utils';

/*
  Generated class for the PerfilProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class PerfilProvider {



  private loginUrl: string;
  public handleError: any;
  public perfilURL: string;



  constructor(public http: Http) {
    this.perfilURL = Utils.getUrlBackend() + "perfil/";
  }

  public getPerfis() {
      return this.http.get(this.perfilURL).map(res => res.json());
  }


}
