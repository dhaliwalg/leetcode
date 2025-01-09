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


    class Node {

        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public Node reverseList(Node head) {
        // Handle empty list or single node
        if (head == null || head.next == null) {
            return head;
        }
        
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            // Store next
            next = current.next;
            
            // Reverse current node's pointer
            current.next = prev;
            
            // Move pointers one position ahead
            prev = current;
            current = next;
        }
        
        return prev;  // prev is the new head
    }
}