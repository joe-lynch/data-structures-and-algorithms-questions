import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    private static final int SLIDING_WINDOW = 0;
    private static final int SLIDING_WINDOW_OPTIMISED = 1;

    public int lengthOfLongestSubstring(String s, int TYPE){
        switch(TYPE){
            case SLIDING_WINDOW:
                return slidingWindow(s);
            case SLIDING_WINDOW_OPTIMISED:
                return slidingWindowOptimised(s);
            default:
                throw new IllegalArgumentException("TYPE must be value 0 or 1");
        }
    }

    public int slidingWindow(String s) {
        int left = 0, right = 0;
        Set<Character> seen = new HashSet<>();
        int maxLen = 0;

        while(right < s.length()){
            if(!seen.contains(s.charAt(right))) {
                seen.add(s.charAt(right++));
                maxLen = Math.max(maxLen, right-left);
            }
            else{
                seen.remove(s.charAt(left++));
            }
        }
        return maxLen;
    }

    public int slidingWindowOptimised(String s) {
        int left = 0, right = 0;
        Set<Character> seen = new HashSet<>();
        int maxLen = 0;

        while(right < s.length()){
            if(!seen.contains(s.charAt(right))) {
                seen.add(s.charAt(right++));
                maxLen = Math.max(maxLen, right-left);
            }
            else{
                seen.remove(s.charAt(left++));
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        solution.lengthOfLongestSubstring("abcabcbb", SLIDING_WINDOW);
        solution.lengthOfLongestSubstring("abcabcbb", SLIDING_WINDOW_OPTIMISED);
    }
}
