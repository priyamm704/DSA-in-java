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
        if(head == null || head.next == null)return head;

        ListNode prevTail = null;
        ListNode temp = head;
        while(temp != null){
            ListNode kthNode = temp;
            int count = 1;
            while(kthNode != null && count < k){
                kthNode = kthNode.next;
                count++;
            }
            if(kthNode == null){
                if(prevTail != null)prevTail.next = temp;
                return head;
            }

            ListNode front = kthNode.next;
            kthNode.next = null;
            ListNode reverseHead = reverseIterative(temp);

            if(temp == head){
                head = reverseHead;
            }else{
                prevTail.next = reverseHead;
            }

            prevTail = temp;
            temp = front;
        }
        return head;
    }

    public static ListNode reverseIterative(ListNode head){
        if(head == null || head.next == null)return head;

        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        return prev;
    }
}