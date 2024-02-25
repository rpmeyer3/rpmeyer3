public class RemoveMin {
    public ListNode remove(ListNode list) {
        if (list == null || list.next == null) {
            return null;
        }
        ListNode minPrev = null;
        ListNode minNode = list;
        ListNode current = list;
        int minVal = list.info;
        while (current != null && current.next != null) {
            if (current.next.info < minVal) {
                minVal = current.next.info;
                minPrev = current;
                minNode = current.next;
            }
            current = current.next;
        }
        if (minPrev == null) {
            list = list.next;
        } else {
            minPrev.next = minNode.next;
        }
        return list;
    }
}