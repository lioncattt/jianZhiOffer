package linkedlist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author cj
 * @date 2019/12/19
 * 输入一个链表的头结点，从尾到头打印链表的值
 */
public class PrintReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node cur = new Node(2);
        Node cur2 = new Node(3);
        head.put(cur);
        cur.put(cur2);
        Node.printNode(head);
        System.out.println(reverseLinkedList2(head));
    }

    /**
     * 时间复杂度 O(n) 空间复杂度 O(n)
     * @param head
     * @return
     */
    public static ArrayList<Integer> reverseLinkedList(Node head) {
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.empty()) {
            list.add(stack.pop().val);
        }
        return list;
    }

    /**
     * 时间复杂度 O(n) 空间复杂度 O(1)
     * @param head
     * @return
     */
    public static ArrayList<Integer> reverseLinkedList2(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        Node cur = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = cur;
            cur = head;
            head = next;
        }
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        return list;
    }

    /**
     * 时间复杂度 O(n) 空间复杂度 O(1)
     * @param head
     * @return
     */
    public static ArrayList<Integer> reverseLinkedList3(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        reverseNode(head, list);
        return list;
    }

    public static Node reverseNode(Node cur, ArrayList<Integer> list) {
        if (cur == null || cur.next == null) {
            list.add(cur.val);
            return cur;
        }
        cur.next = reverseNode(cur.next, list);
        list.add(cur.val);
        return cur;
    }

}


