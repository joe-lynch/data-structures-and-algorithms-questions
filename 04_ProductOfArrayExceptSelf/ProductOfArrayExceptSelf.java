import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums){
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] output = new int[nums.length];

        left[0] = 1;
        for(int i=1; i<nums.length; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        right[nums.length-1] = 1;
        for(int i=nums.length-2; i>=0; i--){
            right[i] = right[i+1] * nums[i+1];
        }

        for(int i=0; i<nums.length; i++){
            output[i] = left[i] * right[i];
        }

        return output;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        assert(Arrays.equals(solution.productExceptSelf(new int[]{1,2,3,4}), new int[]{24,12,8,6}));
    }
}
