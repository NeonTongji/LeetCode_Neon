package recursion;

public class LC19_Remove_The_Nth_Node_Of_LinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4, new ListNode(5)))));
        System.out.println(removeNthFromEnd(node, 2));
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        return helper(head, n, 0);
    }

    private static ListNode helper(ListNode head, int n, int cur) {
        if(head == null) {
            return null;
        }
        head.next = removeNthFromEnd(head.next, n);
        cur++;
        if(cur == n) {
            return head.next;
        }
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

