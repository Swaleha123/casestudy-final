package com.cts.project.model;

import java.util.List;

public class Assessment {


	private String qid;
	public String getQid() {
		return qid;
	}
	public void setQid(String qid) {
		this.qid = qid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	private String question;
	List<String> options;
	private String difficulty;
	@Override
	public String toString() {
		return "Assessment [qid=" + qid + ", question=" + question + ", options=" + options + ", difficulty="
				+ difficulty + "]";
	}

	
}