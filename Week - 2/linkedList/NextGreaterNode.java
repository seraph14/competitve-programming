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
    public int[] nextLargerNodes(ListNode head) {
        int[] answer;
        ListNode current = head;
        ListNode temp;
        int i = 0;
        while (current != null) {
            i++;
            current = current.next;
        }
        answer = new int[i];
        i = 0;
        current = head;
        while (current != null) {
            temp = current;
            while (temp != null) {
                if (current.val < temp.val) {
                    answer[i] = temp.val;
                    break;
                } 
                temp = temp.next;
            }
            current = current.next;
            i++;
        }
        return answer;
    }
}
