import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindIntersection {
    private static final int NAIVE = 0;
    private static final int POINTERS = 1;
    private static final int HASHSET = 2;
    private static final int RETAIN = 3;

    // choose which method to use
    private Set<Integer> findIntersection(int[] arr1, int[] arr2, int TYPE){
        switch (TYPE) {
            case NAIVE:
                return findIntersectionNaive(arr1, arr2);
            case POINTERS:
                return findIntersectionPointers(arr1, arr2);
            case HASHSET:
                return findIntersectionHashSet(arr1, arr2);
            case RETAIN:
                return findIntersectionRetain(arr1, arr2);
            default:
                throw new IllegalArgumentException("TYPE must be NAIVE, POINTER, or HASHSET");
        }
    }

    // naive method
    private Set<Integer> findIntersectionNaive(int[] arr1, int[] arr2) {
        Set<Integer> intersections = new HashSet<>();
        for (int elem1 : arr1) {
            for (int elem2 : arr2) {
                if (elem1 == elem2) {
                    intersections.add(elem1);
                }
            }
        }
        return intersections;
    }

    // pointers method - assume sorted arrays
    private Set<Integer> findIntersectionPointers(int[] arr1, int[] arr2){
        Set<Integer> intersections = new HashSet<>();
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
                intersections.add(arr1[fstPtr]);
                fstPtr++;
                sndPtr++;
            }
        }
        return intersections;
    }

    // hashset method
    private Set<Integer> findIntersectionHashSet(int[] arr1, int[] arr2){
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        for(int elem : arr1){
            set.add(elem);
        }
        for(int elem : arr2){
            if(set.contains(elem)){
                intersection.add(elem);
            }
        }
        return intersection;
    }

    //Retain method
    private Set<Integer> findIntersectionRetain(int[] arr1, int[] arr2){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int elem : arr1){
            set1.add(elem);
        }
        for(int elem : arr2){
            set2.add(elem);
        }
        set1.retainAll(set2);
        return set1;
    }

    public static void main(String[] args) {
        FindIntersection solution = new FindIntersection();

        // naive method: O(mn) time complexity and O(1) space complexity
        Set<Integer> naive_ans = solution.findIntersection(new int[]{2,5,7,8,11}, new int[]{1,3,5,6,7,9,11}, NAIVE);
        Set<Integer> naive_sol = Stream.of(5, 7, 11).collect(Collectors.toSet());
        assert(naive_ans.equals(naive_sol));

        // pointer method: O(m + n) time complexity IF SORTED and O(1) space complexity
        Set<Integer> pointers_ans = solution.findIntersection(new int[]{2,5,7,8,11}, new int[]{1,3,5,6,7,9,11}, POINTERS);
        Set<Integer> pointers_sol = Stream.of(5, 7, 11).collect(Collectors.toSet());
        assert(pointers_ans.equals(pointers_sol));

        // hashset method: O(m + n) time complexity and O(n) space complexity
        Set<Integer> hash_ans = solution.findIntersection(new int[]{2,5,7,8,11}, new int[]{1,3,5,6,7,9,11}, HASHSET);
        Set<Integer> hash_sol = Stream.of(5, 7, 11).collect(Collectors.toSet());
        assert(hash_ans.equals(hash_sol));

        // retain method: O(m + n) time complexity and O(n) space complexity
        Set<Integer> retain_ans = solution.findIntersection(new int[]{2,5,7,8,11}, new int[]{1,3,5,6,7,9,11}, RETAIN);
        Set<Integer> retain_sol = Stream.of(5, 7, 11).collect(Collectors.toSet());
        assert(retain_ans.equals(retain_sol));
    }
}
