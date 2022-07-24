package deviceAndConquer;

public class LC23_Merge_K_Sorted_Lists {
    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[] {
                new ListNode(1,new ListNode(2, new ListNode(5))),
                new ListNode(0,new ListNode(2, new ListNode(5))),
                new ListNode(1,new ListNode(4, new ListNode(5))),
                new ListNode(1,new ListNode(3, new ListNode(8))),
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
        return mergeSort(listNodes, 0, listNodes.length - 1);
    }

    // 分治
    private static ListNode mergeSort(ListNode[] listNodes, int left, int right) {
        if(left > right) {
            return  null;
        }
        if(left == right) {
            return  listNodes[left];
        }
        int mid = left + ((right - left) >> 1);
        ListNode l1 = mergeSort(listNodes, left, mid);
        ListNode l2 = mergeSort(listNodes, mid + 1, right);
        return merge2Lists(l1, l2);
    }

    private static ListNode merge2Lists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return  l1;
        }
        if(l1.val < l2.val) {
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        } else {
            l2.next = merge2Lists(l1, l2.next);
            return l2;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
