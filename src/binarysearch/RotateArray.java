package binarysearch;

/**
 * @author cj
 * @date 2019/12/27
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *
 * 分析：把数组分为{3,4,5},{1,2}两个递增数组 最小值恰为两数组分界处
 * 设置left指向旋转数组最左边，right指向旋转数组最右边，当mid指向的值大于left指向的值
 * 移动left，说明最小值在mid~right之间
 * 当mid指向的值小于right，移动right，说明最小值可能为mid或left~mid之间
 * left始终在左边子数组中移动，right始终在右边子数组移动
 * 当两者相距1时则right指向的值即为最小值
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] a = new int[]{3,4,5,1,2};
        System.out.println(rotateArray(a));
    }

    // 二分法 时间复杂度O(logn) 空间复杂度O(1)
    public static int rotateArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (nums[left] >= nums[right]) {
            mid = (right - left) / 2 + left;
            if (right - left == 1) {
                mid = right;
                break;
            }
            // 考虑特殊情况若三个下标指向的数字相等，则只能顺序比较出最小值 e.g {1,1,1,0,1}
            if (nums[left] == nums[right] && nums[left] == nums[mid]) {
                return minInOrder(nums, left, right);
            }

            if (nums[mid] >= nums[left]) {
                left = mid;
            } else if (nums[mid] <= nums[right]) {
                right = mid;
            }
        }
        return nums[mid];
    }

    private static int minInOrder(int[] nums, int left, int right) {
        int min = nums[0];
        for (int i = left + 1; i < right; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return min;
    }


}
