package org.hooah.algorithms;

/**
 * Add Two Numbers Solution
 * int add(int a, int b)
 *   if b == 0
 *       return a
 *   int sum = a ^ b
 *   int carry = (a & b) << 1
 *   return add(sum, carry)
 */
public class AddTwoNumbers {
	
	
	public static void main(String[] args) {
		System.out.println(add(2,3));
		System.out.println(2^3);
		System.out.println(2^4);
		System.out.println(2^5);
		
	}
	
	/**
	 * Assume a = 9 and b = 7.
	 * In binary form,
	 * a = 1001
	 * b = 0111
	 * ----------
	 * a & b = 0001
	 * a|b = 1111
	 * a^b = 1110
	 * ~b = 1000
	 * a<<1 = 10010
	 * a>>1 = 0100
	 * a>>>2 = 0010
	 *
	 * Different bitwise operators available in Java are:
	 *
	 * & (bitwise and): Bitwise & operator performs binary AND operation bit by bit on the operands. a&b = 0001 which is 1
	 * | (bitwise or): Bitwise | operator performs binary OR operation bit by bit on the operands. a|b = 1111 which is 15
	 * ^ (bitwise XOR): Bitwise ^ operator performs binary XOR operation bit by bit on the operands. a^b = 1110 which is 14
	 * ~ (bitwise compliment):Bitwise ~ operator performs binary NOT operation bit by bit on the operand. ~b = 1000 which is 8
	 * << (left shift): This operator shifts the bits of the left operand to left by number of times specified by right operand. a<<1 = 10010 = 18
	 * >> (right shift): This operator shifts the bits of the left operand to right by number of times specified by right operand. a>>1 = 0100 = 4
	 * >>> (zero fill right shift): Shift right zero fill operator.The left operand value is shifted to right by number of digits specified by right operand and shifted digits will be replaced by zero. a>>>2 = 0010 = 2
	 */
	private static int add(int a, int b){
		if(b==0){
			return a;
		}
		int sum = a^b;//(bitwise XOR): XOR operation bit by bit on the operands. a^b = 1110 which is 14
		int carry = (a&b)<<1;
		return add(sum,carry);
	}
	
}
