/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if(head == null) return null;
        ListNode runner = head;
        int carry = helper(runner);
        if(carry == 1){
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }
    
    private int helper(ListNode head){
        if(head == null) return 1;
        int carry = helper(head.next);
        if(head.val == 9 && carry == 1){
            head.val = 0;
            return 1;
        }else{
            head.val = head.val + carry;
            return 0;
        }
    } 
}