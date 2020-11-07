public class MaximumProductSubarray {

    private int maxProduct(int[] nums){
        int currMax = nums[0];
        int currMin = nums[0];
        int max = currMax;
        for(int i=1; i<nums.length; i++) {
            int temp = Math.max(nums[i], Math.max(currMin * nums[i], currMax * nums[i]));
            currMin = Math.min(nums[i], Math.min(currMin * nums[i], currMax * nums[i]));
            currMax = temp;
            max = Math.max(max, currMax);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubarray solution = new MaximumProductSubarray();
        assert(solution.maxProduct(new int[]{2,3,-2,4}) == 6);
        assert(solution.maxProduct(new int[]{-2,0,-1}) == 0);

    }
}
