package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC39_Combination_Sum {
    public static void main(String[] args) {
        int[] a = new int[]{2,3,4,5,6,7};
        int[] b = new int[]{3,4,2,7,6,5};
        System.out.println(combinationSum(a, 7));
//        System.out.println(combinationSum(b, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private static void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int idx) {
        // base case
        if(target < 0) {
            return;
        }
        if(target == 0) {
            res.add(new ArrayList<>(list));
        }

        // back trace
        for(int i = idx; i < candidates.length; i++) {
            list.add(candidates[i]);
            target -= candidates[i];
            dfs(candidates, target, res, list, i);
            target += candidates[i];
            list.remove(list.size() - 1);
        }
    }
}
