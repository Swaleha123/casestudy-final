package com.cts.project.model;

import java.util.HashMap;
import java.util.Map;

public class Answers {
	Map<String,String> ans=new HashMap<String,String>();

	@Override
	public String toString() {
		return "Answers [ans=" + ans + "]";
	}

	public Map<String, String> getAns() {
		return ans;
	}

	public void setAns(Map<String, String> ans) {
		this.ans = ans;
	}

	
}
