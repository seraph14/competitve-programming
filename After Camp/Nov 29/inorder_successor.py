"""
Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
"""


class Solution:
    """
    @param: root: The root of the BST.
    @param: p: You need find the successor node of p.
    @return: Successor of p.
    """
    def inorderSuccessor(self, root, p):
        # write your code here
        successor = None
        curr = root

        while curr:
            if not successor and curr.val > p.val or curr.val > p.val < successor.val:
                successor = curr

            if p.val < curr.val:
                curr = curr.left
            else:
                curr = curr.right

        return successor
