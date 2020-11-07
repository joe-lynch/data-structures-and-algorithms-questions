public class MinimumInRotatedSortedArray {

    private int findMin(int[] nums){
        int left = 0, right = nums.length -1;

        if(nums[left] < nums[right])
            return nums[left];

        if(nums.length == 1){
            return nums[0];
        }

        while(left < right){
            int mid = left + (right-left)/2;

            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid] < nums[mid-1]){
                return nums[mid];
            }

            if(nums[right] < nums[mid]){
                left = mid+1;
            }
            else if(nums[left] > nums[mid]) {
                right = mid - 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        MinimumInRotatedSortedArray solution = new MinimumInRotatedSortedArray();

        assert(solution.findMin(new int[]{3,4,5,1,2}) == 1);
        assert(solution.findMin(new int[]{4,5,6,7,0,1,2}) == 0);
        assert(solution.findMin(new int[]{1}) == 1);
        assert(solution.findMin(new int[]{2,1}) == 1);
        assert(solution.findMin(new int[]{1,2}) == 1);
    }
}
