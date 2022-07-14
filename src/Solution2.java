public class Solution2 {
    public static void main(String[] args) {

        int[] tests = new int[]{123,124,125,121,119,122,126,123};
        int[] ans = func(tests);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

    }

    private static int[] func(int[] line) {
        int n = line.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(line[j] > line[i]) {
                    ans[i] = j;
                    break;
                }
            }
        }

        return ans;
    }
}
