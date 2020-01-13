package linkedlist;

/**
 * @author cj
 * @date 2020/1/8
 * 链表中倒数第 K 个结点
 * 输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
 * 从头结点开始它们的值依次是1，2，3，4，5，6。这个链表的倒数第3个结点是值为4的结点
 */
public class FindKthToTail {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        //功能测试
        System.out.println(findKthToTail(head, 1).val);
        System.out.println(findKthToTail(head, 4).val);
        System.out.println(findKthToTail(head, 2).val);
        //特殊测试
        System.out.println(findKthToTail(head, 5));
        System.out.println(findKthToTail(head, 0));
        System.out.println(findKthToTail(null, 4));

    }

    // 时间复杂度O(n)
    public static Node findKthToTail(Node head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < k - 1; i++) {
            if (fast.next == null) {
                return null;
            } else {
                fast = fast.next;
            }

        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
