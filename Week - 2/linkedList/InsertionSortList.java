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
    public ListNode insertionSortList(ListNode head) {
        ListNode current = head;
        int i;
        ListNode temp;
        while (current != null) {
            temp = current;
            while (temp != null) {
                if (temp.val < current.val) {
                    i = current.val;
                    current.val = temp.val;
                    temp.val = i;
                }
                temp = temp.next;
            }
            current = current.next;
        }
        return head;
    }
}
