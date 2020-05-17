import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ExamService } from '../exam.service';
import { Exam } from '../exam';
import { Observable } from 'rxjs';
import { FormGroup, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-examlist',
  templateUrl: './examlist.component.html',
  styleUrls: ['./examlist.component.css']
})
export class ExamlistComponent implements OnInit {
  isupdated: boolean;
  submitted: boolean;

  constructor(private router :Router,private examservice: ExamService) { }

  examList: Observable<Exam[]>;  
  ngOnInit() {

    this.examservice.getAllexam().subscribe(data => {

      
      this.examList = data;

    })

  }
  examupdateform=new FormGroup({

    testid:new FormControl(),
  
    result:new FormControl(),
  
    username:new FormControl(),
  
  
   });
  
    get Testid(){

    return this.examupdateform.get('testid');

    }
    get Result(){
  
    return this.examupdateform.get('result');
  
    }
  
   get Username(){
  
    return this.examupdateform.get('username');

   }
   saveExamForm(){
    this.submitted=false;

    this.examupdateform.reset();
  
   }

  }
  