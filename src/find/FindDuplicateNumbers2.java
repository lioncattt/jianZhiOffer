package find;

/**
 * @author cj
 * @date 2019/12/18
 * 在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的输出是重复的数字2或者3。
 */
public class FindDuplicateNumbers2 {
    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(getDuplication(a, a.length, 1, a.length - 1));
    }

    /**
     * 将数组通过二分分为1 ~ m, m + 1 ~ n, 统计数组中出现1 ~ m的次数，若大于1 ~ m个数，则表示重复的数字在[1,m]中
     * 否则在[m + 1, n]中，继续二分直至最后一个元素
     * @param a
     * @param length
     * @return 重复则返回某个数字 没有重复的返回-1
     * 时间复杂度O(n * logn) 空间复杂度O(1)
     */
    public static int getDuplication(int[] a, int length, int start, int end) {
        if (a == null || a.length <= 1) {
            return -1;
        }
        int mid = 0;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            int count = countRange(a, length, start, mid);// 统计[start, mid]在数组中出现的次数

            if (start == end) { // 二分至仅剩一个元素
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }
        return -1;
    }


    private static int countRange(int[] a, int length, int start, int mid) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (a[i] >= start && a[i] <= mid) {
                count++;
            }
        }
        return count;
    }

}
