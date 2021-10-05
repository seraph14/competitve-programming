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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = null;
        TreeNode temp = root;
        if (root == null) {
            return new TreeNode(val);
        }
        while (temp != null && newNode == null) {
            if (temp.val < val) {
                if (temp.right == null) {
                    newNode = new TreeNode(val);
                    temp.right = newNode;
                }
                    
                temp = temp.right;
            } else if (temp.val > val) {
                if (temp.left == null) {
                    newNode = new TreeNode(val);
                    temp.left = newNode;
                }
                temp = temp.left;
            } 
        }
        return root;
    }
}
