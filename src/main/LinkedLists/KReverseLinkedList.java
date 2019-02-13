package LinkedLists;

import java.util.List;

/**
 * Given a singly linked list and an integer K, reverses the nodes of the
 *
 * list K at a time and returns modified linked list.
 *
 *  NOTE : The length of the list is divisible by K
 * Example :
 *
 * Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,
 *
 * You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5
 *
 * Try to solve the problem using constant extra space.
 */
public class KReverseLinkedList {

    /**
     * The O(n) solution is based on simple reversal, just do it as many
     * times as B allows. A recursive approach is good in order to not have
     * to keep the head of any sublist in a pointer.
     */
    public static ListNode reverseList(ListNode A, int B) {
        ListNode current = A;
        ListNode next = null, prev = null;

        for (int i=0; i<B; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        if (next!=null)
            A.next = reverseList(next, B);

        return prev;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        System.out.println(reverseList(head1, 2));
    }
}
