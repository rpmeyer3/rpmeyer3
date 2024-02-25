public class DoubleList {
    public ListNode bigify(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        while (current != null) {
            ListNode newNode = new ListNode(current.info);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        return head;
    }
}