import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { RequestOptions } from '@angular/http';
import { CookieService } from 'angular2-cookie/core';
import { LoginPage } from '../login/login';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  constructor(public navCtrl: NavController, public cookieService: CookieService,
    public requestOptions:RequestOptions) {
 }

  public logout() {
    this.cookieService.removeAll();
    this.requestOptions.headers.set('Authorization', "Bearer ");
    this.navCtrl.setRoot(LoginPage);
    
  }

}
