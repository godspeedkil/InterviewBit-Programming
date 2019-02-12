package LinkedLists;

import java.util.List;

/**
 * Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.
 *
 * Notes:
 *
 * Expected solution is linear in time and constant in space.
 * For example,
 *
 * List 1-->2-->1 is a palindrome.
 * List 1-->2-->3 is not a palindrome.
 */
public class PalindromeList {

    private static ListNode reverse(ListNode secondHalf) {
        ListNode prev = null;
        ListNode current = secondHalf;
        ListNode next;
        while (current!=null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        secondHalf = prev;
        return secondHalf;
    }

    private static int compareLists(ListNode head1, ListNode head2) {
        ListNode temp1 = head1, temp2 = head2;

        while (temp1!=null && temp2!=null) {
            if (temp1.val==temp2.val) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else
                return 0;
        }

        if (temp1==null && temp2==null)
            return 1;

        return 0;
    }

    /**
     *  Easiest way is to use the properties of linked lists (mainly that
     *  they rely on pointers), to flip one half of the list, and compare it
     *  with the other half. If the list size is odd, just ignore the middle
     *  node.
     *
     *  Solution is O(n) runtime and O(1) extra space.
     */
    public static int lPalin(ListNode A) {
        ListNode slowPtr = A, fastPtr = A;
        ListNode slowPrev = A;
        int result = 1;

        if (A!=null && A.next!=null) {
            while (fastPtr!=null && fastPtr.next!=null) {
                fastPtr = fastPtr.next.next;
                slowPrev = slowPtr;
                slowPtr = slowPtr.next;
            }
            if (fastPtr!=null) {
                slowPtr = slowPtr.next;
            }

            ListNode secondHalf = slowPtr;
            slowPrev.next = null;
            secondHalf = reverse(secondHalf);
            result = compareLists(A, secondHalf);
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(1);
        System.out.println(lPalin(head1));
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        System.out.println(lPalin(head2));
    }
}
