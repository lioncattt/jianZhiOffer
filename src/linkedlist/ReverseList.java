package linkedlist;

/**
 * @author cj
 * @date 2020/1/8
 * 反转链表
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点
 */
public class ReverseList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        //System.out.println(reverseList(head).val);
        Node.printNode(reverseList2(head));
    }

    // 时间复杂度O(n)
    public static Node reverseList(Node head) {
        if (head == null) {
            return null;
        }
        Node preNode = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = next;
        }
        return preNode;
    }

    // 时间复杂度O(n)
    public static Node reverseList2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node reverseHead = reverseList2(head.next);
        // head.next = head; 注意：不是让当前节点的指针指向自己，当前节点指针应该指向上一个节点
        // 让当前节点的下一个节点的指针指向当前节点
        head.next.next = head;
        // 避免成环
        head.next = null;
        return reverseHead;
    }
}
