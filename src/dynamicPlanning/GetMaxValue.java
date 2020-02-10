package dynamicPlanning;

/**
 * @author cj
 * @date 2020/2/10
 * 在一个 m*n 的棋盘中的每一个格都放一个礼物，每个礼物都有一定的价值（价值大于0）.
 * 你可以从棋盘的左上角开始拿各种里的礼物，并每次向右或者向下移动一格，
 * 直到到达棋盘的右下角。
 * 给定一个棋盘及上面个的礼物，请计算你最多能拿走多少价值的礼物？
 *  1    10   3    8
 * 12   2    9    6
 * 5    7    4    11
 * 3    7    16   5
 *   比如说现在有一个如下的棋盘，
 *
 *
 * 在这个棋盘中，按照（1，12，5，7，7，16，5）的顺序可以拿到总价值最大53的礼物。
 *
 * 思路
 *  每个节点尝试往右递归，尝试往左递归，每次取两者较大的一条路径
 */
public class GetMaxValue {
    public static void main(String[] args) {
        int[][] values = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(getMaxValue(values));
        System.out.println(getMaxValue2(values));
    }

    public static int getMaxValue(int[][] values) {
        if (values == null || values.length <= 0) {
            return -1;
        }
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                if (values[i][j] <= 0) {
                    return -1;
                }
                max = Math.max(max, getMaxValueCore(values, i, j));
            }
        }
        return max;
    }

    /**
     * 暴力递归，时间复杂度为O(n^3)
     * @param values
     * @param i
     * @param j
     * @return
     */
    private static int getMaxValueCore(int[][] values, int i, int j) {
        if (j >= values[0].length || i >= values.length) {
            return 0;
        }
        if (i == values.length - 1 && j == values[0].length - 1) {
            return values[i][j];
        }

        return values[i][j] + Math.max(getMaxValueCore(values, i + 1, j),
                getMaxValueCore(values, i,  j + 1));
    }

    /**
     * 改动态规划 时间复杂度为O(n^2)
     * @param values
     * @return
     */
    public static int getMaxValue2(int[][] values) {
        if (values == null || values.length <= 0) {
            return -1;
        }
        int m = values.length;
        int n = values[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = values[0][0];

        for (int i = 1; i <m; i++) {
            dp[i][0] += values[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] += values[0][j] + dp[0][j - 1];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = values[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];

    }

}
