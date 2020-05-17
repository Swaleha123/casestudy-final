package com.cts.project.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mockquiz")
public class Mockquiz {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	int qid;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getOp1() {
		return op1;
	}
	public void setOp1(String op1) {
		this.op1 = op1;
	}
	public String getOp2() {
		return op2;
	}
	public void setOp2(String op2) {
		this.op2 = op2;
	}
	public String getOp3() {
		return op3;
	}
	public void setOp3(String op3) {
		this.op3 = op3;
	}
	public String getOp4() {
		return op4;
	}
	public void setOp4(String op4) {
		this.op4 = op4;
	}
	public String getOp5() {
		return op5;
	}
	public void setOp5(String op5) {
		this.op5 = op5;
	}
	public String getOp6() {
		return op6;
	}
	public void setOp6(String op6) {
		this.op6 = op6;
	}
	public String getOp7() {
		return op7;
	}
	public void setOp7(String op7) {
		this.op7 = op7;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	String question;
	String answer;
	String op1,op2,op3,op4,op5,op6,op7;
	String difficulty;
	@Override
	public String toString() {
		return "Mockquiz [qid=" + qid + ", question=" + question + ", answer=" + answer + ", op1=" + op1 + ", op2="
				+ op2 + ", op3=" + op3 + ", op4=" + op4 + ", op5=" + op5 + ", op6=" + op6 + ", op7=" + op7
				+ ", difficulty=" + difficulty + "]";
	}
	
	
	
}
