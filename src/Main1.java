import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(func(arr));
    }

    public static int func(int[] arr) {
        // 每个元素为峰时，其峰值应为，左右两端最大值 + 距其距离
        int n = arr.length;
        int[][] leftMax = new int[n][2];
        leftMax[0][0] = arr[0];
        leftMax[0][1] = 0;
        int[][] rightMax = new int[n][2];
        rightMax[n - 1][0] = arr[n - 1];
        rightMax[n - 1][1] = n - 1;

        for(int i = 1; i < n; i++) {
            leftMax[i][0] = Math.max(arr[i], leftMax[i - 1][0]);
            leftMax[i][1] = leftMax[i][0] == arr[i] ? i : leftMax[i - 1][1];
            rightMax[n - i - 1][0] = Math.max(arr[i], rightMax[n - i][0]);
            rightMax[n - i - 1][1] = rightMax[n - i - 1][1] == arr[i] ? i : rightMax[n - i - 1][1];
        }


        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int end = Math.max(arr[0] + i, arr[n - 1] + n - i - 1);
            int peak = Math.max(leftMax[i][0] + Math.abs(leftMax[i][1] - i),
                                rightMax[i][0] + Math.abs(rightMax[i][1] - i) - 1
                    );
            peak = Math.max(end, peak);
            System.out.println(peak);
            int ans = inc(arr, peak, i);
            min = Math.min(min, ans);
        }

       return  min;
    }

    private static int inc(int[]arr, int peak, int idx) {
        int sum = 0;
        int n = arr.length;
        int[] copy = new int[n];
        for(int i = 0; i < n; i++) copy[i] = arr[i];
        for(int i = 1; i < idx; i++) {
            if(copy[i] <= copy[i - 1]) {
                sum += (copy[i - 1] + 1 - copy[i]);
                copy[i] = copy[i -1] + 1;
            }
        }

        for(int i = n - 2; i > idx; i--) {
            if(copy[i] <= copy[i + 1]) {
                sum += (copy[i + 1] + 1 - copy[i]);
                copy[i] = copy[i + 1] + 1;
            }
        }

        sum += peak - arr[idx];
        return sum;
    }
}
