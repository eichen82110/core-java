package org.hooah.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeScore {
	
	//given map,
	//k=empl ids
	//v=arr of direct reports
	//write getScore(id) to count all employees that report direct and indirectly.
	//employees will also write reports about themselves
	
	static final Map<String, List<String>> MAP = new HashMap<>();
	
	EmployeeScore() {
		MAP.put("123", Arrays.asList("345", "567"));
		MAP.put("345", Arrays.asList("678", "789"));
		MAP.put("567", Collections.emptyList());
		MAP.put("678", Collections.emptyList());
		MAP.put("789", Collections.emptyList());
	}
	
	 int getScore(final String id){
		 final Map<String, Integer> directCount = new HashMap<>();
		final List<String> ids = MAP.get(id);
		if(ids.isEmpty()){
			directCount.put(id, 1);
		}else {
			for(String eId : ids) {
				directCount.put(eId, MAP.get(eId).size() +1);
			}
		}
		int count=0;
		for(int dCount:directCount.values()){
			count+=dCount;
		}
		return count;
	}
	
	
	public static void main(String[] args){
	 	EmployeeScore employeeScore = new EmployeeScore();
	 	System.out.println(employeeScore.getScore("123"));//5
		System.out.println(employeeScore.getScore("345"));//3
		
	}
}
