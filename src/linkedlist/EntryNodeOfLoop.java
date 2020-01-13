package linkedlist;

/**
 * @author cj
 * @date 2020/1/8
 * 链表中环的入口结点
 * 如果一个链表中包含环，请找出该链表的环的入口结点。要求不能使用额外的空间。
 */
public class EntryNodeOfLoop {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;
        System.out.println(entryNodeOfLoop(head).val);
    }

    // 时间复杂度O(n)
    public static Node entryNodeOfLoop(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null; // 至少三个节点成环
        }
        Node slow = meetingNode(head);
        if (slow == null) {
            return null;
        }
        Node fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // 先判断当前链表是否有环
    private static Node meetingNode(Node head) {
        Node fast = head.next.next;
        Node slow = head.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
