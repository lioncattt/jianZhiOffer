package linkedlist;

import java.util.LinkedList;

/**
 * @author cj
 * @date 2020/2/23
 * 圆圈中最后剩下的数
 *
 * 题目描述
 * 让小朋友们围成一个大圈。然后，随机指定一个数 m，让编号为 0 的小朋友开始报数。
 * 每次喊到 m-1 的那个小朋友要出列唱首歌，然后可以在礼品箱中任意的挑选礼物，
 * 并且不再回到圈中，从他的下一个小朋友开始，
 * 继续 0...m-1 报数 .... 这样下去 .... 直到剩下最后一个小朋友，可以不用表演
 *
 * (注：小朋友的编号是从0到n-1)
 *
 * 如果没有小朋友，请返回-1
 */
public class LastRemaining {
    public static void main(String[] args) {

        System.out.println(lastRemaining(5, 3));
    }

    /**
     * 使用双端队列 模拟
     * 时间复杂度O(m * n)
     * 空间复杂度O(n)
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1) {
            // 利用公式
            index = (index + m - 1) % list.size();
            list.remove(index);

        }
        return list.size() == 1 ? list.get(0) : -1;
    }

}


