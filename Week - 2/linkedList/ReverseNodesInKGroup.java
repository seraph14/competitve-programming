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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode temp = head;
        ListNode groupHead;
        ListNode result = null;
        ListNode array[] = new ListNode[3];
        int i = 0, j = 0;
        while (temp != null) {
            temp = temp.next;
            j++;
        } 
        j = j / k;
        temp = head;
        while (temp != null) {
            groupHead = temp;
            if (j > 0) {
                while (i < k) {
                    array[0] = temp.next;
                    temp.next = array[1];
                    array[1] = temp;
                    temp = array[0];
                    i++;
                } 
                i = 0;
                if (array[2] != null) {
                    array[2].next = array[1];
                }
                if (result == null) {
                    result = array[1];
                    array[2] = groupHead;
                } else {
                    array[2] = groupHead;
                }
                array[0] = null;
                array[1] = null;    
            } else {
                if (array[2] != null) {
                    array[2].next = temp;
                    array[2] = null;
                }
                temp = temp.next;
            } 
            j--;
        }
        return result;
    }
}
