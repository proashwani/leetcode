package coding.leetcode;

import java.util.Arrays;

/**
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True  
There is a subset (4, 5) with sum 9.

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
There is no subset that add up to 30.
 * @author assaxena
 *
 */
public class Program1 {

	public static void main(String[] args) {
	int input[] = 	{3, 34, 4, 12, 5, 2};
	int sum = 9;
	String[] subset = getSubset(input,sum);
	System.out.println(Arrays.toString(subset));

	}

	private static String[] getSubset(int[] input, int sum) {
		String data[] = new String[input.length/2];
		int index=0;
		for (int i = 0; i < input.length; i++) {
			for (int j = i+1; j < input.length; j++) {
				if(input[i]+input[j] == sum) {
					data[index++]= "("+input[i] + ","+input[j]+")";
				}
			}
		}
		return data;
	}

}
