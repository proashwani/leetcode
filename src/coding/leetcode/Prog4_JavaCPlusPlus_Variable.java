package coding.leetcode;

/**
 * Three Problems in 90 min 1.We have variable declarations naming conventions
 * for two Languages c++ and Java. Suppose for 'Employe Department Details'
 * naming variable name In java is 'employeDepartmentDetails' In c++ is
 * 'employe_department_details'. Please add lines in method as below which will
 * convert variable name based on language.
 * 
 * String covertLanguageVarible(String NameVaribleInput){ //lines in method
 * which will convert variable name based on language. return NameVaribleInput;
 * }
 * 
 * Test Case 1: Input :employeDepartmentDetails
 * OutPut:employe_department_details
 * 
 * Test Case 2: Input :jai_mata_di OutPut:jaiMataDi
 * 
 * @author assaxena
 *
 */
public class Prog4_JavaCPlusPlus_Variable {
	public static void main(String[] args) {
		System.out.println(covertLanguageVarible("jai_mata_di"));
		System.out.println(covertLanguageVarible("employeDepartmentDetails"));
	}

	private static String covertLanguageVarible(String str) {
		String nameVaribleInput ="";
		String[] split = null;
		if(isCPlusPlus(str)) {
			split = str.split("_");
		}else {
			 split = str.split("(?=[A-Z])");
		}
		nameVaribleInput = split[0];
		for (int i = 1; i < split.length; i++) {
			char[] charArray = split[i].toCharArray();
			String value = String.valueOf(charArray[0]).toUpperCase();
			value = value + String.copyValueOf(charArray, 1, charArray.length-1);
			nameVaribleInput = nameVaribleInput + value;
		}
		return nameVaribleInput;
	}

	private static boolean isCPlusPlus(String str) {
		return str.contains("_");
	}
}
