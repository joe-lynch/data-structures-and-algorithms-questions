public class MissingNumber {

    public int missingNumber(int[] nums){
        int missing = nums.length;
        for(int i=0; i<nums.length; i++){
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();
        assert(solution.missingNumber(new int[]{3, 0, 1}) == 2);
        assert(solution.missingNumber(new int[]{0, 1}) == 2);
        assert(solution.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}) == 8);
        assert(solution.missingNumber(new int[]{0}) == 1);
    }
}
