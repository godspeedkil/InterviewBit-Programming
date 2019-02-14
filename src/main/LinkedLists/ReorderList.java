package LinkedLists;

/**
 * Given a singly linked list
 *
 *     L: L0 → L1 → … → Ln-1 → Ln,
 * reorder it to:
 *
 *     L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * You must do this in-place without altering the nodes’ values.
 *
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {

    private static ListNode reverse(ListNode A) {
        ListNode current = A;
        ListNode prev = null;

        while (current!=null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    /**
     * My O(n) solution is based on finding the second half of the list and
     * reversing it. Then, we can just alternate between nodes, and add the
     * midNode at the end, in case the number of elements is odd.
     */
    public static ListNode reorderList(ListNode A) {
        if (A==null || A.next==null || A.next.next==null)
            return A;

        ListNode slowPtr = A, fastPtr = A;
        ListNode secondHalf;
        ListNode midNode = null;

        while (fastPtr!=null && fastPtr.next!=null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        if (fastPtr!=null) {
            secondHalf = slowPtr.next;
            midNode = slowPtr;
            midNode.next = null;
        }
        else
            secondHalf = slowPtr;

        secondHalf = reverse(secondHalf);

        ListNode currentList1 = A;

        while (secondHalf!=null) {
            ListNode tempList1 = currentList1.next;
            ListNode tempList2 = secondHalf.next;
            currentList1.next = secondHalf;
            if (tempList2!=null)
                secondHalf.next = tempList1;
            else
                if (midNode!=null)
                    secondHalf.next = midNode;
                else
                    secondHalf.next = null;
            currentList1 = tempList1;

            secondHalf = tempList2;
        }

        return A;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        System.out.println(reorderList(head1));
        head1.next.next.next.next = new ListNode(5);
        System.out.println(reorderList(head1));
    }
}
