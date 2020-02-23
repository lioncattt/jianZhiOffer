package array;

import java.util.Arrays;

/**
 * @author cj
 * @date 2020/2/23
 * 扑克牌顺子
 *
 * 题目描述
 *
 * 从扑克牌中随机抽取5张牌, 判断是不是一个顺子, 即这5张牌是不是连续的.
 * 2~10为数字本身, A为1, J为11, Q为12, K为13, 大小王看成是任意数字
 *
 * 0表示大小王 先给牌排序，统计不为0的数间隔的数之和 <= 0出现的次数 可以形成顺子
 * 如果出现对子，则一定不会出现顺子
 *
 */
public class IsContinuous {
    public static void main(String[] args) {
        int[] a = {0, 2, 3, 4, 5};
        int[] b= {0, 0, 2, 4, 7};
        int[] c= {1,2,3,4,5};
        int[] d = {2, 4, 7, 11};
        int[] e = {2,3,3,4,5};
        System.out.println(isContinuous(b));
    }

    public static boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        Arrays.sort(numbers);
        int countOf0 = 0;
        int i = 0;
        int countOfGap = 0;// 统计相邻的数间隔多少个数
        while (i < numbers.length && numbers[i] == 0) {
            countOf0++;
            i++;
        }

        for (; i < numbers.length - 1; i++) {
            if (numbers[i] < 0 || numbers[i] > 13 || numbers[i] == numbers[i + 1]) {
                return false;
            }

            countOfGap += numbers[i + 1] - numbers[i] - 1;
        }

        return countOfGap > countOf0 ? false : true;
    }
}
