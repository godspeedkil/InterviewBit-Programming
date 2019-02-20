package Hashing;

import java.util.HashMap;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.
 *
 * Return a deep copy of the list.
 *
 * Example
 *
 * Given list
 *
 *    1 -> 2 -> 3
 * with random pointers going from
 *
 *   1 -> 3
 *   2 -> 1
 *   3 -> 1
 * You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the returned list should not link to any node in the original input list.
 */
public class CopyList {

    /**
     * As a simple deep copy exercise, I believe the main point of this exercise is to not
     * overcomplicate things and simply create a 1-to-1 mapping between old and new nodes for
     * copying purposes.
     */
    public static RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> newNodes = new HashMap<>();

        RandomListNode current = head;
        while (current!=null) {
            newNodes.put(current, new RandomListNode(current.label));
            current = current.next;
        }

        RandomListNode result = newNodes.get(head);
        while (head!=null) {
            if (head.next!=null)
                newNodes.get(head).next = newNodes.get(head.next);
            if (head.random!=null)
                newNodes.get(head).random = newNodes.get(head.random);
            head = head.next;
        }

        return result;
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
        node2.random = node1;
        node3.random = node1;
        System.out.println(node1);
        System.out.println(copyRandomList(node1));
    }
}
