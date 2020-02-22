package binarysearch;

/**
 * @author cj
 * @date 2020/2/22
 * 数组中数值和下标相等的元素
 * 题目：假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实现一个函数，
 * 找出数组中任意一个数值等于其下标的元素。例如，在数组{-3，-1,1,3,5}中，数字3和它的下标相等。
 *
 * 思路：单调递增 唯一
 * 找出一个数：二分法
 *
 *
 *
 */
public class GetNumberSameAsIndex {
    public static void main(String[] args) {
        int[] a = {-3,-1,1,3,5};
        int[] b = {-3,-1,1,2,5}; // 不包含
        int[] c = {0, 2, 3};// 开头
        int[] d = {-1, 0, 2};// 结尾
        System.out.println(getNumberSameAsIndex(d));
    }

    public static int getNumberSameAsIndex(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }

        int l = 0;
        int r = arr.length - 1;
        int mid = l + (r - l) / 2;

        while (l <= r) {
            if (arr[mid] == mid) {
                return mid;
            } else if (arr[mid] < mid) { // 当前数的值比下标小，说明该数左边所有值都比下标小，若存在相等的值找右边
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            mid = l + (r - l) / 2;
        }
        return -1;
    }



}
