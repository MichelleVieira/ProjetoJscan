import { routing } from './app.routing';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { GestorComponent } from './gestor/gestor.component';
import { CadastrarApiComponent } from './gestor/cadastrar-api/cadastrar-api.component';
import { CadastrarFuncionarioComponent } from './gestor/cadastrar-funcionario/cadastrar-funcionario.component';
import { DetalhamentoApiComponent } from './desenvolvedor/detalhamento-api/detalhamento-api.component';
import { ApisCadastradasComponent } from './desenvolvedor/apis-cadastradas/apis-cadastradas.component';
import { SideBarComponent } from './sideNav-bar/side-bar/side-bar.component';
import { NavBarComponent } from './sideNav-bar/nav-bar/nav-bar.component';
import { PcListComponent } from './lists/pc-list/pc-list.component';
import { ApiListComponent } from './lists/api-list/api-list.component';
import { DesenvolvedorComponent } from './desenvolvedor/desenvolvedor.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    AppComponent,
    GestorComponent,
    DesenvolvedorComponent,
    CadastrarApiComponent,
    CadastrarFuncionarioComponent,
      ApisCadastradasComponent,
      NavBarComponent,
      SideBarComponent,
      DetalhamentoApiComponent,
      PcListComponent,
      ApiListComponent
      
    
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
