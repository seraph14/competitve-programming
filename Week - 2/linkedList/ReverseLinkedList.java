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
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode array[] = new ListNode[2];
        ListNode temp = head;
        while (temp != null) {
            array[0] = temp.next;
            temp.next = array[1];
            array[1] = temp;
            temp = array[0];
        } 
        return array[1];
    }
}
