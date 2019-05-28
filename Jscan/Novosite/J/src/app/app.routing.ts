import { DetalhamentoApiComponent } from './desenvolvedor/detalhamento-api/detalhamento-api.component';
import { CadastrarApiComponent } from './gestor/cadastrar-api/cadastrar-api.component';
import { DesenvolvedorComponent } from './desenvolvedor/desenvolvedor.component';
import { CadastrarFuncionarioComponent } from './gestor/cadastrar-funcionario/cadastrar-funcionario.component';
import { Routes, RouterModule} from '@angular/router';
import { ModuleWithProviders } from '@angular/core';
import { GestorComponent } from './gestor/gestor.component';


const APP_ROUTES: Routes = [
    { path: 'cadFuncionario', component: CadastrarFuncionarioComponent },
     { path: '', component: GestorComponent},
     { path: 'cadastrar', component: CadastrarApiComponent},
     { path: 'desenvolvedor', component: DesenvolvedorComponent},
     { path: 'cadastradas', component: DesenvolvedorComponent},
     { path: 'detalhamento', component: DetalhamentoApiComponent}
];

export const routing: ModuleWithProviders = RouterModule.forRoot(APP_ROUTES);