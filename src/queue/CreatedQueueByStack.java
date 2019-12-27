package queue;

import java.util.Stack;

/**
 * @author cj
 * @date 2019/12/27
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class CreatedQueueByStack {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        CreatedQueueByStack cqs = new CreatedQueueByStack();
        cqs.push(1);
        cqs.push(2);
        cqs.push(3);
        System.out.println(cqs.pop());
        System.out.println(cqs.pop());
        cqs.push(4);
        System.out.println(cqs.pop());
        System.out.println(cqs.pop());
    }

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.empty()) {
            return stack2.pop();
        }
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
