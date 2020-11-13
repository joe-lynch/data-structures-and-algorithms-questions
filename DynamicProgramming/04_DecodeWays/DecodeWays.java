import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    Map<Integer, Integer> map = new HashMap<>();

    // recursive method
    private int recursion(String s, int idx){
        if(s.length() == idx)
            return 1;
        if(s.charAt(idx) == '0')
            return 0;
        if(s.length()-1 == idx)
            return 1;

        int cnt = recursion(s, idx+1);
        if(Integer.parseInt(s.substring(idx, idx+2)) <= 26){
            cnt += recursion(s, idx+2);
        }
        return cnt;
    }

    // recursive method with memoisation
    private int recursionMemo(String s, int idx){
        map.clear();
        return performRecursionMemo(s, idx);
    }

    private int performRecursionMemo(String s, int idx){
        if(s.length() == idx)
            return 1;
        if(s.charAt(idx) == '0')
            return 0;
        if(s.length()-1 == idx)
            return 1;
        if(map.containsKey(idx))
            return map.get(idx);

        int cnt = performRecursionMemo(s, idx+1);
        if(Integer.parseInt(s.substring(idx, idx+2)) <= 26){
            cnt += performRecursionMemo(s, idx+2);
        }
        map.put(idx, cnt);
        return cnt;
    }

    // dynamic programming method
    private int dynamicProgramming(String s){
        int dp[] = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i=2; i <= s.length(); i++){
            if(s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }
            int twoDigits = Integer.parseInt(s.substring(i-2, i));
            if(twoDigits >= 10 && twoDigits <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        DecodeWays solution = new DecodeWays();

        assert(solution.recursion("226", 0) == 3);
        assert(solution.recursionMemo("226", 0) == 3);
        assert(solution.dynamicProgramming("226") == 3);

        assert(solution.recursion("116168", 0) == 6);
        assert(solution.recursionMemo("116168", 0) == 6);
        assert(solution.dynamicProgramming("116168") == 6);

        assert(solution.recursion("101", 0) == 1);
        assert(solution.recursionMemo("101", 0) == 1);
        assert(solution.dynamicProgramming("101") == 1);

        assert(solution.recursion("0", 0) == 0);
        assert(solution.recursionMemo("0", 0) == 0);
        assert(solution.dynamicProgramming("0") == 0);
    }
}
