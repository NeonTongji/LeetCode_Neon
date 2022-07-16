public class LC05_Longest_Palindromic_Substring {
    // 给你一个字符串 s，找到 s 中最长的回文子串。
    // 示例 1：
    //
    //输入：s = "babad"
    //输出："bab"
    //解释："aba" 同样是符合题意的答案。
    //示例 2：
    //
    //输入：s = "cbbd"
    //输出："bb"

    public static void main(String[] args) {
        System.out.println(longestPalindromeV1("babad"));
        System.out.println(longestPalindromeV1("cbbd"));
        System.out.println(longestPalindromeV1("bb"));
    }

    // 1.中心扩展法 时间复杂度O(n^2), 空间复杂度O(1)
    public static String longestPalindromeV1(String s) {
        int res = 0;
        int idx = 0;
        for(int i = 0; i < s.length(); i++) {
            int len = lengthOfSubstring(s, i);
            if (res < len) {
                res = len;
                idx = i;
            }
        }
        System.out.println(idx + " " + res);
        return s.substring(idx - (res - 1) / 2, idx + res / 2 + 1);
    }
    // 注意分奇偶
    private static int lengthOfSubstring(String s, int idx) {
        int res1 = 1;
        for(int i = idx - 1, j = idx + 1; i >= 0 && j < s.length(); i--, j++) {
            if(s.charAt(i) == s.charAt(j)) { // abcbd
                res1 += 2;
            } else {
                break;
            }
        }
        int res2 = 0;
        for(int i = idx, j = idx + 1; i >= 0 && j < s.length(); i--, j++) {
            if(s.charAt(i) == s.charAt(j)) { // abcbd
                res2 += 2;
            } else {
                break;
            }
        }
        return Math.max(res1,res2);
    }

    // TODO: 动态规划 时间复杂度O(n^2), 空间复杂度O(n^2)
    public static String longestPalindromeV2(String s) {
        // dp: 空间换时间
        // dp[l][r]: 从l到r之间的字符串是不是回文串
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        return "";
    }
}
