import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';



@Injectable({

 providedIn: 'root'

})

export class ExamService {



 private baseUrl = 'http://localhost:8099/Exam/ExamPortal';

 constructor(private http:HttpClient) { }

 getAllexam(): Observable<any> {  
  return this.http.get(`${this.baseUrl}`+'/getAllexam');  
} 

  saveExam(exam: object): Observable<object> {



  return this.http.post(`${this.baseUrl}`+'/saveExam', exam);



  }



  deleteExam(testid: String): Observable<any> {



   return this.http.delete(`${this.baseUrl}/deleteExam/${testid}`);



  }



  findOneInAll(testid: String): Observable<any> {



   return this.http.get(`${this.baseUrl}/findOneInAll5/${testid}`);



  }

  updateExam(testid: String, value: any): Observable<any> {



   return this.http.put(`${this.baseUrl}/updateExam/${testid}`, value);



  }

}

