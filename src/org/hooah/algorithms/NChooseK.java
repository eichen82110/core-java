package org.hooah.algorithms;

// Program to calculate C(n ,k) in java

/**
 * Space and time efficient Binomial Coefficient
 * Write a function that takes two parameters n and k and returns the value of Binomial Coefficient C(n, k).
 * For example, your function should return 6 for n = 4 and k = 2, and it should return 10 for n = 5 and k = 2.
 *
 * Binomial Coefficient = n!
 *                       ________
 *                        k!(n-k)!
 */
public class NChooseK {
	
		// Returns value of Binomial Coefficient C(n, k)
		static int binomialCoeff(int n, int k)
		{
			int res = 1;
			
			// Since C(n, k) = C(n, n-k)
			if ( k > n - k )
				k = n - k;
			
			// Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
			for (int i = 0; i < k; ++i)
			{
				res *= (n - i);
				res /= (i + 1);
			}
			
			return res;
		}
		
		/* Driver program to test above function*/
		public static void main(String[] args)
		{
			int n = 8;
			int k = 2;
			System.out.println("Value of C("+ n + ", " + k+ ") "
					+ "is" + " "+ binomialCoeff(n, k));
		}
		
}
