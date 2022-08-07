package recursion;


public class LC298_Longest_consecutive_path_in_binary_tree {
    static int max = 0;

    public static void main(String[] args) {
        /**              5
         *            4      2
         *                 3   4
         *               4  2
         *             5  1
         *
         */

        TreeNode treeNode =
                new TreeNode(5,
                        new TreeNode(4),
                        new TreeNode(2,
                                new TreeNode(3),
                                new TreeNode(4))
                );

        longestConsecutivePathInBinaryTree(treeNode, 1, 1);
//        longestConsecutivePathInBinaryTree(treeNode, 1, -1);
        System.out.println(max);
    }

    private static void longestConsecutivePathInBinaryTree(TreeNode node, int len, int inc){
        if(node == null) {
            return ;
        }
        // 每次递归过程都更新最大值
        max = Math.max(max, len);
        if(node.left != null) { //如果连续
            if(node.left.val == node.val + inc) {
                longestConsecutivePathInBinaryTree(node.left, len + 1, inc);
            } else {
                longestConsecutivePathInBinaryTree(node.left, 1, inc);
            }
        }
        if(node.right != null) {
            if(node.right.val == node.val + inc) {
                longestConsecutivePathInBinaryTree(node.right, len + 1, inc);
            } else {
                longestConsecutivePathInBinaryTree(node.left, 1, inc);
            }
        }
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
