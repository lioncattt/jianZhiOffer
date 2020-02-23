package slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author cj
 * @date 2020/2/23
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * 维护一个双端队列 使其队头永远存当前最大的值
 * 每遍历一个数，从下标i >= size - 1 开始
 * 都是在从左至右连续不断的寻找每个滑动窗口[i - size + 1, i]的最大值
 */
public class MaxInWindows {
    public static void main(String[] args) {
        int[] a = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows2(a, 3));

    }

    // 暴力破解 若滑动窗口大小为k 则时间复杂度为O(nk)
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num == null || num.length <= 0 || size > num.length || size <= 0) {
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

    public static ArrayList<Integer> maxInWindows2(int [] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num == null || num.length <= 0 || size > num.length || size <= 0) {
            return ret;
        }
        LinkedList<Integer> doubleQueue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            // 假如当前元素大于队尾下标对应的元素，删除队尾，存入较大值 保证队头是当前最大值
            while (!doubleQueue.isEmpty() && num[i] > num[doubleQueue.peekLast()]) {
                doubleQueue.pollLast();
            }

            //队尾添加
            doubleQueue.add(i);
            // 假如当前队列队头存的最大值是之前的滑动窗口最先加入的值
            // 删除过期的最大值
            if (doubleQueue.peekFirst() == i - size) {
                doubleQueue.pollFirst();
            }

            // 如果当前下标 > = size - 1 均可将队头加进来 从最左向右最开始的滑动窗口开始
            if (i >= size - 1) {
                ret.add(num[doubleQueue.peekFirst()]);
            }
        }
        return ret;
    }
}
