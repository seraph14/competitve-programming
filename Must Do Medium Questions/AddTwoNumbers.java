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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode head = temp;
        int rem = 0;
        int addend;
        while (rem != 0 || l1 != null || l2 != null) {
            if (l2 == null && l1 != null) {
                addend = l1.val + rem;
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                addend = l2.val + rem;
                l2 = l2.next;
            } else if (l1 == null && l2 == null && rem != 0) {
                addend = rem;  
            } else {
                addend = l1.val + l2.val + rem;    
                l1 = l1.next;
                l2 = l2.next;
            }
            
            temp.val = addend % 10;
            rem = addend / 10;
            if (l1 != null || l2 != null || rem != 0) {
                temp.next = new ListNode();
            }
            temp = temp.next;
        }
        return head;
    }
}
