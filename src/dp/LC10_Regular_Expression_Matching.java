package dp;

//给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
//
//'.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素 "a*" 表示{"", "a", "aa", ... ,}
//所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
public class LC10_Regular_Expression_Matching {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", "abc*"));
        System.out.println(isMatch("abccccc", "ab.*"));
        System.out.println(isMatch("aaa", ".*"));
    }
    // 动态规划，
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // dp[i][j] s的前i个字符构成子串能否被p的前j个字符构成子串match
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 初始化
        dp[0][0] = true;
        for(int i = 0; i <= m; i++) {
            // 因为dp[i][0] 默认时为false, 所以j从1开始
            for(int j = 1; j <= n; j++) {
                // j为长度，比下标大1, 且p第一个肯定不会为'*'，所以进这个if分支j >= 2, 可加进去也可以不加
                if(p.charAt(j - 1) == '*') {
                    // * 代表了元素
                    if(i > 0 && isCurMatch(s.charAt(i - 1), p.charAt(j - 2))) {
                        //case1: s:{abc}, p:{abc-*}    dp[i][j] = dp[i][j - 2]
                        //case2: s:{abcc, abccc}, p:{abc-*}   dp[i][j] = dp[i - 1][j]
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else { // * 抵消了前一个
                        // case1: s:{ab}, p:{abc-*}
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    // case1: s:{abcd} p:{abd}
                    if(i > 0 && isCurMatch(s.charAt(i - 1), p.charAt(j - 1))) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[m][n];
    }

    // 判断当前这个字符能不能匹配上
    private static boolean isCurMatch(char a, char b) {
        return (a == b || b == '.');
    }
}
