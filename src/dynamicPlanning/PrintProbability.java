package dynamicPlanning;

import java.util.HashMap;

/**
 * @author cj
 * @date 2020/2/23
 * n 个骰子的点数
 * 把 n 个骰子扔在地上，求点数和为 s 的概率。
 * 输入n 打印出所有s的可能值出现的概率
 *
 * 暴力递归，用map存储每次递归到终点对应的curSum和出现的次数count
 */
public class PrintProbability {
    public static void main(String[] args) {
        printProbability(6);

    }

    static int maxValue = 6;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void printProbability(int number) {
        probabilityCore(number, 0);
        for (Integer curSum : map.keySet()) {
            double ratio = map.get(curSum) / (Math.pow(maxValue, number));
            System.out.printf("和为%d的概率为:%f%n", curSum, ratio);
        }
    }

    private static void probabilityCore(int number, int curSum) {
        if (number < 1) {
            if (!map.containsKey(curSum)) {
                int count = 1;
                map.put(curSum, count);
            } else {
                map.put(curSum, map.get(curSum) + 1);
            }
            return;
        }

        for (int i = 1; i <= maxValue; i++) {
            probabilityCore(number - 1,curSum + i);
        }
    }

}
