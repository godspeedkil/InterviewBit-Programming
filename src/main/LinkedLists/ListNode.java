package LinkedLists;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; next = null; };

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


//    @Override
//    public String toString() {
//        return "" + val;
//    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
