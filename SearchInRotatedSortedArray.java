public class SearchInRotatedSortedArray {

    private int search(int[] nums, int target){
        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            if(nums[right] >= nums[mid]){
                if(target <= nums[right] && target > nums[mid]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        assert(solution.search(new int[]{4,5,6,7,0,1,2}, 0) == 4);
        assert(solution.search(new int[]{4,5,6,7,0,1,2}, 3) == -1);
        assert(solution.search(new int[]{1}, 0) == -1);
    }
}
