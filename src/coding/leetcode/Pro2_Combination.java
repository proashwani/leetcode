package coding.leetcode;
/**
 * [A, B, C]
[A, B, D]
[A, B, E]
[A, B, F]
[A, C, D]
[A, C, E]
[A, C, F]
[A, D, E]
[A, D, F]
[A, E, F]
[B, C, D]
[B, C, E]
[B, C, F]
[B, D, E]
[B, D, F]
[B, E, F]
[C, D, E]
[C, D, F]
[C, E, F]
[D, E, F]

 */
import java.util.Arrays;

public class Pro2_Combination {
    public static void main(String[] args){
        String[] arr = {"A","B","C","D","E","F"};
        combinations2(arr, 3, 0, new String[3]);
    }

    static void combinations2(String[] arr, int len, int startPosition, String[] result){
        if (len == 0){
            System.out.println(Arrays.toString(result));
            return;
        }       
        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            combinations2(arr, len-1, i+1, result);
        }
    }       
}