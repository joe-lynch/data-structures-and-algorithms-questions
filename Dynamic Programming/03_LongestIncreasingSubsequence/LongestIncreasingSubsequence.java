
public class LongestIncreasingSubsequence {

    private int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;

        for(int i=1; i<nums.length; i++){
            int addition = 0;
            for(int j=0; j < i; j++){
                if(nums[i] > nums[j]){
                    addition = Math.max(addition, dp[j]);
                }
            }
            dp[i] = addition + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        assert(solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}) == 4);
    }


}
