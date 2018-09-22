package org.hooah.algorithms;

import java.util.HashSet;
import java.util.Hashtable;

public class FindRecurringChar {
	
	private static final String S = "bcaba";
	private static final String S2 = "abca";
	private static final String S3 = "abc";
	private static final String S4 = "dbcaba";
	
	public static void main(String[] args) {
		
		final int iterations=10000;
		long start;
		long totalTime;
		Character c;
		start=System.nanoTime();
		for(int i = 0; i < iterations; i++) {
			c=findFirstRecurringChar2(S);
			assert c!=null && c.compareTo('b')==0;
			c=findFirstRecurringChar2(S2);
			assert c!=null && c.compareTo('a')==0;
			c=findFirstRecurringChar2(S3);
			assert c==null;
			c=findFirstRecurringChar2(S4);
			assert c!=null && c.compareTo('b')==0;
		}
		totalTime=System.nanoTime()-start;
		System.out.println("Hashtable: "+totalTime/iterations);
		start=System.nanoTime();
		for(int i = 0; i < iterations; i++) {
			c=findFirstRecurringChar3(S);
			assert c!=null && c.compareTo('b')==0;
			c=findFirstRecurringChar3(S2);
			assert c!=null && c.compareTo('a')==0;
			c=findFirstRecurringChar3(S3);
			assert c==null;
			c=findFirstRecurringChar3(S4);
			assert c!=null && c.compareTo('b')==0;
		}
		totalTime=System.nanoTime()-start;
		System.out.println("HashSet: "+totalTime/iterations);
		
		start=System.nanoTime();
		for(int i = 0; i < iterations; i++) {
			c=findFirstRecurringChar(S);
			assert c!=null && c.compareTo('b')==0;
			c=findFirstRecurringChar(S2);
			assert c!=null && c.compareTo('a')==0;
			c=findFirstRecurringChar(S3);
			assert c==null;
			c=findFirstRecurringChar(S4);
			assert c!=null && c.compareTo('b')==0;
		}
		totalTime=System.nanoTime()-start;
		System.out.println("STRING: "+totalTime/iterations);
		
		start=System.nanoTime();
		for(int i = 0; i < iterations; i++) {
			c=findFirstRecurringChar2(S);
			assert c!=null && c.compareTo('b')==0;
			c=findFirstRecurringChar2(S2);
			assert c!=null && c.compareTo('a')==0;
			c=findFirstRecurringChar2(S3);
			assert c==null;
			c=findFirstRecurringChar2(S4);
			assert c!=null && c.compareTo('b')==0;
		}
		totalTime=System.nanoTime()-start;
		System.out.println("Hashtable: "+totalTime/iterations);
		
		
		start=System.nanoTime();
		for(int i = 0; i < iterations; i++) {
			c=findFirstRecurringChar3(S);
			assert c!=null && c.compareTo('b')==0;
			c=findFirstRecurringChar3(S2);
			assert c!=null && c.compareTo('a')==0;
			c=findFirstRecurringChar3(S3);
			assert c==null;
			c=findFirstRecurringChar3(S4);
			assert c!=null && c.compareTo('b')==0;
		}
		totalTime=System.nanoTime()-start;
		System.out.println("HashSet: "+totalTime/iterations);
		
	}
	
	/**
	 * Slowest
	 */
	private static Character findFirstRecurringChar(String s){
		
		final String[] array = s.split("");
		String b = "";
		for(String a : array) {//O(N)
			if(b.contains(a)) {
				return b.charAt(b.indexOf(a));
			}
			b = b.concat(a);
		}
		return null;
	}
	
	
	/**
	 * 2nd Fastest
	 */
	private static Character findFirstRecurringChar2(String s){
		final Hashtable<Character,Integer> table = new Hashtable<Character, Integer>();
		for(char a : s.toCharArray()) {
			if(table.containsKey(a)){
				return a;
			}else{
				table.put(a,1);
			}
		}
		return null;
	}
	
	/**
	 * Fastest!!!!
	 */
	private static Character findFirstRecurringChar3(String s){
		final HashSet<Character> set = new HashSet<Character>();
		for(char a : s.toCharArray()) {//O(N)
			if(!set.add(a)){
				return a;
			}
		}
		return null;
	}
	
}
