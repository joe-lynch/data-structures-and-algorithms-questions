/** A stack abstract data type that contains Strings. */
public class StringStack {
    
    String[] myArray;
    private int top;
    int size;
    /**
     * Constructor for creating a new StringStack with a certain capacity.
     * @param capacity the maximum number of strings the stack can hold
     */
    public StringStack(int capacity) {
        size = capacity;
        myArray = new String[size];
        top=-1;
    }
    
    /**
     * Puts the given String on top of the stack (if there is enough space).
     * @param s the String to add to the top of the stack
     * @return false if there was not enough space in the stack to add the string; 
                 otherwise true
     */
    public boolean push(String s) {
        if(top==size-1){
            return false;
        }
        else{
            top=top+1;
            myArray[top]=s;
            return true;
        }
    }
    
    /**
     * Removes the String on top of the stack from the stack and returns it.
     * @return the String on top of the stack, or null if the stack is empty.
     */
    public String pop() {
        if(top!=-1){
            String returnThis = myArray[top];
            top=top-1;
            return returnThis;
        }
        else{
            return "null";
        }
    }
    
    /**
     * Returns the number of Strings in the stack.
     * @return the number of Strings in the stack
     */
    public int count() {
        return top+1;
    }
}
