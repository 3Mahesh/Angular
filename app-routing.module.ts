import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { DeletesComponent } from './deletes/deletes.component';
import { DisplayComponent } from './display/display.component';
import { MenuComponent } from './menu/menu.component';
import { RegisterComponent } from './register/register.component';
import { SearchComponent } from './search/search.component';

const routes: Routes = [
  {path:'display', component:DisplayComponent},
  {path:'menu', component:MenuComponent},
  {path:'register', component:RegisterComponent},
  {path:'search', component:SearchComponent},
  {path:'deletes', component:DeletesComponent},
  {path:'menu/display', component:DisplayComponent},
  {path:'menu/search', component:SearchComponent},
  {path:'menu/deletes', component:DeletesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
