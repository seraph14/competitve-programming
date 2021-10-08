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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> path = new Stack<>();
        Stack<TreeNode> leafs = new Stack<>();
        int sum = 0;
        TreeNode temp;
        stack.push(root);
        path.push(root);
        while (!stack.isEmpty()) {
            temp = stack.pop();
            if (temp == null) continue;
            
            if (!leafs.isEmpty() && leafs.peek() != temp) {
                System.out.println(temp.val);
                TreeNode temp2 = path.peek();
                while (!path.isEmpty() && path.peek() != temp) {
                    temp2 = path.pop();
                    if (temp2 == null) continue;
                    System.out.println(temp2.val); 
                    if (sum < 0) {
                        sum += -temp2.val;
                    } else {
                        sum -= temp2.val;    
                    } 
                }
            }
            
            sum += temp.val;
            
            if (sum == targetSum && temp.left == null && temp.right == null) {
                return true;
            }
            
            if (temp.left == null && temp.right == null) {
                leafs.push(temp);
            }
            
            
            path.push(temp.right);
            stack.push(temp.right);
            
            path.push(temp.left);
            stack.push(temp.left);     
            
        }
        
        return false;
    }
}
