package slidingwindow;

import java.util.ArrayList;

/**
 * @author cj
 * @date 2020/2/22
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 他马上就写出了正确答案是100。但是他并不满足于此,他
 * 在想究竟有多少种连续的正数序列的和为100
 * (至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，
 * 序列间按照开始数字从小到大的顺序
 *
 * [9, 10, 11, 12, 13, 14, 15, 16]
 * [18, 19, 20, 21, 22]
 *
 * 思路：滑动窗口
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        System.out.println(findContinuousSequence(3));
    }

    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int low = 1;
        int high = 2;

        while (low < high) {
            int curSum = (low + high) * (high - low + 1) / 2;

            if (curSum < sum) {
                high++;
            } else if (curSum > sum) {
                low++;
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    temp.add(i);
                }
                ret.add(temp);
                high++;
                low++;
            }

        }
        return ret;
    }
}
