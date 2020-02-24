package array;

/**
 * @author cj
 * @date 2020/2/23
 * 股票的最大利润（一次卖出）
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可获得的最大利润是多少？
 *
 * 例子：
 * 例如，一只股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}。
 * 如果我们能在价格为5的时候买入并在价格为16时卖出，则能获得最大的利润为11.
 *
 * 思路：求最大利润，即求当前数组从左至右最大的差值
 * 从左到右求出(0, i - 1)中的最小值，当前值 - 前面的最小值，和之前保存的最大差值比较
 */
public class MaxDiff {
    public static void main(String[] args) {
        int[] a = new int[]{9,11,8,5,7,12,16,14};
        System.out.println(maxDiff2(a));
    }

    //暴力破解
    public static int maxDiff(int[] prices) {
        int maxDiff = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length - 1; i++) {
            int temp = maxCore(prices, i + 1) - prices[i] ;
            maxDiff =  temp > maxDiff ? temp : maxDiff;

        }
        return maxDiff;
    }

    public static int maxCore(int[] a, int i) {
        if (i == a.length) {
            return 0;
        }

        return Math.max(a[i], maxCore(a, i + 1));
    }

    /**
     * 时间复杂度O(n)
     * 从第三个数开始比较，找出前面最小值，求当前数和最小值之差，和前面保存的最大值比较
     * @param prices
     * @return
     */
    public static int maxDiff2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int maxDiff = prices[1] - prices[0];
        int curDiff = 0;
        for (int i = 2; i < prices.length; i++) {
            min = prices[i - 1] < min ? prices[i - 1] : min;
            curDiff = prices[i] - min;
            maxDiff = curDiff > maxDiff ? curDiff : maxDiff;
        }
        return maxDiff;
    }


}
