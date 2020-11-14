public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++){
            int len1 = palindromeLength(i, i, s);
            int len2 = palindromeLength(i, i+1, s);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }

    private int palindromeLength(int left, int right, String s){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        assert(solution.longestPalindrome("babad").equals("aba"));
        assert(solution.longestPalindrome("cbbd").equals("bb"));
        assert(solution.longestPalindrome("a").equals("a"));
        assert(solution.longestPalindrome("ac").equals("c"));
    }
}
