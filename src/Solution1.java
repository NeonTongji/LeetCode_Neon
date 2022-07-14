public class Solution1 {

    public static void main(String[] args) {

        String[] tests = new String[]{
                    "1",
                    "1#2",
                    "1#2#3",
                    "111#222#113",
                    "1#2#3#",
                    "#1#2#3",
                    "256#1#2#3",
                    "192#168#1#5",
                    "0#0#0#0",
                    "255#255#255#255",
                    "1#2#3#4#5",
                    "12#234#45#6",
                    "12#2345#45#6",
                    "1#a#2#3",
                    "132#3#4 ",
                    "1#2# 3#4",
                    "1#2#3#4",
                    ""
        };

        for(String test : tests) {
            System.out.println(ConvertIPv4ToUInt(test));
        }


    }

    private static Object ConvertIPv4ToUInt(String IPv4) {
        if(!isIPv4(IPv4)) {
            return "invalid IP";
        }

        String[] sections = IPv4.split("#");

        int ans = 0;
        for (int i = 0; i < 4; ++i)
        {
            ans += Integer.valueOf(sections[i]) << ((3 - i) * 8);
        }

        return ans;
    }

    private static boolean isIPv4(String ip) {
        String[] strs = ip.trim().split("#");
        // 4 段十进制，末尾不能为'.'；
        if(strs.length != 4 || ip.charAt(ip.length() - 1) == '#') return false;
        for(String s : strs) {
            if(s.length() > 3 || s.length() < 1) return false;
            char[] chars = s.toCharArray();
            // 不含前导0
            if(chars[0] == '0' && chars.length != 1) return false;
            for(char c : chars) {
                if(!Character.isDigit(c)) {
                    return false;
                }
            }

            if(Integer.valueOf(s) > 255) return false;
        }

        return true;
    }
}

