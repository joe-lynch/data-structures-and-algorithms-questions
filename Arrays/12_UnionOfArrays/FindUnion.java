import java.util.*;

public class FindUnion {
    private static final int NAIVE = 0;
    private static final int POINTERS = 1;

    // choose which method to use
    private Set<Integer> findUnion(int[] arr1, int[] arr2, int TYPE){
        switch (TYPE) {
            case NAIVE:
                return findUnionNaive(arr1, arr2);
            case POINTERS:
                return findUnionPointers(arr1, arr2);
            default:
                throw new IllegalArgumentException("TYPE must be NAIVE, POINTER, or HASHSET");
        }
    }

    // naive method
    private Set<Integer> findUnionNaive(int[] arr1, int[] arr2) {
        Set<Integer> union = new HashSet<>();
        for(int elem1 : arr1) {
            union.add(elem1);
        }
        for(int elem2 : arr2){
            union.add(elem2);
        }
        return union;
    }

    // pointers method - assume sorted arrays
    private Set<Integer> findUnionPointers(int[] arr1, int[] arr2){
        Set<Integer> union = new HashSet<>();
        int fstPtr = 0;
        int sndPtr = 0;

        while(fstPtr < arr1.length && sndPtr < arr2.length){
            if(arr1[fstPtr] > arr2[sndPtr]){
                union.add(arr2[sndPtr++]);
            }
            else if(arr2[sndPtr] > arr1[fstPtr]){
                union.add(arr1[fstPtr++]);
            }
            else if(arr1[fstPtr] == arr2[sndPtr]){
                union.add(arr1[fstPtr]);
                fstPtr++;
                sndPtr++;
            }
        }
        return union;
    }

    public static void main(String[] args) {
        FindUnion solution = new FindUnion();

        // naive method: O(m + n) time complexity and O(1) space complexity
        Set<Integer> naive_ans = solution.findUnion(new int[]{2,5,7,8,11}, new int[]{1,3,5,6,7,9,11}, NAIVE);
        Set<Integer> naive_sol = (Set) Arrays.asList(5, 7, 11);
        assert(naive_ans.equals(naive_sol));

        // pointer method: O(m + n) time complexity IF SORTED and O(1) space complexity
        Set<Integer> pointers_ans = solution.findUnion(new int[]{2,5,7,8,11}, new int[]{1,3,5,6,7,9,11}, POINTERS);
        Set<Integer> pointers_sol = (Set) Arrays.asList(5, 7, 11);
        assert(pointers_ans.equals(pointers_sol));
    }
}
