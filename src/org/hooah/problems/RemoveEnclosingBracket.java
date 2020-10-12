package org.hooah.problems;

//Given s String with some characters and brackets.
// Return String after removing Enclosing Brackets. Also provide a set of test cases for the problem
//For Example:
//  (((a))) -> a
//  ((ab)(bc))d -> ((ab)(bc))d
//  () => ""
//  ((a)(bcd)(e)) -> (a)(bcd)(e)
public class RemoveEnclosingBracket {
	
	
	public String removeEnclosingBrackets(String s){
		if(s==null||s.length()==0){
			return s;
		}
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i)!=')'&&s.charAt(i)!='('){
				ans.append(s.charAt(i));
			}
		}
		return ans.toString();
	}
	
	public static void main(String[] args){
		RemoveEnclosingBracket reb = new RemoveEnclosingBracket();
		System.out.println(reb.removeEnclosingBrackets("((ab)(bc))d"));
		System.out.println(reb.removeEnclosingBrackets("()"));
		
	}
}
