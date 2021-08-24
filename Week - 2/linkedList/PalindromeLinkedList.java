/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        boolean result = false;
        int i = 0;
        
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
            i++;
        }
        
        if (i == 1) {
            result = true;
        } else {
            i = i / 2;
            temp = head;
            while (i > 0) {
                if (stack.pop().val == temp.val) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
                temp = temp.next;
                i--;
            }    
        }
        return result;
    }
}
