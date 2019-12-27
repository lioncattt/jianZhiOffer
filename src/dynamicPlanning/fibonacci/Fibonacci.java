package dynamicPlanning.fibonacci;

/**
 * @author cj
 * @date 2019/12/27
 * 斐波那契数列
 * 求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }

   //时间复杂度O(n) 空间复杂度O(1)
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
