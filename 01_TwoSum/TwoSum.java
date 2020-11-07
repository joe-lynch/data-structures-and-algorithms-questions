import java.util.*;

public class TwoSum {

        public int[] twoSum(int[] nums, int target){
            Map<Integer, Integer> map = new HashMap<>();

            for(int i=0; i<nums.length; i++){
                int diff = target - nums[i];
                if(map.containsKey(diff)){
                    return new int[]{i, map.get(diff)};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("Illegal Argument");
        }


    public static void main(String[] args){
        TwoSum solution = new TwoSum();
        assert(Arrays.equals(solution.twoSum(new int[]{2,7,11,15}, 9), new int[]{0,1}));
        assert(Arrays.equals(solution.twoSum(new int[]{3,2,4}, 6), new int[]{1,2})));
        assert(Arrays.equals(solution.twoSum(new int[]{3,3}, 6), new int[]{0,1})));
    }
}
