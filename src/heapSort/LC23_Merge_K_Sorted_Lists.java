package heapSort;

import java.util.PriorityQueue;

public class LC23_Merge_K_Sorted_Lists {
    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[] {
                new ListNode(1,new ListNode(2, new ListNode(5))),
                new ListNode(0,new ListNode(2, new ListNode(5))),
                new ListNode(1,new ListNode(2)),
        };

        ListNode listNode = mergeKLists(listNodes);
        while (listNode != null) {
            System.out.print(listNode.val);
            if(listNode.next != null) {
                System.out.print("->");
            }
            listNode = listNode.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] listNodes) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(
                (a,b)-> a.val - b.val
        );

        for(ListNode listNode : listNodes) {
            if(listNode != null) {
                pq.add(listNode);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            ptr.next = node;
            if(node.next != null) {
                pq.add(node.next);
            }
            ptr = ptr.next;
        }
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
