package coding.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of size n, generate and print all possible combinations of r elements in array. For example,
 *  if input array is {1, 2, 3, 4} and r is 2,
 *  then output should be {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} and {3, 4}.
 * @author assaxena
 *
 */
public class Pro3_Combination {
	public static void main(String[] args) {
		int input[] =  {1, 2, 3, 4};
		int r = 2;
		List lst = new ArrayList();
//		getCombination(input,r,lst);
//		System.out.println(lst);
		lst = new ArrayList();
		getCombinationRecu(input,r,0,1,lst);
		System.out.println(lst);
		
	}

	private static void getCombinationRecu(int[] input, int r,int first,int next, List lst) {
		if(first == input.length-r ) {
			return ;
		}
		if(next == input.length) {
			first++;
			next= first+1;
		}
		lst.add("("+input[first]+","+input[next]+")");
		getCombinationRecu(input,r, first,++next,lst);
	}

	private static void getCombination(int[] input, int r,List lst) {
		for (int i = 0; i < input.length; i++) {
			for (int j = i+1; j < input.length; j++) {
				lst.add("("+input[i]+","+input[j]+")");
			}
		}
	}
	
	

}
