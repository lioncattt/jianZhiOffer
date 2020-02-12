package array.sort;

import java.text.ParseException;

/**
 * @author cj
 * @date 2020/2/11
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数
 * e.g. (7,5,6,4) => (7,5) (7,6) (7,4) (6,4) (5,4)
 */
public class InversePairs {

    static int[] temp;
    static int result = 0;


    public static void main(String[] args) throws ParseException {
        int[] a = {7,5,6,4};
        //System.out.println(inversePairs(a));
        System.out.println(inversePairs2(a));


    }

    // 时间复杂度O(n^2)
    public static int inversePairs(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length - 1 ; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 使用归并排序 时间复杂度n * log(n)
     * @param arr
     * @return
     */
    public static int inversePairs2(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return 0;
        }
        temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
        return result;
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (r - l < 1) {
            return;
        }
        int m = l + (r - l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        // 合并
        merge(arr, l, m, r);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int left = l;
        int right = m + 1;
        int t = l;

        while (left <= m || right <= r) {
            if (left > m) { // 左半部分子数组已比较完，将右边子数组剩余值赋值给辅助数组
                temp[t] = arr[right++];
            } else if (right > r) {
                temp[t] = arr[left++];
            } else if (arr[left] <= arr[right]) {
                temp[t] = arr[left++];
            } else {
                temp[t] = arr[right++];
                result += m - left + 1; // 若遇到左边数组的某个值比右边的数大，表示该值后面的数都比右边的数大
            }
            t++;
        }

        for (t = l; t <= r; t++) {
            arr[t] = temp[t];
        }
    }
}
