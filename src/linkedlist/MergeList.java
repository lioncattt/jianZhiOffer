package linkedlist;

/**
 * @author cj
 * @date 2020/1/8
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeList {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(4);
        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(4);
        head2.next.next.next = new Node(5);

        // 边界值测试
        Node.printNode(mergeList(head1, null));
        Node.printNode(mergeList(null, head2));
        Node.printNode(mergeList(null, null));

        System.out.println("=============");
        Node.printNode(mergeList(head1, head2));

    }

    /**
     * 递归
     * @param head1
     * @param head2
     * @return
     */
    public static Node mergeList(Node head1, Node head2) {

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.val <= head2.val) {
            head1.next = mergeList(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeList(head1, head2.next);
            return head2;
        }

    }

    /**
     * 错误解法 未考虑链表长度不等的情况
     * @param head1
     * @param head2
     * @return
     */
    public static Node mergeList2(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        while ( cur1 != null && cur2 != null) {

            if (cur1.val <= cur2.val) {
                Node next1 = cur1.next;
                cur1.next = cur2;
                cur1 = next1;
            } else {
                Node next2 = cur2.next;
                cur2.next = cur1;
                cur2 = next2;
            }
        }

        if (head1.val <= head2.val) {
            return head1;
        } else {
            return head2;
        }
    }

    /**
     * 迭代 空间复杂度O(1)
     * @param head1
     * @param head2
     * @return
     */
    public static Node mergeList3(Node head1, Node head2) {
        Node preHead = new Node(-1);// 迭代后通过该指针找到头指针
        Node pre = preHead;// 用来遍历合并过程的有序链表
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) { // 比较出两个值中较小的值
                pre.next = head1; // 构造合并后的有序链表
                head1 = head1.next;
            } else {
                pre.next = head2;
                head2 = head2.next;
            }
            pre = pre.next;// 永远指向循环结束的空节点的前一个节点
        }
        pre.next = head1 == null ? head2 : head1;
        return preHead.next;
    }


}
