package binarysearch;

public class LC34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public static void main(String[] args) {
        int[] test = new int[]{1,1,1,2,2,3,3,3,4,5,5};
        System.out.println(searchRange(test, 1)[0] + " " + searchRange(test, 1)[1]);
        System.out.println(searchRange(test, 2)[0] + " " + searchRange(test, 2)[1]);
        System.out.println(searchRange(test, 3)[0] + " " + searchRange(test, 3)[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[]{
                searchBoarder(nums, target, true),
                searchBoarder(nums, target, false),
        };
    }

    private static int searchBoarder(int[] nums, int target, boolean isLeftBoarder) {
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(target < nums[mid]) {
                right = mid - 1;
            } else if(target > nums[mid]) {
                left = mid + 1;
            } else {
                res = mid;
                if(isLeftBoarder) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return res;
    }
}
