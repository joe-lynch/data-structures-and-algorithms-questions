import java.util.*;

public class GroupAnagrams {

    private List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sortedStr = String.valueOf(c);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();
        List<List<String>> ans = solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});

        StringBuilder sb = new StringBuilder();
        for(List<String> l : ans){
            sb.append("[");
            for(String s : l){
                sb.append(s);
                sb.append(", ");
            }
            sb.append("], ");
        }

        assert(sb.toString().equals("[eat, tea, ate, ], [bat, ], [tan, nat, ], "));
    }
}
