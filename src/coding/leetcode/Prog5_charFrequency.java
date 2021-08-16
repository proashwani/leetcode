package coding.leetcode;
/**
 * String covertFreqString(String dataItemInput){
//lines in method which will display frequency of all characters in string typr input.
return dataItemInput;
}

Test Case 1:
Input :amnqmamananqm
OutPut:a4m4n3q2

Test Case 2:
Input :bdbcdbcbc
OutPut:b4c3d2
 * @author assaxena
 *
 */
public class Prog5_charFrequency {
	public static void main(String[] args) {
		System.out.println(covertFreqString("zamnqmamananqm"));
	}

	private static String covertFreqString(String str) {
		int character[] = new int[26];
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			character[charArray[i]-'a']++; 
		}
		for (int i = 0; i < charArray.length; i++) {
			if(character[charArray[i]-'a'] > 0 ) {
				System.out.print((char)charArray[i] );
				System.out.print(character[charArray[i]-'a']);
				character[charArray[i]-'a'] =0;
			}
		}
		
		return "";
	}

}
