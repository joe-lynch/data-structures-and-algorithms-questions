public class StringRepeater {
    public StringBuffer repeatString(String s, int n){
        StringBuffer str = new StringBuffer();
        
        for(int i=0; i<n; i++) {
            str.append(s);
        }
        return str;
    }
}
