import java.util.*;

public class CyclicSubstringMaxSum {

    public static int maxCyclicSubstringSum(String S) {
        int n = S.length();
        String T = S + S;

        Set<Character> seen = new HashSet<>();
        int left = 0;
        int currSum = 0;
        int maxSum = 0;

        for (int right = 0; right < T.length(); right++) {
            char ch = T.charAt(right);
            int val = ch - 'a' + 1;

            
            while (seen.contains(ch)) {
                char leftChar = T.charAt(left);
                seen.remove(leftChar);
                currSum -= (leftChar - 'a' + 1);
                left++;
            }

            
            while (right - left + 1 > n) {
                char leftChar = T.charAt(left);
                seen.remove(leftChar);
                currSum -= (leftChar - 'a' + 1);
                left++;
            }

            
            seen.add(ch);
            currSum += val;

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        String S = "abca";
        System.out.println(maxCyclicSubstringSum(S));
    }
}

