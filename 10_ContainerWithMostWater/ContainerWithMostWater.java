public class ContainerWithMostWater {

    private int maxArea(int[] height){
        int left = 0, right = height.length-1;
        int maxVol = 0;
        while(left < right){
            maxVol = Math.max(maxVol, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxVol;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        assert(solution.maxArea(new int[]{1,1}) == 1);
        assert(solution.maxArea(new int[]{4,3,2,1,4}) == 16);
        assert(solution.maxArea(new int[]{1,2,1}) == 2);
    }
}
