public class ListSum {
    public int sumIter(ListNode list, int thresh) {
        int sum = 0;
        ListNode current = list;
        while (current != null) {
            int value = current.info;
            if (value > thresh) {
                sum += value;
            }
            current = current.next;
        }
        return sum;
    }


    public int sumRecur(ListNode list, int thresh) {
        if (list == null) {
            return 0;
        }
        int value = list.info;
        if (value > thresh) {
            return value + sumRecur(list.next, thresh);
        } else {
            return sumRecur(list.next, thresh);
        }
    }
}
