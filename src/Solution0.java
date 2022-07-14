import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Solution0 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    static List<String> list = new LinkedList<>();
    public static List<String> generateParenthesis(int n) {
        dfs(n, new StringBuilder(), 0, 0);
        return list;
    }

    private static void dfs(int n, StringBuilder sb, int left, int right) {

        if(sb.length() == 2 * n) {
            list.add(sb.toString());
            return;
        }

        if(left < n) {
            sb.append('(');
            dfs(n, sb, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(right < left) {
            sb.append(')');
            dfs(n, sb, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}