package leetcode;

import java.util.Arrays;

/**
 * @author cj
 * @date 2020/2/3
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int i = 0, j = 0;
        for (int m = 0; m < nums.length; m++) {
            if (nums[m] == 0) {
                i++;
            } else if (nums[m] == 1) {
                j++;
            }
        }
        int n = 0;
        for (; n < i; n++) {
            nums[n] = 0;
        }
        for (int g = 0; g < j; g++) {
            nums[n++] = 1;
        }
        for (; n < nums.length; n++) {
            nums[n] = 2;
        }

    }

    public static void sortColors2(int nums[]) {
        int p1 = 0;
        int p2 = nums.length - 1;
        int cur = 0;
        int temp = 0;
        while (cur < p2) {

            if (nums[cur] == 0) {
                temp = nums[cur];
                nums[cur++] = nums[p1];
                nums[p1++] = temp;
            } else if (nums[cur] == 2) {
                temp = nums[cur];
                nums[cur] = nums[p2];
                nums[p2--] = temp;
            } else {
                cur++;
            }
        }
    }
}
