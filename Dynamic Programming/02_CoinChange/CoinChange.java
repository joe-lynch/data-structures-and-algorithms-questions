import java.util.Arrays;

public class CoinChange {

    private int coinChange(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i=1; i<amount+1; i++){
            for(int coin : coins) {
                if(i >= coin){
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        assert(solution.coinChange(new int[]{1,2,5}, 11) == 3);
        assert(solution.coinChange(new int[]{2}, 3) == -1);
        assert(solution.coinChange(new int[]{1}, 0) == 0);
        assert(solution.coinChange(new int[]{1}, 1) == 1);
        assert(solution.coinChange(new int[]{1}, 2) == 2);
        assert(solution.coinChange(new int[]{1,2,5,7}, 23) == 4);
    }
}
