import { Component, OnInit } from '@angular/core';

import { Exam } from 'src/app/exam';

import { FormGroup, Validators, FormControl } from '@angular/forms';

import { ExamService } from 'src/app/exam.service';



@Component({

 selector: 'app-exam',

 templateUrl: './exam.component.html',

 styleUrls: ['./exam.component.css']

})

export class ExamComponent implements OnInit {



 constructor(private examservice:ExamService) { }



 exam : Exam=new Exam();

 submitted = false;

 ngOnInit() {



  var testid=window.localStorage.getItem("edit-testid");

 if(testid!=null && testid!=""){

  this.examservice.findOneInAll(testid)



   .subscribe(



   data => {



    this.exam =data;



    this.examsaveform.setValue(this.exam);



   }) ;







  this.submitted = false;



 }}

 selectFile(event) {



 }



 examsaveform=new FormGroup({



  testid:new FormControl('' , [Validators.required ] ),

  result:new FormControl('' , [Validators.required ] ),



  username:new FormControl('',[Validators.required])





 });







 saveExam(saveExam){



  this.exam=new Exam();

 this.exam.testid=this.Testid.value;

 this.exam.result=this.Result.value;

  this.exam.username=this.Username.value;

  this.submitted = true;

  this.save();

 }





 save() {



  this.examservice.saveExam(this.exam)



  .subscribe(data => console.log(data), error => console.log(error));



  this.exam = new Exam();

  window.localStorage.removeItem("edit-testid");

 }



  get Testid(){



  return this.examsaveform.get('testid');



  }

  get Result(){



  return this.examsaveform.get('result');



  }

 get Username(){



  return this.examsaveform.get('username');



 }



 saveExamForm(){



  this.submitted=false;



  this.examsaveform.reset();



 }



}

