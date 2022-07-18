package doublePointer;

public class LC11_Container_With_Most_Water {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            if(height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return res;
    }
}
