import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicate {

    private boolean containsDuplicate(int[] nums){
        Set<Integer> set = new HashSet<>();

        for(int elem : nums){
            if(set.contains(elem)){
                return true;
            }
            set.add(elem);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        boolean result = solution.containsDuplicate(new int[]{1,2,3,1});
        assert(result == true);
    }
}
