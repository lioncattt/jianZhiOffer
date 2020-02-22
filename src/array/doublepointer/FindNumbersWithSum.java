package array.doublepointer;

import java.util.ArrayList;

/**
 * @author cj
 * @date 2020/2/22
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 思路：递增排序数组
 * 使用双指针：若头尾相加大于S，则让右指针往左移，寻找更小的数
 * 若小于，左指针往右移，寻找更大得数
 */
public class FindNumbersWithSum {
    public static void main(String[] args) {
        int[] a = {1,12,33,44,65};
        System.out.println(findNumbersWithSum(a, 34));
    }

    public static ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length <= 1) {
            return list;
        }
        int i = 0; // 指向小得数
        int j = array.length - 1; //指向大的数

        while (i < j) {
            int curSum = array[i] + array[j];
            if (curSum > sum) {
                j--;
            } else if (curSum < sum) {
                i++;
            } else {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }
        }
        return new ArrayList<>();
    }
}
