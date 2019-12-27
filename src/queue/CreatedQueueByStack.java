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

    public void push(int node) { // O(1)
        stack1.push(node);
    }

    public int pop() { // O(n)
        if (!stack2.empty()) {  // 注意考虑若此时队列元素未全部弹出时继续插入元素，弹出时仍需保持原来的队列顺序
            return stack2.pop();
        }
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
