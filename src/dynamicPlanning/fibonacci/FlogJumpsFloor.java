package dynamicPlanning.fibonacci;

/**
 * @author cj
 * @date 2019/12/27
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * 分析：当 n = 1 --- f(1) = 1
 *      当 n = 2 --- f(2) = 2
 *      当 n > 2 --- 第一种跳法：一开始跳一级，总的跳法=剩余台阶的跳法 f(n - 1)
 *                   第二种跳法：一开始跳二级，总的跳法=f(n - 2) ∴f(n) = f(n - 1) + f(n - 2)
 */
public class FlogJumpsFloor {
    public static void main(String[] args) {
        //测试边界值
        System.out.println(jumpsFloor(1));
        //测试正常值
        System.out.println(jumpsFloor(5));
        //测试较大值
        System.out.println(jumpsFloor(40));
    }

    public static int jumpsFloor(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
