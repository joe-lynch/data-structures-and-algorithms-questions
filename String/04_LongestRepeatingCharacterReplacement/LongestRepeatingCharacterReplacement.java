public class LongestRepeatingCharacterReplacement {

    private int characterReplacement(String s, int k) {
        // window starts at 0
        int start = 0;

        // keep track of each occurrence of a char.
        // used to see if the newly added char might be
        // the longest one in our current window
        int[] count = new int[26];

        // keeps track of what is the longest streak of character.
        // this allows us to optimize which characters to remove.
        // maximizing same character --> minimizing replacements
        int maxStreak = 0;

        for(int end = 0; end < s.length(); end++){
            // without checking to see if we went over limit,
            // we directly add in the new character onto the end.
            // then, we check to see if this new character will have the most occurrences in (start, end).
            // we do that because we can optimize what to replace by finding the char that happens the most,
            // then replace all other chars that isn't that optimal char.
            int index = (int) (s.charAt(end) - 'A');
            count[index]++;
            maxStreak = Math.max(maxStreak, count[index]);

            // if we went over the max number of replacements,
            // then we move start one unit to the right,
            // CONFUSING: once we go on to the next iteration,
            // we will be checking from (start+1, end+1) since we added one to start here,
            // and the for loop adds 1 to end.
            // this means that we are checking the same length, but shifted one over.
            // this allows us to check for potential substrings that are longer than our current max,
            // and ignore those that are smaller than the current max streak.
            int lengthOfWindow = end - start + 1;
            int longestStreakPlusReplacement = maxStreak + k;
            if(lengthOfWindow > longestStreakPlusReplacement) {
                // we will move start one unit right,
                // so we have to remove one from the now-removed char
                int startChar = s.charAt(start) - 'A';
                count[startChar]--;
                start++;
            }
        }

        // since we mentioned that we never shrunk the window,
        // and only increased it or kept the same, we must have the
        // maximum possible window at the end since it would have persisted
        // from that window all the way till the end
        // at the end, end = s.length() - 1, so end - start + 1 = s.length() - start
        return s.length() - start;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
        assert(solution.characterReplacement("ABAB", 4) == 4);
        assert(solution.characterReplacement("AABABBA", 1) == 4);
    }
}
