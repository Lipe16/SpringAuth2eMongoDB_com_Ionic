import { Component } from '@angular/core';
import { IonicPage, NavController} from 'ionic-angular';
import { PerfilProvider } from '../../providers/perfil/perfil';

/**
 * Generated class for the PerfisPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-perfis',
  templateUrl: 'perfis.html',
})
export class PerfisPage {

  public perfis:any;
  
  constructor(public navCtrl: NavController, public perfilService: PerfilProvider) {
      
     this.perfilService.getPerfis().subscribe(

        response => this.perfis = response
      );
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad PerfisPage');
  }

}
