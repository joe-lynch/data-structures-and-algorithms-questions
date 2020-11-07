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
        assert(solution.containsDuplicate(new int[]{1,2,3,1}) == true);
        assert(solution.containsDuplicate(new int[]{1,2,3,4}) == false);
        assert(solution.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}) == true);
    }
}
