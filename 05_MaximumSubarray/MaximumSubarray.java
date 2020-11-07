public class MaximumSubarray {

    private int maxSubArray(int[] nums){
        int currMax = nums[0];
        int max = currMax;
        for(int i=1; i<nums.length; i++){
            currMax = Math.max(nums[i], currMax+nums[i]);
            max = Math.max(currMax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        assert(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}) == 6);
        assert(solution.maxSubArray(new int[]{1}) == 1);
        assert(solution.maxSubArray(new int[]{0}) == 0);
        assert(solution.maxSubArray(new int[]{-1}) == -1);
        assert(solution.maxSubArray(new int[]{-2147483647}) == -2147483647);
    }
}
