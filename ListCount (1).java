public class ListCount {
    public int count(ListNode list) {
        int count = 0;


        ListNode current = list;
        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }
}