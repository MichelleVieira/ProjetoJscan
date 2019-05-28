import { Injectable } from '@angular/core';
import { Api } from 'src/app/shared/models/api';

@Injectable({
  providedIn: 'root'
})
export class FiltroService {

  constructor() { }

  fill(apis: Api[], filtro: string){
    if(apis.length === 0 || filtro === undefined || filtro.trim() === ''){
      return apis;
    }

    return apis.filter(
      v => v.name.toLocaleLowerCase().includes(filtro.toLocaleLowerCase())
   );
  }

}
