import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

    private boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && c == ']' && st.peek() == '['){
                st.pop();
            }
            else if (!st.isEmpty() && c == '}' && st.peek() == '{'){
                st.pop();
            }
            else if(!st.isEmpty() && c == ')' && st.peek() == '('){
                st.pop();
            }
            else{
                st.push(c);
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        assert(solution.isValid("()"));
        assert(solution.isValid("()[]{}"));
        assert(!solution.isValid("(]"));
        assert(!solution.isValid("([)]"));
        assert(solution.isValid("{[]}"));
    }
}
