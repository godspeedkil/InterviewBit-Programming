package LinkedLists;

import java.util.HashSet;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Try solving it using constant additional space.
 *
 * Example :
 *
 * Input :
 *
 *                   ______
 *                  |     |
 *                  \/    |
 *         1 -> 2 -> 3 -> 4
 *
 * Return the node corresponding to node 3.
 */
public class ListCycle {

    /**
     * Hashing objects seemed like the most reasonable solution for me.
     * This leads to an effective O(n) solution that need only go once
     * through the list before detecting the loop. Only downside is memory
     * utilization is in O(n) order, but it's not too bad, since we're just
     * storing pointers.
     */
    public static ListNode detectCycle(ListNode a) {
        HashSet<ListNode> known = new HashSet<>();

        while (true) {
            known.add(a);
            if (known.contains(a.next)) return a.next;
            if (a.next==null) return null;
            a = a.next;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = head1.next.next;
        System.out.println(detectCycle(head1));
    }
}
