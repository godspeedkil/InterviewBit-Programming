package Extra;

import LinkedLists.ListNode;

/**
 * Given a singly linked list, modify the value of first half nodes such that :
 *
 * 1st node’s new value = the last node’s value - first node’s current value
 * 2nd node’s new value = the second last node’s value - 2nd node’s current value,
 * and so on …
 *
 *  NOTE :
 * If the length L of linked list is odd, then the first half implies at first floor(L/2) nodes. So, if L = 5, the first half refers to first 2 nodes.
 * If the length L of linked list is even, then the first half implies at first L/2 nodes. So, if L = 4, the first half refers to first 2 nodes.
 * Example :
 *
 * Given linked list 1 -> 2 -> 3 -> 4 -> 5,
 *
 * You should return 4 -> 2 -> 3 -> 4 -> 5
 * as
 *
 * for first node, 5 - 1 = 4
 * for second node, 4 - 2 = 2
 * Try to solve the problem using constant extra space.
 */
public class Subtract {

    private static ListNode reverse(ListNode secondHalf) {
        ListNode current = secondHalf;
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
     * Pretty much the same approach to all of the other half-linked list problems. In order to
     * do it in-place, we keep references to the points where we'll be playing around with the
     * second half, and make sure to reverse twice.
     */
    public static ListNode subtract(ListNode A) {
        ListNode slowPtr = A, fastPtr = A;
        ListNode secondHalf, slowPrev = null;

        while (fastPtr!=null && fastPtr.next!=null) {
            slowPrev = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        if (fastPtr!=null)
            secondHalf = slowPtr.next;
        else
            secondHalf = slowPtr;

        ListNode reversedSecondHalf = reverse(secondHalf);
        ListNode currentReverse = reversedSecondHalf;
        ListNode current = A;

        while (currentReverse!=null) {
            current.val = currentReverse.val - current.val;
            current = current.next;
            currentReverse = currentReverse.next;
        }

        secondHalf = reverse(reversedSecondHalf);

        if (fastPtr!=null)
            slowPtr.next = secondHalf;
        else
            slowPrev.next = secondHalf;

        return A;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println(subtract(head1));
    }
}
