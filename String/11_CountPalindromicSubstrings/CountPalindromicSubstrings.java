public class CountPalindromicSubstrings {

    private int countSubstrings(String s){
        if(s.length() == 1)
            return 1;
        int result = 0;
        for(int i=0; i<s.length(); i++){
            result += palindrome(i, i, s);
            result += palindrome(i, i+1, s);
        }
        return result;
    }

    private int palindrome(int left, int right, String s){
        int tmp = 0;
        while(left >= 0 && right< s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            tmp++;
        }
        return tmp;
    }

    public static void main(String[] args) {
        CountPalindromicSubstrings solution = new CountPalindromicSubstrings();
        assert(solution.countSubstrings("abc") == 3);
        assert(solution.countSubstrings("aaa") == 6);
    }
}
