public class ReverseBits {
    private static final int MASK = 0;
    private static final int NOLOOP = 1;

    public long reverseBits(long n, int TYPE){
        switch (TYPE){
            case MASK:
                return reverseBitsMask(n);
            case NOLOOP:
                return reverseBitsNoLoop((int) n);
            default:
                throw new IllegalArgumentException("TYPE must be value 0 or 1.");
        }
    }

    public long reverseBitsMask(long n) {
        if (n == 0) return 0;
        long result = 0;
        for(int i=0; i<32; i++){
            // right shift to add 0 as least significant, to make space for next bit to be ANDed from n
            result <<= 1;
            // AND n with bit mask to get least significant bit of n, then add it to result
            // if (n & 1) is 1, then 1 is added as lsb of result, else 0 is added which leaves 0 as lsb
            result += (n & 1);
            // left shift n by 1 to drop lsb, ready for next one to be used
            n >>= 1;
        }
        return result;
    }

    public long reverseBitsNoLoop(int n){
        n = n>>>16 | n << 16; //2byte swap
        n = (n&0xff00ff00)>>>8 | (n&0x00ff00ff) <<8; //1byte swap
        n = (n&0xf0f0f0f0)>>>4 | (n&0x0f0f0f0f) <<4; //4bit swap
        n = (n&0xcccccccc)>>>2 | (n&0x33333333) <<2; //2bit swap
        n = (n&0xaaaaaaaa)>>>1 | (n&0x55555555) <<1; //1bit swap
        return n;
    }

    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();

        assert(solution.reverseBits(43261596, MASK) == 964176192);
        assert(solution.reverseBits(43261596, NOLOOP) == 964176192);

        assert(solution.reverseBits(4294967293L, MASK) == 3221225471L);
    }
}
