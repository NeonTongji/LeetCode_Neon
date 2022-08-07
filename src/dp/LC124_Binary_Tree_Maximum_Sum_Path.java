package dp;

public class LC124_Binary_Tree_Maximum_Sum_Path {
    static int res;
    public static void main(String[] args) {
        /**              2
         *         3            4
         *    -5       3     -1     2
         *  最大路径  3 3 2 4 2 = 14
         */
        TreeNode root = new TreeNode(2,
                new TreeNode(3,
                        new TreeNode(-5),
                        new TreeNode(3)),
                new TreeNode(4,
                        new TreeNode(-1),
                        new TreeNode(2)));

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        findMaxSumPath(root);
        return res;
    }

    // 找到以root为尾结点的最大路径和
    private static int findMaxSumPath(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = 0;
        left = Math.max(0, findMaxSumPath(root.left));
        int right = 0;
        right = Math.max(0, findMaxSumPath(root.right));

        //----------------在递归中获取最大路径和------------
        res = Math.max(0, (left + right + root.val));

        return Math.max(left, right) + root.val;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
