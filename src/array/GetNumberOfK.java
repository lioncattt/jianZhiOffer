package array;

/**
 * @author cj
 * @date 2020/2/19
 * 统计一个数字在排序数组中出现的次数。
 * e.g {1,2,3,3,3,3,4,5} 3出现4次 返回4
 *
 * 思路：因为是排序数组，考虑二分法
 * 用二分法找到第一个k和最后一个k，下标相减
 */
public class GetNumberOfK {
    public static void main(String[] args) {
        int[] a = {1,2,3,3,3,3,4,5};
        System.out.println(getNumberOfK2(a, 7));
    }

    /**
     * 顺序查找 时间复杂度为O(n)
     * @param arr
     * @param k
     * @return
     */
    public static int getNumberOfK(int[] arr, int k) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                count++;
            }
        }
        return count;
    }

    /**
     * 二分查找 时间复杂度O(logn)
     * @param arr
     * @param k
     * @return
     */
    public static int getNumberOfK2(int[] arr, int k) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int firstK = getFirstK(arr, k, 0, arr.length - 1);
        int lastK = getLastK(arr, k, 0, arr.length - 1);

        return firstK != -1 && lastK != -1 ? lastK - firstK + 1 : 0;
    }

    private static int getLastK(int[] arr, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] > k) {
            return getLastK(arr, k, start, mid - 1);
        } else if (arr[mid] < k) {
            return getLastK(arr, k, mid + 1, end);
        } else {
            if ((mid != arr.length - 1 && arr[mid + 1] != k) || mid == arr.length - 1) {
                return mid;
            }
            return getLastK(arr, k, mid + 1, end);
        }
    }

    private static int getFirstK(int[] arr, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (k < arr[mid]) {
            return getFirstK(arr, k, start, mid - 1);
        } else if (k > arr[mid]) {
            return getFirstK(arr, k, mid + 1, end);
        } else {
            if ((mid != 0 && arr[mid - 1] != k) || mid == 0) {
                return mid;
            }
            return getFirstK(arr, k, start, mid - 1);
        }

    }

}
