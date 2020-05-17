import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import {FormControl,FormGroup,Validators} from '@angular/forms';
import { User} from '../user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
   
  constructor(private userservice:UserserviceService) { }  
  user : User=new User();  
  submitted = false;  
  ngOnInit() {

    var  username=window.localStorage.getItem("update-username");
    if(username!=null && username!="")
    {
 
    this.userservice.findOneInAll1(username) 
    .subscribe(
      data => {
      this.user =data;
      this.usersaveform.setValue(this.user);
 
      }) ;
 
    this.submitted = false;
 
     }}  
  usersaveform=new FormGroup({ 
    
    username:new FormControl('' , [Validators.required , Validators.minLength(5) ] ),
    password:new FormControl('' , [Validators.required , Validators.minLength(5) ] ),
    usertype:new FormControl('' , [Validators.required , Validators.minLength(1) ] ),   
    email:new FormControl('',[Validators.required,Validators.email]) 
   
  });  
  
  saveUser(saveUser){
  
    
    this.user=new User();     
   
    this.user.username=this.Username.value;  
    this.user.password=this.Password.value; 
    this.user.usertype=this.Usertype.value;  
    this.user.email=this.Email.value;
    this.submitted = true;  
    this.save();  
  } 
 
  save() {  
    this.userservice.saveUser(this.user)  
      .subscribe(data => console.log(data), error => console.log(error));  
    this.user = new User(); 
   window.localStorage.removeItem("update-username") 
  }  
 
  get Username(){  
    return this.usersaveform.get('username');  
  }  
  
  get Password(){  
    return this.usersaveform.get('password');  
  }  
  get Usertype(){  
    return this.usersaveform.get('usertype');  
  }  
  get Email(){  
    return this.usersaveform.get('email');  
  }  

  saveUserForm(){  
    this.submitted=false;  
    this.usersaveform.reset();  
  } 
}
