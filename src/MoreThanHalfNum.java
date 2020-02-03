/**
 * @author cj
 * @date 2020/2/3
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 思路：假若存在一个数字出现次数超过数组长度一半，
 * 则说明该数字出现次数大于其他数字出现次数之和，其他数字最终必定被抵消times=0
 *
 * 存活的数字不一定是符合题目要求(e.g.1,2,3,4),但若有超出数组长度一半的数字，
 * 则最后存活的必定是该数字
 *
 *
 * 用阵地攻守的思想：
 * 第一个数字作为第一个士兵，守阵地；count = 1；
 * 遇到相同元素，count++;
 * 遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
 * 再加一次循环，记录这个士兵的个数看是否大于数组一般即可
 */
public class MoreThanHalfNum {

    public static void main(String[] args) {
        int[] a = {1,2,3,2,2,2,5,4,2};
        System.out.println(moreThanHalfNum(a));
    }

    /**
     * 时间复杂度为O(n)
     * @param arr
     * @return
     */
    public static int moreThanHalfNum(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return 0;
        }

        int times = 1;
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (times == 0) { // 重置比较的数，继续往后找
                times = 1;
                result = arr[i];
            } else if (result == arr[i]) {
                times++;
            } else {
                times--;
            }
        }

        // 此时得出的result不一定就是结果，还需判断出现次数是否大于数组长度一半
        times = 0;
        for (int i = 0; i < arr.length; i++) {
            if (result == arr[i]) {
                times++;
            }
        }

        if (times > (arr.length / 2)) {
            return result;
        }

        return 0;
    }
}
