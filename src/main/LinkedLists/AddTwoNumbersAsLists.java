package LinkedLists;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 *     342 + 465 = 807
 * Make sure there are no trailing zeros in the output list
 * So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
 */
public class AddTwoNumbersAsLists {

    /**
     * Follow along with both lists and watch out for edge cases and you can
     * get the following O(n) solution. Gotta watch out for when one list is
     * longer than the other, and when the result is longer than both lists
     * (carry is still set).
     */
    public static ListNode addTwoNumbers(ListNode A, ListNode B) {
        int carry = 0;
        ListNode result = new ListNode(-1);
        ListNode resultCurrent = result;

        while (A!=null || B!=null) {
            int valA = (A==null) ? 0 : A.val;
            int valB = (B==null) ? 0 : B.val;
            int current = valA + valB + carry;
            resultCurrent.next = new ListNode(current%10);
            carry = current/10;
            resultCurrent = resultCurrent.next;
            A = (A==null) ? null : A.next;
            B = (B==null) ? null : B.next;
        }

        if (carry==1) resultCurrent.next = new ListNode(1);

        return result.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);
        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);
        System.out.println(addTwoNumbers(head1, head2));
        ListNode head3 = new ListNode(0);
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(0);
        head4.next.next = new ListNode(1);
        System.out.println(addTwoNumbers(head3, head4));
    }
}
