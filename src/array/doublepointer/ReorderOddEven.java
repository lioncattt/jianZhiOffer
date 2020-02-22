package array.doublepointer;

import java.util.Arrays;

/**
 * @author cj
 * @date 2020/1/7
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
 */
public class ReorderOddEven {
    public static void main(String[] args) {
        int[] a = new int[]{2,4,8,1,3,5};
        recordOddEven3(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 常规思想：每遇到一个偶数，即把该偶数后面的数往前挪，直至剩下最后一个位置，将该数置于最后一个位置
     * 当循环完整个数组后，排序完毕(冒泡)
     * 时间复杂度O(n^2) 能保证顺序不变
     * @param a
     */
    public static void recordOddEven(int[] a) {
        int i = 0;
        int cur = 0;
        while (cur < a.length) {
            if (oddOrEven(a[i])) {
                int temp = a[i];
                for (int j = i + 1; j < a.length; j++) {
                    a[j - 1] = a[j];
                }
                a[a.length - 1] = temp;
            } else {
                i++;
            }
            cur++;
        }
    }

    private static boolean oddOrEven(int a) {
        return (a & 1) == 0; // 奇数最后一位为1，偶数最后一位为0
    }

    /**
     * 双指针
     * 时间复杂度为O(n)，但会打乱数组奇偶数原有顺序
     * @param a
     */
    private static void recordOddEven2(int[] a) {
        int start = 0;// 指向偶数的指针
        int end = a.length - 1;// 指向奇数的指针
        while (start < end) {
            while (start < end && !oddOrEven(a[start])) {
                start++;// 从左向右找直至找到一个偶数
            }
            while (start < end && oddOrEven(a[end])) {
                end--;// 从右向左找直至找到一个奇数
            }
            if (start < end) { // start = end表示找不到一个奇数或者偶数
                swap(a, start, end);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 空间换时间 空间复杂度为O(n) 时间复杂度O(n)
   * @param a
     */
    public static void recordOddEven3(int[] a) {
        int[] temp = new int[a.length];
        int i = 0;
        int countOdd = 0;
        for (int num : a) {
            if(!oddOrEven(num)) {
                countOdd++;// 统计奇数个数，奇数个数即为temp数组中偶数开始位置
            }
        }
        for (int num : a) {
            if (oddOrEven(num)) {
                temp[countOdd++] = num;
            } else {
                temp[i++] = num;
            }
        }
        System.out.println(Arrays.toString(temp));
    }
}
