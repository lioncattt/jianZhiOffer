package backtracking;

/**
 * @author cj
 * @date 2020/1/3
 * 打印从 1 到最大的 n 位数
 * 题目描述
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 *
 * 解题思路
 * 由于 n 可能会非常大，因此不能直接用 int 表示数字，而是用 char 数组进行存储。
 */
public class Print1ToMaxOfNDigits {
    public static void main(String[] args) {
        print1ToMaxOfNDigits2(1);

    }

    public static void print1ToMaxOfNDigits(int n) { //此种方法当n较大时，无法输出
        if (n <= 0) {
            return;
        }
        int num = 1;
        int i = 1;
        while (i++ <= n) {
            num *= 10;
        }
        for (int j = 1; j < num; j++) {
            System.out.println(j);
        }
    }

    /**
     * 空间复杂度O(n) 时间复杂度O(n)
     * @param n
     */
    public static void print1ToMaxOfNDigits2(int n) {
        if (n <= 0) {
            return;
        }
        char[] num = new char[n];//定义一个char数组存储当前n位数
        print1ToMaxOfNDigits2Core(num, 0);//从下标为0开始递归
    }

    private static void print1ToMaxOfNDigits2Core(char[] num, int curIndex) {
        if (curIndex == num.length) {
            printNum(num);
            return;
        }
        for(int i = 0; i <= 9; i++) {
            num[curIndex] = (char) (i + '0');//让当前位选择0-9数字
            print1ToMaxOfNDigits2Core(num, curIndex + 1);
        }
    }

    private static void printNum(char[] num) {
        int index = 0;
        while (index < num.length && num[index] == '0') { //打印当前字符直到遇到不为0的字符
            index++;
        }
        while (index < num.length) {
            System.out.print(num[index++]);
        }
        System.out.println();
    }
}
