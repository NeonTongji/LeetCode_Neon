package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_3Sum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{0,0,0,0,0}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length < 3) {
            return lists;
        }
        // 选一个元素为中间元素，左指针0，右指针len - 1, 双指针找到
        // int l = 0, m = 1, r = nums.length - 1;
        for(int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            int j = i + 1, k = nums.length - 1;
            while (i < nums.length - 2 && nums[i] == nums[++i]);
            while(j < k) {
                while(j < k && nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }
                while(j < k && nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                if(j < k && nums[i] + nums[j] + nums[k] == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    lists.add(list);
                    while (j < k && nums[j] == nums[j + 1]){
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    j++;
                    k--;
                }
            }
        }

        return lists;
    }
}
