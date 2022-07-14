import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        int[] test = new int[]{2,3,4};
        List<List<Integer>> func = func(test, 2);
        for(List item : func) {
            System.out.println(item);
        }
    }

    private static List<List<Integer>> ans = new LinkedList<>();

    private static List<List<Integer>> func(int[] nums, int k) {

            Arrays.sort(nums);

            dfs(nums, k, 0, new LinkedList<>());

        return ans;
    }

    private static void dfs(int[] nums, int k, int idx, List<Integer> item) {
        if(item.size() >= k){
            ans.add(new ArrayList<>(item));
        }

        for(int i = idx; i < nums.length; i++) { // 做选择
            item.add(nums[i]);
            dfs(nums, k, i + 1, item);
            item.remove(item.size() - 1);
        }
    }
}
