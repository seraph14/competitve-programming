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
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        TreeNode root = new TreeNode(preorder[0]);
        int leftIndex = 1;
        int rightIndex = preorder.length;
        while (rightIndex > 0 && root.val < preorder[rightIndex - 1]) {
            rightIndex--;
        }
        
        root.left = bstFromPreorder(Arrays.copyOfRange(preorder, leftIndex, rightIndex));
        if (rightIndex < preorder.length) {
            root.right = bstFromPreorder(Arrays.copyOfRange(preorder, rightIndex, preorder.length));    
        } else {
            root.right = bstFromPreorder(new int[0]);    
        }
        
        
        return root;
    }
}
