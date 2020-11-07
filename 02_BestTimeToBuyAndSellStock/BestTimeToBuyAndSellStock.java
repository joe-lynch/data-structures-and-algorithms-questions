public class BestTimeToBuyAndSellStock {

    private int maxProfit(int[] prices){
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        int result = solution.maxProfit(new int[]{7,1,5,3,6,4});
        assert(result == 5);
    }
}
