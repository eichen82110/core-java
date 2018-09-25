package org.hooah.algorithms;

public class Fibonacci {
	
	
	public static void main(String[] args) {
		System.out.println(bestFib(10));
		System.out.println(bestFib(5));
		System.out.println(bestFib(4));
		System.out.println(bestFib(500));
		System.out.println(recursiveFib(5));
		
		
	}
	
	/**
	
	 *
	 * We can observe that this implementation does a lot of repeated work (see the following recursion tree). So this is a bad implementation for nth Fibonacci number.
	 *
	 *                         fib(5)
	 *                     /             \
	 *               fib(4)                fib(3)
	 *             /      \                /     \
	 *         fib(3)      fib(2)         fib(2)    fib(1)
	 *        /     \        /    \       /    \
	 *  fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
	 *  /    \
	 * fib(1) fib(0)
	 *
	 *  Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
	 *
	 * Extra Space: O(n) if we consider the function call stack size, otherwise O(1).
	 */
	private static int recursiveFib(int n) {
		if (n <= 1)
			return n;
		return recursiveFib(n-1) + recursiveFib(n-2);
	}
	
	/**
	 
	 * Dynamic Programming
	 * We can avoid the repeated work done in recursion by storing the Fibonacci numbers calculated so far.
	 *
	 * Time Complexity: O(n) Extra Space: O(n)
	 */
	private static int bestFib(int n)
	{
		/* Declare an array to store Fibonacci numbers. */
		int[] f = new int[n+1];
		int i;
		
		/* 0th and 1st number of the series are 0 and 1*/
		f[0] = 0;
		f[1] = 1;
		
		for (i = 2; i <= n; i++)
		{
      /* Add the previous 2 numbers in the series
         and store it */
			f[i] = f[i-1] + f[i-2];
		}
		
		return f[n];
	}
	
}
