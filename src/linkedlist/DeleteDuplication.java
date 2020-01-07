package linkedlist;

/**
 * @author cj
 * @date 2020/1/7
 * 删除排序链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 思路总结：先考虑一般情况，即链表节点个数>2且存在重复节点时的指针移动
 *          再考虑特殊情况 不存在重复节点时指针移动
 */
public class DeleteDuplication {
    public static void main(String[] args) {
        // 测试当仅有两个节点，且两个节点相同
        Node head = new Node(2);
        head.next = new Node(2);
        Node.printNode(deleteDuplication(head));
        //普通情况
        System.out.println("=======");
        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(2);
        Node.printNode(deleteDuplication(head2));
        //边界值
        System.out.println("=======");
        Node head3 = new Node(4);
        Node.printNode(deleteDuplication(head3));
        //没有重复值
        System.out.println("========");
        Node head4 = new Node(1);
        head4.next = new Node(3);
        Node.printNode(deleteDuplication(head4));
    }

    public static Node deleteDuplication(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node virtualHead = new Node(0); // 创建虚拟头结点，用于满足当链表仅有两个节点且节点相同时的情况
        virtualHead.next = head;
        Node preNode = virtualHead;// 指向第一个重复节点的前一个节点
        Node last = preNode.next; // 用于定位重复节点
        while (last != null) {
            if (last.next ==null || last.next.val != last.val) {
                preNode = preNode.next;
                last = last.next;
            } else {
                // 第一个条件last.next != null 是 用来终止当链表仅有两个节点且节点相同时的情况
                while (last.next != null && last.next.val == last.val) {
                    last = last.next; // 每次判断与last.next节点是否相同，若相同则定位至最后一个重复节点
                }
                preNode.next = last.next;
                last = last.next;
            }
        }
        //return head; 不是返回当前head，因为当head为时重复节点要被删除
        return virtualHead.next;

    }
}
