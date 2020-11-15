import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    private String minWindow(String s, String t) {
        // map to keep track of how many times characters in String t are seen
        Map<Character, Integer> map = new HashMap<>();
        // populate map with occurences of characters in t
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        // initialise pointers and counters
        int left = 0, right = 0, charsToFind = t.length(), charsFound = 0, minWindow = Integer.MAX_VALUE;
        String minString = "";

        while(right < s.length()){
            Character c = s.charAt(right);
            /* if character is in t, then decrement
            * if the value is less than 0, then there are more occurences in our window than in String t
            * and we have already incremented charsFound sufficiently for that character */
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c) >= 0)
                    charsFound++;
            }
            // if all characters have been found
            while(charsFound == charsToFind){
                // set the minimum window
                if(right + 1 - left < minWindow){
                    minWindow = right + 1 - left;
                    minString = s.substring(left, right+1);
                }
                /* when we meet a character in t, increment its occurence in the map
                * if value is above 0, then there are no more characters of that type left in our window
                * and we can decrement charsFound
                * if value is 0 or below, then we have multiple occurences still in our window, and continue to
                * move our left pointer along */
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left), map.get(s.charAt(left))+1);
                    if(map.get(s.charAt(left)) > 0){
                        charsFound--;
                    }
                }
                left++;
            }
            right++;
        }
        return minString;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        assert(solution.minWindow("ADAOBECODEBANC", "ABC").equals("BANC"));
        assert(solution.minWindow("a", "a").equals("a"));
    }

}
