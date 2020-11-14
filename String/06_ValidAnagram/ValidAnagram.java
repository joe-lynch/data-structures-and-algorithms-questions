public class ValidAnagram {

    private boolean isAnagram(String s, String t){
        int[] arr = new int[26];
        if(s.length() != t.length()){
            return false;
        }

        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();
        assert(solution.isAnagram("anagram", "nagaram"));
        assert(solution.isAnagram("hello", "elohl"));
        assert(!solution.isAnagram("rat", "car"));
    }
}
