import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Answers } from './answers';

@Injectable({
  providedIn: 'root'
})
export class QuizformService {

  
 private baseUrl = 'http://localhost:8099/TestService/mockquiz';

 constructor(private http:HttpClient) { }



 expert(): Observable<any> {

  const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa('vaishu:vaishu') });

  return this.http.get(`${this.baseUrl}`+'/expert',{headers});

  }
  saveAnswers(answers: any): Observable<any> {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa('vaishu:vaishu') });
    console.log(answers);
    return this.http.post(`${this.baseUrl}`+'/saveAnswers',answers,{headers});
  }
}
