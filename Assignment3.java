/**
 * Created by Rose on 1/27/17.
 * Assignment for your lecture 3. Please finish all the questions under
 * 'Assignment'. Please try to think the extra credit questions. The deadline
 * of this assignment is 02/04/2017 23:59 PST. Please feel free to contact me
 * for any questions. Please write your comments about this assignment in the
 * end.
 */
package com.jane;

import java.util.ArrayList;
import java.lang.String;

public class Assignment3 {
	/**
	 * Given an array, reverse the elements within this array and print the
	 * result eg, given{1,2,3,4}, print{4,3,2,1}
	 */
	public static void reverseArray(int[] nums) {
		int i = 0;
		int j = nums.length - 1;
		int k;
		while (i < nums.length && j > i) {
			k = nums[i];
			nums[i] = nums[j];
			nums[j] = k;//from the front and end at the mean time, change each other.
			i++;//move to next
			j--;//move to left index
		}
		System.out.print("The reverse array is:{");
		for (i = 0; i < nums.length - 1; i++) {
			System.out.print(nums[i] + ",");
		}
		System.out.print(nums[nums.length - 1] + "}");
		System.out.println(" ");
		// write your code here
	}

	/**
	 * Given a non-negative integer represented as a non-empty array of digits,
	 * plus one to the integer. Assume the integer do not contain any leading
	 * zero, except the number 0 itself. The digits are stored such that the
	 * most significant digit is at the head of the array. eg, given {1,2,9},
	 * reutrn{1,3,0}.
	 */
	public static int[] plusOne(int[] digits) {
		if (digits[0] == 0)
			return null;// leading number should not be 0.
		int[] onemoreDigits = new int[digits.length + 1];
		onemoreDigits[0] = 1;
		for (int k = 1; k < onemoreDigits.length; k++)
			onemoreDigits[k] = 0;// define another int[] to store the result.
				    					// leading digit 1, while other digits be 0.
		boolean identifyAll9 = true;// to determin weather all the digits are 9.
		for (int j = 0; j < digits.length; j++) {
			if (digits[j] != 9) {
				identifyAll9 = false;
				break;
			}
		} // the function of boolean identifyAll9.
		if (identifyAll9)
			return onemoreDigits; // if all the digits are 9, return
									// onemoreDigits
		for (int i = digits.length - 1; i > 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
				digits[i - 1] += 1;
			}
		}
		 digits[digits.length-1] += 1;
		return digits;// regular methord to add one
		// write your code here
	}

	/**
	 * Write a program that takes an integer as input and returns all the primes
	 * between 1 and that integer(inclusive). eg, input is 18, you should
	 * return{2,3,5,7,11,13,17}
	 */
	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		for (int x = 2; x <= n / 2; x++) {
			if (n % x == 0) {
				return false;
			}
		}
		return true;
	}

	public static int[] generatePrimes(int n) {
		int counter = 0;//count the number of primes
		int[] underPrime = new int[n];//store the generated primes
		for (int current = 2; current < n; current++) {
			if (isPrime(current)) {
				underPrime[counter] = current;
				counter++;//if current number is prime, store it in the underPrime, and counter+1
			}
		}
		for (int i = 0; i < counter; i++)
			System.out.print(underPrime[i] + " ");
		System.out.println(" ");
		return underPrime;
	}// write your code here

	/**
	 * Assume you have a method isSubstring which checks if one word is a
	 * substring of another. Given two strings, s1 and s2, write a program to
	 * check if s2 is a rotation of s1, using only one call to isSubstring eg,
	 * "pineapple" is a rotation of "neapplepi"
	 */
	public static boolean isSubstring(String s1, String s2) {
		if (s2 == null || s2.length() == 0)
			return true;
		if (s1 == null || s1.length() == 0)
			return false;
		for (int i = 0; i <= s1.length() - s2.length(); i++) {
			if (s1.charAt(i) == s2.charAt(0)) {
				if (s1.substring(i, i + s2.length()).equals(s2)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isRotation(String s1, String s2) {
		String s = s1 + s1;
		if (isSubstring(s, s2)) {
			return true;
		}
		return false;
	}

	/**
	 * Given two strings, write a method to decide if one is a permutation of
	 * the other hint: the comparison is case sensitive and whitespace is
	 * significant
	 */
	public static boolean isPermutation(String s1, String s2) {
		ArrayList<String> S1 = new ArrayList<String>();
		ArrayList<String> S2 = new ArrayList<String>();
		S1.add(s1);
		S2.add(s2);
		if (s1.length() != s2.length())
			return false;
		for (int i = 0; i < s2.length(); i++) {
			if (!S1.contains(S2.get(i))) //once any character of s2 is not contained in s1, return false 
				return false;
		}
		return true;// write your code here
	}

	/**
	 * Write a program to implement encoding and decoding string. The rule is
	 * simple: encode successive repeated characters by the repetition count and
	 * the character. For example, the input of encoding() is "aaaabcccaa", you
	 * should return "4a1b3c2a". The decoding of "3e4f2e" returns "eeeffffee".
	 * Assume the string to be encoded consists of letters of the alphabet, with
	 * no digits, and the string to be decoded is a valid encoding.
	 */
		public static String encoding(String s) {
			String encodingS="";
			int k=0;//k is the index of a different character, also the counter for the previous same character.
			for(int i=1;i<s.length();i+=k){
				if(s.charAt(i)!=s.charAt(i-1)) {
					k=i-k;
					encodingS=encodingS+k+s.charAt(i-1);//generate the encoding string
				}
			}
			return encodingS;// write your code here
		}
		public static String decoding(String s) {
			String decodingS="";
			for(int i=0;i<s.length();i+=2){
				for(int j=0;j<s.charAt(i);j++)
				decodingS+=s.charAt(i+1);
			}
			return decodingS;// write your code here
		}

	// Extra Credit
	 /**
     *Given an m x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
     * For exmaple, given 1 2 3  , return 7 4 1
     *                    4 5,6           8 5 2
     *                    7,8,9           9 6 3
     *tip: image could be a square or a rectangle.
     */
	public static void rotate(int[][] matrix) {
		int m = matrix.length;// m is one dimension of the matrix
		int n = matrix[0].length;//n is the other dimension of the 2D matrix
		int i,j;
		int[][] Matrix = new int[n][m];// Matrix is used to store the rotate matrix
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++)
				Matrix[i][j] = matrix[n - 1 - j][i];
		}//rotate rule
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				System.out.print(Matrix[0][j] + " ");
			}
			System.out.println(" ");
		}

		// write your code here
	}

	/**
	 * Given a string containing just the characters '(', ')', return the count
	 * of valid parentheses. If the intput is not valid, return -1. A valid
	 * parentheses is "()". For example, given "(())", return 2; given "(()))",
	 * return -1.
	 */
	public static int countValidParentheses(String s) {
		int counter1=0, counter2 = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				counter1++;
			if (s.charAt(i) == ')')
				counter2++;
		}
		if (counter1 != counter2)
			return -1;
		return counter1; // write your code here
	}

	/**
	 * Write anything you think about this assignment here. Easy? Difficult? Too
	 * many questions? Less fun? You could write any comments here
	 */
	public static void main(String[] args) {
		int[] Nums = new int[4];
		Nums[0] = 1;
		Nums[1] = 2;
		Nums[2] = 3;
		Nums[3] = 4;
		reverseArray(Nums);// test reverseArray()
		int[] u = new int[18];
		u = generatePrimes(18);// test generatePrimes()
		int[] x=new int[4];
		x=plusOne(Nums);
		System.out.println("The original array plus one is ");
		for(int i=0;i<4;i++)
			System.out.print(x[i]+" ");
		System.out.println(" ");//test plusOne()
		int[] po=new int[3];
		po[0]=9;po[1]=9;po[2]=9;
		int[] p=plusOne(po);
		System.out.println("The original array plus one is ");
		for(int i=0;i<4;i++)
			System.out.print(p[i]+" ");
		System.out.println(" ");//test plusOne() in another condition
		String a1="pineapple";
		String a2="applepine";
		boolean YN=isRotation(a1,a2);//test isRotation()                   
		System.out.println("Is "+a1+" the roatiton of "+a2+"? "+YN);
		String b1="abacd";
		String b2="baeda";
		YN=isPermutation(b1,b2);
		System.out.println("Is "+b1+" the permutation of "+b2+"? "+YN);//test isPermutation()  
		
	    int[][] m=new int[2][3];
	    m[0][0]=1; m[0][1]=2; m[0][2]=3; m[1][0]=4; m[1][1]=5; m[1][2]=6;
	    rotate(m);//test rotate()
	    String s1="(((()))";
	    String s2="(((())))";
	    int t=countValidParentheses(s1);//test countValidParentheses()
	    System.out.println("The number of "+s1+" parentheses is "+t);
	    t=countValidParentheses(s2);//test countValidParentheses() in another condition
	    System.out.println("The number of "+s2+" parentheses is "+t);
	    
	    String c1="aaabbccd";
		String c2="4d2e3f";
	    String ce=encoding(c1);
	    String cd=decoding(c2);
	    System.out.println("The encoding of "+c1 +"is "+ce);//test encoding()
	    System.out.println("The decoding of "+c2 +"is "+cd);//test decoding()

	}
	}

