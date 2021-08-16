package coding.leetcode;

/**
 * Write a function which takes an array and prints the majority element (if it
 * exists), otherwise prints “No Majority Element”. A majority element in an
 * array A[] of size n is an element that appears more than n/2 times (and hence
 * there is at most one such element).
 * 
 * Examples :
 * 
 * Input : {3, 3, 4, 2, 4, 4, 2, 4, 4} 
 * Output : 4 Explanation: The frequency of 4 is 5 which is greater than the half of the size of the array size.
 * 
 * Input : {3, 3, 4, 2, 4, 4, 2, 4} 
 * Output : No Majority Element Explanation:
 * There is no element whose frequency is greater than the half of the size of the array size.
 * 
 * @author assaxena
 *
 */
public class Prog6_MajorityElement {
	public static void main(String[] args) {
		int arr[] = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		majorityElement(arr);
	}

	private static void majorityElement(int[] arr) {
		int block[] = new int[10]; 
		for (int i = 0; i < arr.length; i++) {
			block[arr[i]]++;
		}
		for (int i = 0; i < block.length; i++) {
			if(block[i] >= arr.length/2) {
				System.out.printf("%d  Explanation: The frequency of %d is %d "
						+ "which is greater than the half of the size of the array size.",i,i,block[i]);
			}
		}
		
		System.out.println("No Majority Element Explanation: There is no element whose frequency is greater than the half of the size of the array size.");
	}
}
