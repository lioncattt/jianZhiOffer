package bitwise;

/**
 * @author cj
 * @date 2020/2/22
 * {2,6,2,3,3,5} =>6 5
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度为O(n)，空间复杂度为O(1)。
 *
 * 思路：其他的数字都出现了两次，相同的数异或得0 a ^ a = 0
 * b ^ a ^ b = a 异或满足交换律
 *
 * 先考虑简单问题：当数组除了一个数字，其他的数字都出现了两次，
 * O(n)顺序异或最后能得出该数字
 *
 * 再考虑
 * 数组除两个数字以外，尝试将两个数字分别划分到两个子数组中，分别异或
 *
 * 先将数组顺序异或 相当于要找的两个数异或得到的数，其他数字抵消了 考虑该数的二进制
 * 因为是两个不同的数异或 0^0 = 0 0^1 = 1 1^1 = 0
 * 得到的数的二进制中某一位为1 表示原来的两个数在该位不相等，以此为 划分条件
 * 将该位为1的数字划为一组，为0的在另一组，分别异或，最后得出的两个数即为答案
 *
 * 如何判断某一位是1还是0？和1做 与运算
 */
public class FindNumsAppearOnce {
    public static void main(String[] args) {
        int[] a = new int[]{2,6,2,3,3,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        findNumsAppearOnce(a, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);
    }

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public static void findNumsAppearOnce(int[] array,int num1[] , int num2[]) {
        if (array == null || array.length <= 1 ||
                (array.length == 2 && array[0] == array[1])) {
            return;
        }
        // 假如数组只有两个数字且两个数字不等
        if (array.length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int result = 0; // 0和任何数字异或都为该数
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }

        int indexBit = findFirstBitls(result);// 找到了右数第一个为1的数
        for (int i = 0; i < array.length; i++) {
            // 分组
            if (isBit(array[i], indexBit)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }

    }

    // 找到从右边起第一个为1的数，
    // 将该数的二进制数从右边开始逐一与1做&运算，1 & 1 = 1 ,0 & 1 = 0
    private static int findFirstBitls(int result) {
        int indexBit = 0;
        while (indexBit < 32 && ((result&1) == 0)) { // <32 防止死循环，避免输入的数组只有重复两次的数
            indexBit++;
            result = result >> 1;
        }
        return indexBit;
    }

    // 判断当前数某一位是否为1
    public static boolean isBit(int num, int indexBit) {
        num = num  >> indexBit;
        return (num & 1) == 1;
    }
}
