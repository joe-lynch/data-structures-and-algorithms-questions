public class NumberOf1Bits {
    public static final int BITMASK = 0;
    public static final int BITMANIPULATIONTRICK = 1;

    public int hammingWeight(int n, int TYPE){
        switch (TYPE){
            case BITMASK:
                return hammingWeightBitMask(n);
            case BITMANIPULATIONTRICK:
                return hammingWeightBitManipulationTrick(n);
            default:
                throw new IllegalArgumentException("TYPE must be 0 or 1.");
        }
    }

    public int hammingWeightBitMask(int n){
        int bits = 0;
        int mask = 1;
        for(int i=0; i<32; i++){
            if((n & mask) != 0){
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    public int hammingWeightBitManipulationTrick(int n){
        int sum = 0;
        while(n != 0){
            n &= (n-1);
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        NumberOf1Bits solution = new NumberOf1Bits();

        // 1011
        assert(solution.hammingWeight(11, BITMASK) == 3);
        assert(solution.hammingWeight(11, BITMANIPULATIONTRICK) == 3);

        // 10000000
        assert(solution.hammingWeight(128, BITMASK) == 1);
        assert(solution.hammingWeight(128, BITMANIPULATIONTRICK) == 1);

        // 111111111111111111111101
        assert(solution.hammingWeight(16777213, BITMASK) == 23);
        assert(solution.hammingWeight(16777213, BITMANIPULATIONTRICK) == 23);
    }
}
