import { Component, OnInit } from '@angular/core';
import { Apis } from 'src/app/shared/mock/api-mock';
import { FiltroService } from 'src/app/shared/filtro.service';

@Component({
  selector: 'app-api-list',
  templateUrl: './api-list.component.html',
  styleUrls: ['./api-list.component.css']
})
export class ApiListComponent implements OnInit {

  constructor(private filt: FiltroService) { }
  filtro: String;
  apis = Apis;
  filro = this.filt;

ngOnInit() {
}

fill(){
  if(this.apis.length === 0 || this.filtro === undefined || this.filtro.trim() === ''){
    return this.apis;
  }
  

  return this.apis.filter(
    v => v.name.toLocaleLowerCase().includes(this.filtro.toLocaleLowerCase())
 );
}

}
