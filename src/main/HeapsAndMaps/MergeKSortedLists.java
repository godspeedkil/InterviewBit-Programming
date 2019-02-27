package HeapsAndMaps;

import LinkedLists.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 *
 * Example :
 *
 * 1 -> 10 -> 20
 * 4 -> 11 -> 13
 * 3 -> 8 -> 9
 * will result in
 *
 * 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 */
public class MergeKSortedLists {

    private static int getMin(ArrayList<ListNode> mins) {
        int min = mins.get(0).val;
        int currentIndex = 0;

        for (int i=1; i<mins.size(); i++) {
            if (mins.get(i).val<min) {
                min = mins.get(i).val;
                currentIndex = i;
            }
        }

        return currentIndex;
    }

    private static ListNode add(ListNode head, ListNode tail, ListNode current) {
        if (head.val==0) {
            head.val = current.val;
            return head;
        }

        ListNode temp = new ListNode(current.val);
        tail.next = temp;
        tail = temp;
        return tail;
    }

    public static ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        ArrayList<ListNode> mins = new ArrayList<ListNode>();

        for (int i=0; i<a.size(); i++)
            mins.add(a.get(i));

        while (mins.size()>0) {
            int index = getMin(mins);
            ListNode current = mins.get(index);

            if (current.next==null)
                mins.remove(index);
            else
                mins.set(index, current.next);

            tail = add(head, tail, current);
        }

        return head;
    }

    /**
     * Naive O(kn)-based approach relies on recursively merging every pair of lists until we are
     * left with only one.
     */
    private static ListNode mergeTwo(ListNode a, ListNode b) {
        ListNode smaller = (a.val<=b.val) ? a : b;
        ListNode smallerPrev = smaller;
        ListNode bigger = (a.val<=b.val) ? b : a;
        ListNode result = smaller;
        while (smaller!=null && bigger!=null) {
            if (smaller.val<=bigger.val) {
                smallerPrev = smaller;
                smaller = smaller.next;
            }
            else {
                ListNode current = bigger;
                smallerPrev.next = current;
                bigger = bigger.next;
                current.next = smaller;
                smallerPrev = smallerPrev.next;
            }
        }

        if (bigger!=null) {
            smallerPrev.next = bigger;
        }

        return result;
    }

    public static ListNode mergeKListsNaive(ArrayList<ListNode> a) {
        ListNode result = a.get(0);

        for (int i=1; i<a.size(); i++)
            result = mergeTwo(result, a.get(i));

        return result;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(10);
        head1.next.next = new ListNode(20);
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(11);
        head2.next.next = new ListNode(13);
        ListNode head3 = new ListNode(3);
        head3.next = new ListNode(8);
        head3.next.next = new ListNode(9);
        ArrayList arrayList1 = new ArrayList<ListNode>(Arrays.asList(head1, head2, head3));
        System.out.println(mergeKLists(arrayList1));
    }
}
