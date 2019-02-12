package LinkedLists;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.
 *
 * For example, given following linked lists :
 *
 *   5 -> 8 -> 20
 *   4 -> 11 -> 15
 * The merged list should be :
 *
 * 4 -> 5 -> 8 -> 11 -> 15 -> 20
 */
public class MergeTwoSortedLists {

    /**
     * Again, another simple solution, we create one new pointer to keep the
     * head of the "new" list and update pointers accordingly until one of
     * the first list empties. Then just add what's left of the other.
     */
    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        if (A==null) return B;
        else if (B==null) return A;

        ListNode head = new ListNode(-1);
        ListNode current = head;

        while (A!=null && B!=null) {
            if (A.val<B.val) {
                current.next = A;
                current = current.next;
                A = A.next;
            }
            else {
                current.next = B;
                current = current.next;
                B = B.next;
            }
        }

        if (A!=null) {
            current.next = A;
        }

        if (B!=null) {
            current.next = B;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(8);
        head1.next.next = new ListNode(20);
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(11);
        head2.next.next = new ListNode(15);
        System.out.println(mergeTwoLists(head1, head2));
    }
}
