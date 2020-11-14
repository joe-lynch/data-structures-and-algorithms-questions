public class ValidPalindrome {

    // O(3n) : loops through list three times
    private boolean isPalindrome3N(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    // O(2n) : loops through list only twice
    private boolean isPalindrome2N(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        int mid = sb.length()/2;
        int left = mid, right = mid;

        if(sb.length()%2 == 0){
            left = mid-1;
            right = mid;
        }

        while(left >= 0 && right < sb.length()){
            if(sb.charAt(left) == sb.charAt(right)){
                left--;
                right++;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();

        // O(3n)
        assert(solution.isPalindrome3N("A man, a plan, a canal: Panama"));
        assert(!solution.isPalindrome3N("race a car"));

        // O(2n)
        assert(solution.isPalindrome2N("A man, a plan, a canal: Panama"));
        assert(!solution.isPalindrome2N("race a car"));
    }
}
