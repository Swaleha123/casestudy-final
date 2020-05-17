import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})

@Injectable({

 providedIn: 'root'

})

export class MockquizService {



 private baseUrl = 'http://localhost:8099/TestService/mockquiz';

 constructor(private http:HttpClient) { }



 getAllMockquiz(): Observable<any> {



  return this.http.get(`${this.baseUrl}`+'/getAllMockquiz');



  }

  saveMockquiz(mockquiz: object): Observable<object> {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa('vaishu:vaishu')  });
   //headers.set('Content-Type', 'application/json');
  
  
  return this.http.post(`${this.baseUrl}`+'/saveMockquiz', mockquiz,{headers});



  }



  deleteMockquiz(qid: number): Observable<any> {



   return this.http.delete(`${this.baseUrl}/deleteMockquiz/${qid}`);



  }


  findOneInAll(qid: number): Observable<any> {



   return this.http.get(`${this.baseUrl}/findOneInAll4/${qid}`);

  }

  updateMockquiz(qid: number, value: any): Observable<any> {



   return this.http.put(`${this.baseUrl}/updateMockquiz/${qid}`, value);


  }

}