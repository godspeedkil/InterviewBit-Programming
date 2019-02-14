package LinkedLists;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL.
 *
 *  Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list. Note 2:
 * Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question.
 */
public class ReverseLinkListII {

    private static ListNode reverse(ListNode A) {
        ListNode prev = null;
        ListNode current = A;

        while (current!=null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static ListNode reverseBetween(ListNode A, int B, int C) {
        if (B==C) return A;

        ListNode subPrev = null, subNext = null;
        ListNode subHead = null, subTail = null;

        int i = 1;
        ListNode current = A;
        while (i<=C) {
            if (i<B)
                subPrev = current;

            if (i==B)
                subHead = current;

            if (i==C) {
                subTail = current;
                subNext = current.next;
            }

            current = current.next;
            i++;
        }
        subTail.next = null; // otherwise reverse won't know where to stop
        subTail = reverse(subHead);

        if (subPrev!=null)
            subPrev.next = subTail;
        else
            A = subTail;

        subHead.next = subNext;
        return A;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        int b1 = 1;
        int c1 = 5;
        System.out.println(reverseBetween(head1, b1, c1));
    }
}
