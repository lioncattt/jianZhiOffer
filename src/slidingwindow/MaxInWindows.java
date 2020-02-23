package slidingwindow;

import java.util.ArrayList;

/**
 * @author cj
 * @date 2020/2/23
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows {
    public static void main(String[] args) {
        int[] a = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(a, 3));
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num == null || num.length <= 0 || size > num.length) {
            return ret;
        }
        for (int i = 0; i < num.length; i++) {
            int length = i + size - 1;
            int index = i;
            int max = num[i];
            if (length < num.length) {
                while ( index < length) {
                    max = max >= num[index + 1] ? max : num[index + 1];
                    index++;

                }
                ret.add(max);
            }
        }
        return ret;
    }
}
