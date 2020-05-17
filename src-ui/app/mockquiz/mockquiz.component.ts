import { Component, OnInit } from '@angular/core';
import { Mockquiz } from '../mockquiz';
import { Validators, FormControl, FormGroup } from '@angular/forms';
import { MockquizService } from '../mockquiz.service';

@Component({
  selector: 'app-mockquiz',
  templateUrl: './mockquiz.component.html',
  styleUrls: ['./mockquiz.component.css']
})
export class MockquizComponent implements OnInit {

  constructor(private mockquizservice:MockquizService) { }



 mockquiz : Mockquiz=new Mockquiz();

 submitted = false;

 ngOnInit() {



 var qid=window.localStorage.getItem("edit-qid");

 if(qid!=null && qid!=""){

  this.mockquizservice.findOneInAll(parseInt(qid))



   .subscribe(



   data => {



    this.mockquiz =data;



    this.mockquizsaveform.setValue(this.mockquiz);



   }) ;







  this.submitted = false;



 }}

 selectFile(event) {



 }



 mockquizsaveform=new FormGroup({



  question:new FormControl('' , [Validators.required ] ),



  answer:new FormControl('' , [Validators.required ] ),



  op1:new FormControl('' , [Validators.required ] ),

  op2:new FormControl('' , [Validators.required ] ),

  op3:new FormControl('' , [Validators.required ] ),

  op4:new FormControl('' , [Validators.required ] ),

  op5:new FormControl('' , [Validators.required ] ),

  op6:new FormControl('' , [Validators.required ] ),

  op7:new FormControl('' , [Validators.required ] ),



  difficulty:new FormControl('',[Validators.required])





 });


 saveMockquiz(saveMockquiz){

  this.mockquiz=new Mockquiz();

  this.mockquiz.question=this.Question.value;

  this.mockquiz.answer=this.Answer.value;

 this.mockquiz.op1=this.Op1.value;

 this.mockquiz.op2=this.Op2.value;

 this.mockquiz.op3=this.Op3.value;

 this.mockquiz.op4=this.Op4.value;

 this.mockquiz.op5=this.Op5.value;

 this.mockquiz.op6=this.Op6.value;

 this.mockquiz.op7=this.Op7.value;

  this.mockquiz.difficulty=this.Difficulty.value;

  this.submitted = true;

  this.save();

 }


 save() {

  this.mockquizservice.saveMockquiz(this.mockquiz)

  .subscribe(data => console.log(data), error => console.log(error));

  this.mockquiz = new Mockquiz();

  window.localStorage.removeItem("edit-qid");

 }

 get Question(){

  return this.mockquizsaveform.get('question');

 }

 get Answer(){

  return this.mockquizsaveform.get('answer');

 }

 get Op1(){

  return this.mockquizsaveform.get('op1');

 }

 get Op2(){



  return this.mockquizsaveform.get('op2');



  }

  get Op3(){



  return this.mockquizsaveform.get('op3');



  }

  get Op4(){



  return this.mockquizsaveform.get('op4');



  }

  get Op5(){



  return this.mockquizsaveform.get('op5');



  }

  get Op6(){



  return this.mockquizsaveform.get('op6');

  }

  get Op7(){

  return this.mockquizsaveform.get('op7');

  }

 get Difficulty(){

  return this.mockquizsaveform.get('difficulty');


 }

 saveMockquizForm(){

  this.submitted=false;

  this.mockquizsaveform.reset();

 }

}
