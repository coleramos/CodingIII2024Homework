package drive;

public class doublyLinkedListSort {

    public static void Sort(doublyLinkedList.LinkedList list, boolean ascending) {
        list.m_head = mergeSort(list.m_head, ascending);

        // Update tail reference after sorting
        list.m_tail = list.m_head;
        if (list.m_tail != null) {
            while (list.m_tail.next != null) {
                list.m_tail = list.m_tail.next;
            }
        }
    }

    private static doublyLinkedList.Node mergeSort(doublyLinkedList.Node head, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }

        doublyLinkedList.Node middle = getMiddle(head);
        doublyLinkedList.Node nextOfMiddle = middle.next;
        middle.next = null;

        doublyLinkedList.Node left = mergeSort(head, ascending);
        doublyLinkedList.Node right = mergeSort(nextOfMiddle, ascending);

        return sortedMerge(left, right, ascending);
    }

    private static doublyLinkedList.Node sortedMerge(doublyLinkedList.Node left, doublyLinkedList.Node right, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;

        int comparison = left.compareTo(right);
        if ((ascending && comparison <= 0) || (!ascending && comparison > 0)) {
            left.next = sortedMerge(left.next, right, ascending);
            if (left.next != null) left.next.previous = left;
            left.previous = null;
            return left;
        } else {
            right.next = sortedMerge(left, right.next, ascending);
            if (right.next != null) right.next.previous = right;
            right.previous = null;
            return right;
        }
    }

    private static doublyLinkedList.Node getMiddle(doublyLinkedList.Node head) {
        if (head == null) return head;
        doublyLinkedList.Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
