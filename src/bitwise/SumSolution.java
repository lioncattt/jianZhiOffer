package bitwise;

/**
 * @author cj
 * @date 2020/2/23
 * 求1+2+3+...+n，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 利用逻辑与构造条件
 */
public class SumSolution {
    public static void main(String[] args) {
        System.out.println(sumSolution(100));
    }

    public static int sumSolution(int n) {

        //return n != 1 ? n + sumSolution(n - 1) : 1;
        int sum = n;
        boolean flag = (n > 1) && ((sum += sumSolution(n - 1)) > 1);
        return sum;
    }
}
