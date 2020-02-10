package array;

/**
 * @author cj
 * @date 2020/2/10
 *
 * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 例如 6、8 都是丑数，但 14 不是，
 * 因为它包含因子 7。
 * 习惯上我们把 1 当做是第一个丑数。求按从小到大的顺序的第 N 个丑数。
 *
 * 思路：丑数 = 2^x * 3^y * 5^z
 * 一个数的所有因子只有235中的一个或多个就是丑数
 *  1. 能被2或3或5整除
 *  2. 该数的所有因子只能为2，3，5中的一个或多个
 */
public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(getUglyNumber(1500));
    }

    public static boolean isUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return (number == 1) ? true : false;
    }

    public static int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }
        int uglyFound = 0;
        int cur = 1;

        while (uglyFound < index) {

            if (isUgly(cur++)) {
                uglyFound++;
            }
        }
        return cur;
    }
}
