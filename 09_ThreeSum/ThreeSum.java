import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    
    private List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<nums.length && nums[i]<=0; i++){
            if(i == 0 || nums[i] != nums[i-1]) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum > 0) {
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left - 1] == nums[left]) {
                            left++;
                        }
                    }
                }
            }
        }
        return list;

    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        assert(solution.threeSum(new int[]{-1,0,1,2,-1,-4}).equals(Arrays.asList(Arrays.asList(-1,-1,2), Arrays.asList(-1,0,1))));
        assert(solution.threeSum(new int[]{}).equals(new ArrayList<>()));
        assert(solution.threeSum(new int[]{0}).equals(new ArrayList<>()));
        assert(solution.threeSum(new int[]{-2,0,0,2,2}).equals(Arrays.asList(Arrays.asList(-2,0,2))));
    }
}
