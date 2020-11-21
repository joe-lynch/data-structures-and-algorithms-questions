public class GenerateStringWithOddCharacterCounts {

    public String generateTheString(int N){
        StringBuilder sb = new StringBuilder();

        if(N%2 == 0){
            sb.append("a".repeat(Math.max(0, N - 1)));
            sb.append("b");
        }
        else{
            sb.append("a".repeat(Math.max(0, N)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GenerateStringWithOddCharacterCounts solution = new GenerateStringWithOddCharacterCounts();
        assert(solution.generateTheString(4).equals("aaab"));
        assert(solution.generateTheString(2).equals("ab"));
        assert(solution.generateTheString(7).equals("aaaaaaa"));
    }
}
