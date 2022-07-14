package slidingwindow;

public class LC03_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        String[] tests = new String[]{
                "abcabcbb",
                "bbbbbbbb",
                "pwcpdpwdc",
                " "
        };
        for (String test : tests) {
            System.out.println(lengthOfLongestSubstring(test));
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }
        int left = 0;
        int right = 0;
        int n = s.length();
        int[] lastPos = new int[128]; // 数字，字母，符号
        char[] cs = s.toCharArray();
        int res = 0;
        while(right < n) {
            left = Math.max(left, lastPos[cs[right] - 'a'] + 1);
            res = Math.max(res, right - left + 1);
            lastPos[cs[right] - 'a'] = right;
            right++;
        }
        return res;
    }
}
