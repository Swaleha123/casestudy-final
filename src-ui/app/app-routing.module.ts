import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { UserportalComponent } from './userportal/userportal.component';
import { AdminportalComponent } from './adminportal/adminportal.component';
import { MockquizComponent } from './mockquiz/mockquiz.component';
import { ExamComponent } from './exam/exam.component';
import { ExamlistComponent } from './examlist/examlist.component';
import { QuizformComponent } from './quizform/quizform.component';



const routes: Routes = [
  {path:"app" , component:AppComponent},

  {path:"" , component:HomeComponent},
  {path:"home" , component:HomeComponent},
  {path:"login", component:LoginComponent},
  {path:"register", component:RegisterComponent},
  {path:"userportal" , component:UserportalComponent},
  {path:"adminportal" , component:AdminportalComponent},
  {path:"mockquiz" , component:MockquizComponent},
  {path:"exam" , component:ExamComponent},
  {path:"examlist" , component:ExamlistComponent},
  {path:"quizform" , component:QuizformComponent},
]


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
