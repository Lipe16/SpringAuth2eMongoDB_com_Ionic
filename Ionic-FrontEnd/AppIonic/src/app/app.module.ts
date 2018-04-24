import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';

import { AboutPage } from '../pages/about/about';
import { ContactPage } from '../pages/contact/contact';
import { HomePage } from '../pages/home/home';
import { TabsPage } from '../pages/tabs/tabs';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { LoginPageModule } from './../pages/login/login.module';
import { LoginServiceProvider } from '../providers/login-service/login-service';
import { HttpModule } from '@angular/http';
import { CookieService } from 'angular2-cookie/core';
import { PerfilProvider } from '../providers/perfil/perfil';
import {PerfisPage} from '../pages/perfis/perfis';

@NgModule({
  declarations: [
    MyApp,
    AboutPage,
    ContactPage,
    HomePage,
    TabsPage,
    PerfisPage
  ],
  imports: [

    HttpModule,
    LoginPageModule ,
    BrowserModule,
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    AboutPage,
    ContactPage,
    HomePage,
    TabsPage,
    PerfisPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    LoginServiceProvider,
    CookieService,
 
    PerfilProvider
  ]
})
export class AppModule {}
