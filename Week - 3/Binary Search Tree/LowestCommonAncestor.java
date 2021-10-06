/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root, temp;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            temp = stack.pop();
            if (temp == null) {
                continue;
            }
            
            if (temp.val < p.val && temp.val < q.val) {
                ancestor = temp.right;
            } else if (temp.val > p.val && temp.val > q.val) {
                ancestor = temp.left;
            } else {
                ancestor = temp;
                break;
            }
            stack.push(ancestor);
        }
        
        return ancestor;
    }
}
