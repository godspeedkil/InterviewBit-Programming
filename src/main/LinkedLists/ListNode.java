package LinkedLists;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; };

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode temp = this;
        while (temp!=null) {
            result.append(temp.val + " ");
            temp = temp.next;
        }
        return result.toString();
    }
}
