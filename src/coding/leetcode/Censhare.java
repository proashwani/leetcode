package coding.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 
 *  
Input
 
1.All over the world, leading companies and brands place their trust in Censhare in
integrating and automating their communication.
2.Our customer and project portfolio encompasses virtually all sectors and company sizes.
3.These activities are driven and advanced by more than 270 employees across the world, with
subsidiaries in Germany, Switzerland, UK, France, USA, the Netherlands, Sweden and India.
4.We are working with highly motivated, competent colleagues coming from more than 30
different nations using cutting-edge technologies across cultures.
 
Exercise
Please parse above text and do following :
Arrange all the Strings in reverse order of words.
Replace Country names with Country Code (mentioned below)
Swap Line number 3 and 4
Find the String which has the max occurrence along with the number of occurrence.
 
Country Codes are :
Germany - DE
Switzerland - CH
UK - UK
France - FR
USA - US
Netherlands - NL
Sweden - SE
India – IN
 
Things to take care
Code Modularity
Clean Code
SOLID
Exception Handling
 
Expected Output
1.communication their automating and integrating in censhare in trust their place brands and
companies leading world, the over All
2. sizes company and sectors all virtually encompasses portfolio project and customer Our
4.cultures across technologies cutting-edge using nations different 30 than more from coming
colleagues competent motivated, highly with working are We
3.IN and SE NL, US, FR, UK, CH, DE, in subsidiaries with world, the across employees 270 than
more by advanced and driven are activities These
Max occurrence - and (6)
 


 * @author assaxena
 *
 */
public class Censhare {
	static final Map<String, String> COUNTRY_CODES  = new HashMap<String, String>() {
		{
					put("Germany","DE");
					put("Switzerland","CH");
					put("UK","UK");
					put("France","FR");
					put("USA","US");
					put("Netherlands","NL");
					put("Sweden","SE");
					put("India","IN");
		}
	};
	
	public static void main(String[] args) {
		String input = "1.All over the world, leading companies and brands place their trust in Censhare in integrating and automating their communication.\r\n" +
				"2.Our customer and project portfolio encompasses virtually all sectors and company sizes.\r\n" + 
				"3.These activities are driven and advanced by more than 270 employees across the world, with subsidiaries in Germany, Switzerland, UK, France, USA, the Netherlands, Sweden and India.\r\n" + 
				"4.We are working with highly motivated, competent colleagues coming from more than 30 different nations using cutting-edge technologies across cultures.\r\n" ; 
		
		String[] lines = input.split("\r\n");
		// swapLine()
		swapLine(lines,2,3);
		int i=1;
		String output = "";
		for (String str : lines) {
			// remove the extra notation 1. .2 and full stop.
			str =  str.substring(2, str.length()-1);
			String[] words = str.split(" ");
			List<String> wordList = Arrays.asList(words);
			//convert Country code
			wordList = convertCountyCode(wordList);
			// reverse word
			Collections.reverse(wordList);
			
			// make it into single line with the prefix numbering and postfix with full stop.
			String line = wordList.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(" "));
			output = output + i+". "+line + ".";
			i++;
		}
		System.out.println("Expected Output.......\n"+ output);
		System.out.println("Max occurrence - "+ findFrequency(input));
		
	}

	private static String findFrequency(String input) {
		String[] words = input.split(" ");
		List<String> lstWords = Arrays.asList(words);
		String highFrequencyWord ="";
		int highFrequency= 0;
		for (String word : lstWords) {
			int frequency = Collections.frequency(lstWords, word);
			if(frequency >  highFrequency) {
				highFrequency = frequency;
				highFrequencyWord = word;
			}
		}
		return highFrequencyWord + "(" +highFrequency +")";
		
	}

	private static void swapLine(String[] lines, int i, int j) {
		if(i > lines.length-1 || j > lines.length-1 || i < 0 || j < 0) {
			throw new IllegalArgumentException("Swapline argument not valid");
		}
		String temp = lines[i];
		lines[i]= lines[j];
		lines[j] =  temp;
	}

	private static List<String> convertCountyCode(List<String> wordList) {
		List cvtList =  new ArrayList();
		for (String word : wordList) {
			String cvtCode = word;
			
			if(COUNTRY_CODES.get(word.replace(",", "")) != null) {
				 cvtCode = COUNTRY_CODES.get(word.replace(",", ""));
				 cvtCode =  cvtCode +",";
			}
			cvtList.add(cvtCode);
		}
		return cvtList;
	}

}
