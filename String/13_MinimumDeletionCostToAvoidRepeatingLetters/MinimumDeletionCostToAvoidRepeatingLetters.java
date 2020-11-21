public class MinimumDeletionCostToAvoidRepeatingLetters {

    public int minCost(String S, int[] C){
        int ret = 0;
        for(int i=0; i<S.length(); i++){
            int max = C[i], cost = C[i];
            while(i < S.length()-1 && S.charAt(i) == S.charAt(i+1)){
                max = Math.max(max, C[i+1]);
                cost += C[i+1];
                i++;
            }
            ret += (cost - max);
        }
        return ret;
    }

    public static void main(String[] args) {
        MinimumDeletionCostToAvoidRepeatingLetters solution = new MinimumDeletionCostToAvoidRepeatingLetters();
        assert(solution.minCost("abaac", new int[]{1,2,3,4,5}) == 3);
        assert(solution.minCost("abc", new int[]{1,2,3}) == 0);
        assert(solution.minCost("aabaa", new int[]{1,2,3,4,1}) == 2);
    }
}