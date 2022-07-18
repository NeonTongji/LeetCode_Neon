package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class LC17_Letter_Combination_Of_Phone_Number {
    private static ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap(){
        {
            put(2,"abc");
            put(3, "def");
            put(4,"ghi");
            put(5,"jkl");
            put(6,"mno");
            put(7,"pqrs");
            put(8,"tuv");
            put(9,"wxyz");
        }
    };

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return res;
        }
        dfs(digits, 0, res, new StringBuilder());
        return res;
    }

    // dfs 将idx即之后的digits组合放到sb中，并加到res
    private static void dfs(String digits, int idx, List<String> res, StringBuilder sb) {
        if(idx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String str = map.get(digits.charAt(idx) - '0');
        for(int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            dfs(digits, idx + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
