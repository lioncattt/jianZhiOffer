package linkedlist;


/**
 * @author cj
 * @date 2019/12/19
 */
public class Node {
    public int val = 0;
    public Node next = null;

    Node(int val) {
        this.val = val;
    }



    public void put(Node cur) {
        this.next = cur;
    }

    public static void printNode(Node head) {
        if (head == null) {
            System.out.println("{}");
            return;
        }
        StringBuilder sb = new StringBuilder("{");
        while (head != null) {
            if (head.next == null) {
                sb.append(head.val + "}");
                System.out.println(sb.toString());
                return;
            }
            sb.append(head.val + "->");
            head = head.next;
        }
    }
}
