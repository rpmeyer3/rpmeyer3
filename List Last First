public class ListLastFirst {
    public ListNode move(ListNode list) {
        if (list == null || list.next == null) {
            return list;
        }
        ListNode current = list;
        ListNode previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        current.next = list;
        list = current;
        return list;
    }
}
