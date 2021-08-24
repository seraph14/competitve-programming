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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        ListNode first = head;
        boolean duplicate = false;
        while (temp != null) {
            if (!duplicate && temp.next != null && temp.val == temp.next.val) {
                duplicate = true;
                first = temp;
            } else if (duplicate && temp.val != first.val) {
                first.next = temp;
                first = temp;
            } else if (duplicate && temp.next == null) {
                first.next = null;
            }
            System.out.println(duplicate);
            temp = temp.next;
        }
        return head;
    }
}
