import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PcDetailComponent } from './pc/pc-detail/pc-detail.component';
import { IndexComponent } from './gestor/index/index.component';

const routes: Routes = [
  {path:"", component:IndexComponent},
  { path: 'detalhe', component: PcDetailComponent},
  //{ path: 'gestor', loadChildren: 'src\app\gestor\gestor.module#GestorModule'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
