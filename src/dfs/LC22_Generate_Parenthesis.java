package dfs;

import java.util.ArrayList;
import java.util.List;

public class LC22_Generate_Parenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(list, n, 0, 0 ,new StringBuilder());
        return list;
    }

    private static void dfs(List<String> list, int n, int left, int right, StringBuilder sb) {
        if(sb.length() == 2 * n) {
            list.add(sb.toString());
        }
        if(left < n) {
            sb.append("(");
            dfs(list, n, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < left) {
            sb.append(")");
            dfs(list, n, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
