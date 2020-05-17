package com.cts.project.pojos;

import javax.persistence.*;
@Entity
@Table(name="exam")
public class Exam {
	@Id
private String testid;
private String result;
   private String username;
   @Override
   public String toString() {
   	return "Exam [testid=" + testid + ", result=" + result + ", username=" + username + "]";
   }
   public String getTestid() {
 		return testid;
 	}
 	public void setTestid(String testid) {
 		this.testid = testid;
 	}
 	public String getResult() {
 		return result;
 	}
 	public void setResult(String result) {
 		this.result = result;
 	}
 	public String getUsername() {
 		return username;
 	}
 	public void setUsername(String username) {
 		this.username = username;
 	}
}
