public class ClimbingStairs {

    private int climbStairs(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        assert(solution.climbStairs(2) == 2);
        assert(solution.climbStairs(3) == 3);
        assert(solution.climbStairs(10) == 89);
    }
}
