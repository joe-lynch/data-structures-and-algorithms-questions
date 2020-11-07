import java.util.*;
import java.util.stream.Collectors;

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
        int[] result = solution.twoSum(new int[]{2,7,11,15}, 9);
        assert (Arrays.equals(result, new int[]{0,1}));
    }
}
