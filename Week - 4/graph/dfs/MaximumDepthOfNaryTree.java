/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children.size() == 0) return 1;
        int[] depths = new int[root.children.size()];
        int i = 0;
        for (Node child : root.children) {
            depths[i++] = 1 + maxDepth(child);
        }
        
        int max = Integer.MIN_VALUE;
        for (int depth : depths) {
            if (depth > max) 
                max = depth;
        }
        
        return (max == Integer.MIN_VALUE) ? 0 : max;
    }
}
