import java.util.*;

public class FindUnion {
    private static final int NAIVE = 0;
    private static final int POINTERS = 1;
    private static final int HASHSET = 2;

    // choose which method to use
    private List<Integer> findUnion(int[] arr1, int[] arr2, int TYPE){
        switch (TYPE) {
            case NAIVE:
                return findUnionNaive(arr1, arr2);
            case POINTERS:
                return findUnionPointers(arr1, arr2);
            case HASHSET:
                return findUnionHashSet(arr1, arr2);
            default:
                throw new IllegalArgumentException("TYPE must be NAIVE, POINTER, or HASHSET");
        }
    }

    // naive method
    private List<Integer> findUnionNaive(int[] arr1, int[] arr2) {
        List<Integer> union = new ArrayList<>();
        for (int elem1 : arr1) {
            for (int elem2 : arr2) {
                if (elem1 == elem2) {
                    union.add(elem1);
                }
            }
        }
        return union;
    }

    // pointers method
    private List<Integer> findUnionPointers(int[] arr1, int[] arr2){
        List<Integer> union = new ArrayList<>();
        int fstPtr = 0;
        int sndPtr = 0;

        while(fstPtr < arr1.length && sndPtr < arr2.length){
            if(arr1[fstPtr] > arr2[sndPtr]){
                sndPtr++;
            }
            else if(arr2[sndPtr] > arr1[fstPtr]){
                fstPtr++;
            }
            else if(arr1[fstPtr] == arr2[sndPtr]){
                union.add(arr1[fstPtr]);
                fstPtr++;
                sndPtr++;
            }
        }
        return union;
    }

    // hashset method
    private List<Integer> findUnionHashSet(int[] arr1, int[] arr2){
        Set<Integer> set = new HashSet<>();
        List<Integer> union = new ArrayList<>();

        for(int elem : arr1){
            set.add(elem);
        }
        for(int elem : arr2){
            if(set.contains(elem)){
                union.add(elem);
            }
        }
        return union;
    }

    public static void main(String[] args) {
        FindUnion solution = new FindUnion();

        // using naive method O(mn)
        List<Integer> naive_ans = solution.findUnion(new int[]{2,5,7,8,11}, new int[]{1,3,5,6,7,9,11}, NAIVE);
        List<Integer> naive_sol = Arrays.asList(5, 7, 11);
        assert(naive_ans.equals(naive_sol));

        // using pointer method O(m + n)
        List<Integer> pointers_ans = solution.findUnion(new int[]{2,5,7,8,11}, new int[]{1,3,5,6,7,9,11}, POINTERS);
        List<Integer> pointers_sol = Arrays.asList(5, 7, 11);
        assert(pointers_ans.equals(pointers_sol));

        // using hashset method O(m + n)
        List<Integer> hash_ans = solution.findUnion(new int[]{2,5,7,8,11}, new int[]{1,3,5,6,7,9,11}, HASHSET);
        List<Integer> hash_sol = Arrays.asList(5, 7, 11);
        assert(hash_ans.equals(hash_sol));
    }
}
