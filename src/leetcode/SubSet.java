package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cj
 * @date 2020/1/15
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubSet {
    public static void main(String[] args) {
        int[] nums = {1,2,3};

    }

    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>()); // 初始化
        subsetsCore(nums, 0, lists);
        return null;
    }

    private static void subsetsCore(int[] nums, int i, List<List<Integer>> lists) {
        if (i >= nums.length) {
            return;
        }
        int size = lists.size();
        // 每次递归从头遍历当前lists集合
        for (int j = 0; j < size; j++) {
            // 定义一个临时的list存储当前lists集合的每一个list
            List<Integer> list = new ArrayList<>(lists.get(j));
            list.add(nums[i]);
            lists.add(list);
        }
        subsetsCore(nums, i + 1, lists);
    }
}
