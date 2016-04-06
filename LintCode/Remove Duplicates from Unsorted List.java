/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        HashSet<Integer> set = new HashSet<Integer>();
        while (head != null) {
            if (set.contains(head.val)) {
                prev.next = head.next;
                head = head.next;
                continue;
            }
            set.add(head.val);
            head = head.next;
            prev = prev.next;
        }
        return dummy.next;
    }
}