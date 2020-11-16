public class SumOfTwoIntegers {

    private int getSum(int a, int b) {
        while(b != 0){
            int ans = a ^ b;
            int carry = (a & b) << 1;
            a = ans;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers solution = new SumOfTwoIntegers();
        assert(solution.getSum(1, 2) == 3);
        assert(solution.getSum(-2, 3) == 1);
    }
}
