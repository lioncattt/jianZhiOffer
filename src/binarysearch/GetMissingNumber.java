package binarysearch;

/**
 * @author cj
 * @date 2020/2/21
 * 0~n-1中缺失的数字
 *
 * 题目：一个长度为n-1的递增数组中所有的数字都是唯一的，并且每个数字都在范围0~n-1之内，
 * 在范围内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 思路：1. n - 1个数
 *      2. 递增数组
 *      3. 所有数字唯一
 *      4. 每个数字都在0 ~ n - 1
 *      假设有n个数，则这n个数都与下标相等 0 ~ n - 1, 现在有 n - 1个数，
 *      少了一个数相等于从某个数起，往后的数都往前挪了一位即原本m + 1挪到 m的位置
 *      推出 存在一个数m，比m小的数，下标和元素相同，比m大的数下标和元素不等
 *      即 m - 1(下标) = m - 1(元素) , m + 1(下标) = m(元素)
 */
public class GetMissingNumber {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {0, 1, 2, 3};
        int[] c = {0,2,3,4};
        int[] d = {1};
        System.out.println(getMissingNumber(d));
    }

    /**
     * 二分查找 时间复杂度O(logn)
     * @param arr
     * @return
     */
    public static int getMissingNumber(int[] arr) {
       if (arr == null || arr.length <= 0) {
           return -1;
       }

        return binarySearch(arr, 0, arr.length - 1);
    }

    public static int binarySearch(int[] arr, int l, int r) {
        if (l > r) {
            return l;
        }

        int mid = l + (r - l) / 2;

        // 当前数和下标不等且左边的数和下标相等时，找到该数，或者当前数下标为0并且当前数和下标不等
        if ((mid == 0 || arr[mid - 1] == mid - 1) && arr[mid] != mid) {
            return mid;
        } else if (arr[mid] == mid) { // 和下标相等，意味着要找的数在当前数的右边
            return binarySearch(arr, mid + 1, r);
        } else {
            return binarySearch(arr, l, mid - 1);
        }
    }
}
