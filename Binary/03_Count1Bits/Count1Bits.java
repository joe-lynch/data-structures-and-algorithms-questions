import java.util.Arrays;

public class Count1Bits {
    private static final int LASTSETBIT = 0;
    private static final int LEASTSIGBIT = 1;
    private static final int MOSTSIGBIT = 2;
    private static final int POPCOUNT = 3;

    public int[] countBits(int num, int TYPE){
        switch(TYPE){
            case LASTSETBIT:
                return countBitsLastSetBit(num);
            case LEASTSIGBIT:
                return countBitsLeastSigBit(num);
            case MOSTSIGBIT:
                return countBitsMostSigBit(num);
            case POPCOUNT:
                return countBitsPopCount(num);
            default:
                throw new IllegalArgumentException("TYPE must be value 0 or 1 or 2.");
        }
    }

    public int[] countBitsLastSetBit(int num){
        int[] ans = new int[num + 1];
        for(int i=0; i<=num; i++){
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public int[] countBitsLeastSigBit(int num){
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        // [0, b) is calculated
        while (b <= num) {
            // generate [b, 2b) or [b, num) from [0, b)
            while(i < b && i + b <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;   // reset i
            b <<= 1; // b = 2b
        }
        return ans;
    }

    public int[] countBitsMostSigBit(int num){
        int[] ans = new int[num + 1];
        for(int i=0; i<=num; i++){
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    private int[] countBitsPopCount(int num) {
        NumberOf1Bits util = new NumberOf1Bits();
        int[] ans = new int[num+1];

        for(int i=0; i<=num; i++){
            ans[i] = util.hammingWeight(i, NumberOf1Bits.BITMANIPULATIONTRICK);
        }
        return ans;
    }

    public static void main(String[] args) {
        Count1Bits solution = new Count1Bits();

        int[] ans1 = new int[]{0, 1, 1};
        assert(Arrays.equals(solution.countBits(2, LASTSETBIT), ans1));
        assert(Arrays.equals(solution.countBits(2, LEASTSIGBIT), ans1));
        assert(Arrays.equals(solution.countBits(2, MOSTSIGBIT), ans1));
        assert(Arrays.equals(solution.countBits(2, POPCOUNT), ans1));

        int[] ans2 = new int[]{0,1,1,2,1,2};
        assert(Arrays.equals(solution.countBits(5, LASTSETBIT), ans2));
        assert(Arrays.equals(solution.countBits(5, LEASTSIGBIT), ans2));
        assert(Arrays.equals(solution.countBits(5, MOSTSIGBIT), ans2));
        assert(Arrays.equals(solution.countBits(5, POPCOUNT), ans2));
    }
}
