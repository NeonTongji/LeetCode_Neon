package binarysearch;

public class LC04_Median_of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,7,9};
        int[] nums2 = new int[]{2,4,6,8,10};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0 ,right)) / 2.0;
    }

    /**
     *
     * @param nums1
     * @param i
     * @param nums2
     * @param j
     * @param k
     * @return 返回nums1和nums2中第K大的元素
     */
    private static int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if(i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if(j >= nums2.length) {
            return nums1[i + k - 1];
        }
        if(k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        // 如果 前k/2不在nums1中，那么一定在nums2中，则要剪掉nums2中k/2, 即让mid1 比mid2大，就可以把nums2剪掉
        int mid1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if(mid1 < mid2) {
            // 把mid1剪掉 k / 2, 注意奇偶，k - k/2
            return findKth(nums1,i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2,j + k / 2, k - k / 2);
        }
    }
}
