import java.util.Arrays;

public class Liyang {

    public static void main(String[] args) {
        int[][] tests = new int[][]{{1,5},{2,4},{3,5},{5,9},{6,8},{8,10}};
        System.out.println(maxIntervals(tests));
    }
    // [1,5],[2,4],[3,5],[5,9],[6,8],[8,10]
    // [2,4],[1,5],[]

    private static int maxIntervals(int[][] intervals) {
        Arrays.sort(intervals,
                (a, b) -> a[1] - b[1]
        );

        int prev = intervals[0][1];
        int ans = 1;
        for(int i = 1; i < intervals.length; i++) {
            if(prev <= intervals[i][0]) { // 如果前一个的右边界，比当前左边界小，代表不重合
                ans++;
                prev = intervals[i][1];
            }
        }
        return intervals.length - ans;
    }
}
