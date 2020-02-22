package linkedlist;

/**
 * @author cj
 * @date 2020/2/19
 * 两个链表的第一个公共结点
 * 1 -> 2 -> 3
 *            -> 6 -> 7
 *      4 -> 5
 *
 * 思路：(1) 暴力破解 时间复杂度O(m * n) m，n为两个链表的长度
 * (2) 栈 将链表放入两个栈，从后往前遍历，比较找到最后一个相同的节点
 *     空间复杂度 O(m + n) 时间复杂度O(n)
 * (3) 求出两个链表长度之差，让长的先走该差值的步数，再两个链表一起走
 */
public class FindFirstCommonNode {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        Node commonNode = new Node(6);
        head1.next.next.next = commonNode;
        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = commonNode;
        System.out.println(findFirstCommonNode(head1, head2).val);
    }

    public static Node findFirstCommonNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int length1 = getListLength(head1);
        int length2 = getListLength(head2);
        int diff = length1 - length2;
        Node longHead = head1;
        Node shortHead = head2;
        if (diff < 0) {
            longHead = head2;
            shortHead = head1;
        }
        for (int i = 0; i < diff; i++) {
            longHead = longHead.next;
        }
        while (longHead != null && shortHead != null && longHead != shortHead) {
            longHead = longHead.next;
            shortHead = shortHead.next;
        }

        return longHead;
    }

    public static int getListLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

}
