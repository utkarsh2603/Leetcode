/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class INT {
        int val;
    }
    public int maxPathSum(TreeNode root) {
        INT maxPathLen = new INT();
        maxPathLen.val = Integer.MIN_VALUE;
        dfs(root, maxPathLen);
        return maxPathLen.val;
    }

    int dfs(TreeNode root, INT maxLen) {
        if(root == null)
            return 0;
        int left = Math.max(dfs(root.left, maxLen), 0);
        int right = Math.max(dfs(root.right, maxLen), 0);
        maxLen.val = Math.max(maxLen.val, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}