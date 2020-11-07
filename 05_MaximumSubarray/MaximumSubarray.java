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
        int result = solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        assert(result == 6);
    }
}
