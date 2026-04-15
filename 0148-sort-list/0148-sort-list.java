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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)return head;

        ListNode mid = findMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        mid.next = null;
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        return merge(leftHead, rightHead);
    }

    public static ListNode merge(ListNode l1,ListNode l2){
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(t1 != null && t2 != null){
            if(t1.val < t2.val){
                temp.next = t1;
                temp = temp.next;
                t1 = t1.next;
            }else{
                temp.next = t2;
                temp = temp.next;
                t2 = t2.next;
            }
        }
        if(t1 != null){
            temp.next = t1;
        }
        if(t2 != null){
            temp.next = t2;
        }
        return dummy.next;
    }

    public ListNode findMiddle(ListNode head) {
        if(head == null || head.next == null)return null;

        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}