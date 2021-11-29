"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

class Solution:
    """
    @param root: the given BST
    @param p: the given node
    @return: the in-order predecessor of the given node in the BST
    """
    def inorderPredecessor(self, root, p):
        # write your code here
        curr = root
        predecessor = None

        while curr:
            if not predecessor and curr.val < p.val:
                predecessor = curr

            if curr.val < p.val and curr.val > predecessor.val:
                predecessor = curr

            if p.val <= curr.val:
                curr = curr.left
            else:
                curr = curr.right
        
        return predecessor
