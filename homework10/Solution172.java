/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/

public class Solution172 {
	public int trailingZeroes(int n) {
		if (n<=4) return 0;
		return ( n/5 + trailingZeroes(n/5) );
	}
}