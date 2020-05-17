import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';  
import { Observable } from 'rxjs';  
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {
  private baseUrl = 'http://localhost:8099/TestService/UserPortal';  
  
  constructor(private http:HttpClient) { }  
  getAllUsers(): Observable<any> {  
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa('user:password') });
    return this.http.get(`${this.baseUrl}`+'/getAllUsers',{headers});  
  }  
  
  saveUser(user: object): Observable<object> { 
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa('vaishu:vaishu') }); 
    return this.http.post(`${this.baseUrl}`+'/saveUser', user,{headers});  
  }  
  deleteUser(username:string): Observable<any> {  
    return this.http.delete(`${this.baseUrl}/deleteUser/${username}`);  
  }  
  
  findOneInAll1(username: string): Observable<any> {  
    return this.http.get(`${this.baseUrl}/findOneInAll1/${username}`);  
  }  
  findByUsernameAndPassword(username: string,password :string): Observable<User> {  
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa('user:password') });
    return this.http.get<User>(this.baseUrl+'/findByUsernameAndPassword/'+username+'/'+password,{headers});  
  }  
  
  updateUser(username: string, value: any): Observable<any> {  
    return this.http.put(`${this.baseUrl}/updateUser/${username}`, value);  
  }  
}



