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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode temp;
        for (ListNode list : lists) {
            temp = list;
            while (temp != null) {
                pq.offer(temp.val);
                temp = temp.next;
            }
        }
        
        ListNode root = null;
        ListNode temp2 = new ListNode();
        temp = new ListNode();
        while (pq.size() > 0) {
            if (root == null)
                root = temp;
            temp2 = temp;
            temp.next = new ListNode();
            temp.val = pq.poll();
            temp = temp.next;
        }
        
        temp2.next = null;
        
        return root;
    }
}
