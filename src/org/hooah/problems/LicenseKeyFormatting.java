package org.hooah.problems;

/**
 * You are given a license key represented as a string S which consists only alphanumeric character and dashes. The string is separated into N+1 groups by N dashes.
 *
 * Given a number K, we would want to reformat the strings such that each group contains exactly K characters,
 * except for the first group which could be shorter than K, but still must contain at least one character.
 * Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.
 *
 * Given a non-empty string S and a number K, format the string according to the rules described above.
 */
public class LicenseKeyFormatting {
	
	public String licenseKeyFormatting(String S, int K){
		if(S==null || S.isEmpty()){
			return S;
		}
		S = S.toUpperCase();
		S = S.replaceAll("-","");
		if(S.length()<=1){
			return S;
		}
		if(K==0||K>S.length()){
			return S;
		}
		
		
		
		int remainderK = S.length()%K;
		StringBuilder formatted = new StringBuilder();
		if(remainderK>0){
			System.out.println("Initial group size = "+remainderK);
			formatted.append(S, 0, remainderK).append('-');
		}
		
		int currGroupSize = 0;
		for(int i = remainderK; i <S.length(); i++) {
			if(currGroupSize==K) {
				formatted.append('-');
				currGroupSize=0;
			}
			formatted.append(S.charAt(i));
			currGroupSize++;
		}
		
		return formatted.toString();
	}
	
	
	public static void main(String[] args){
		//s=string (alphanumeric char &dashes)
		//N=dashes
		//N+1 groups of strings
		//K=int representing the number of char per group between dashes
		//G1=first group
		// 0>G1<=K
		//s needs to be all uppercase
		LicenseKeyFormatting lkf = new LicenseKeyFormatting();
		
		String s = "5F3Z-2e-9-w";
		int k = 4;
		assert lkf.licenseKeyFormatting(s, k).equals("5F3Z-2E9W");
		String s2 = "2-5g-3-J";
		int k2 = 2;
		assert lkf.licenseKeyFormatting(s2, k2).equals("2-5G-3J");
		String s3 = "-------";
		int k3 = 2;
		assert lkf.licenseKeyFormatting(s3, k3).equals("");
	}
}
