package array;

/**
 * @author cj
 * @date 2020/2/4
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,
 * 是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和
 */
public class FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        int[] a = {6,-3,-2,7,-15,1,2,2};
        System.out.println(findGreatestSumOfSubArray2(a));
    }

    // 枚举所有子数组和，时间复杂度为O(n^2)
    public static int findGreatestSumOfSubArray(int[] num) {
        if (num == null || num.length <= 0) {
            return -1;
        }
        int result = num[0];

        for (int i = 0; i < num.length; i++) {
            int cur = 0;
            for (int j = i; j < num.length; j++) {
                cur += num[j];
                result = result >= cur ? result : cur;
            }

        }
        return result;
    }

    /**
     * 时间复杂度O(n)
     * @param num
     * @return
     */
    public static int findGreatestSumOfSubArray2(int[] num) {
        if (num == null || num.length <= 0) {
            return -1;
        }
        int curSum = 0; // 记录当前的累加和
        int greatestSum = Integer.MIN_VALUE; // 记录每一次累加后的最大和

        for (int i = 0; i < num.length; i++) {
            if (curSum <= 0) { // 之前的累加和若<=0, 则抛弃之前的数，从当前数开始
                curSum  = num[i];
            } else { // 大于0，则累加
                curSum += num[i];
            }

            if (curSum > greatestSum) {
                greatestSum = curSum;
            }
        }
        return greatestSum;

    }
}
