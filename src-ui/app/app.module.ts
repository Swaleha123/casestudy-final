import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UserportalComponent } from './userportal/userportal.component';
import { AdminportalComponent } from './adminportal/adminportal.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MockquizComponent } from './mockquiz/mockquiz.component';
import { ExamComponent } from './exam/exam.component';
import { ExamlistComponent } from './examlist/examlist.component';
import { QuizformComponent } from './quizform/quizform.component';
import { MyHttpInterceptorService } from './my-http-interceptor.service';

@NgModule({
  declarations: [
    AppComponent,
  
    RegisterComponent,
    LoginComponent,
    HomeComponent,
    UserportalComponent,
    AdminportalComponent,
    MockquizComponent,
    ExamComponent,
    ExamlistComponent,
    QuizformComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    {
      provide:HTTP_INTERCEPTORS,
      useClass:MyHttpInterceptorService,
      multi:true
    }
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
