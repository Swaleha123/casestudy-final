import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError} from 'rxjs';
import { catchError ,retry} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MyHttpInterceptorService implements HttpInterceptor{

  constructor(private router:Router) { }
  intercept(req:HttpRequest<any>, next:HttpHandler): Observable<HttpEvent<any>> {
req=req.clone({
  setHeaders:{
    Authorization: sessionStorage.getItem('token')
  }
});
return next.handle(req).pipe(
  retry(1),
  catchError((error:HttpErrorResponse) =>{
    let errorMessage = '';
    if(error.error instanceof ErrorEvent){
      errorMessage=`Error: ${error.error.message}`;
    }
    else{
      errorMessage=`Error Code: ${error.status}\nMessage:${error.message}`;
    }
    window.alert(errorMessage);
    this.router.navigate(['/home']);
    return throwError(errorMessage);
  })
);
  }

}
