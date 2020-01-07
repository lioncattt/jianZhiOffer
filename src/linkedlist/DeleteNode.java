package linkedlist;

/**
 * @author cj
 * @date 2020/1/6
 * 在 O(1) 时间内删除链表节点
 * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 * 思路：若查找出被删除节点的前一个节点在删除，时间复杂度为O(n)
 * 1. 如果要删除的节点不是尾节点，先找到被删除节点的下一个节点，将值赋值给被删节点，再将
 * 被删节点指针指向下一个的下一个节点，删除被删节点的下一个节点
 * 2. 如果被删节点是尾节点并且也是头结点，则直接删除
 * 3. 被删节点不是头结点但是尾节点，则找出被删节点的前序节点删除
 */
public class DeleteNode {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(7);
        head.next.next = new Node(9);
        head.next.next.next = new Node(2);
        Node.printNode(head);
        Node.printNode(deleteNode(head, head.next.next));// 删除非尾节点
        Node.printNode(deleteNode(head, null));// 删除空节点
        Node.printNode(deleteNode(head, head.next.next));// 删除尾节点但不为头结点
        Node.printNode(deleteNode(head, head)); // 删除头结点且为尾节点
    }

    public static Node deleteNode(Node head, Node toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return null;
        }
        if (toBeDeleted.next != null) { // 被删节点不是尾节点
            Node next = toBeDeleted.next;
            toBeDeleted.val = next.val;
            toBeDeleted.next = next.next;
            next.next = null;
        } else if (toBeDeleted.next == null && head == toBeDeleted) {// 被删节点既是头结点也是尾节点
            head = null;
        } else { // 被删节点是尾节点但不为头结点
            Node cur = head;
            while (cur.next != toBeDeleted) {
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }
}
