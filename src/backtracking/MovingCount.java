package backtracking;

/**
 * @author cj
 * @date 2019/12/30
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount {
    public static void main(String[] args) {
        System.out.println(movingCount(18, 36, 39));
    }

    /**
     * 时间复杂度O(n^2) 空间复杂度O(n^2)
     * @param threshold 阈值k
     * @param rows
     * @param cols
     * @return
     */
    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return -1;
        }
        boolean marked[][] = new boolean[rows][cols];//标记已走过的节点，走过的节点就不能再回去了

        return movingCountCore(threshold, rows, cols, 0, 0, marked);
    }

    private static int movingCountCore(int threshold, int rows, int cols,
                                       int row, int col, boolean[][] marked) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, marked)) {
            marked[row][col] = true;//标记为已进入过
            count = 1 + movingCountCore(threshold, rows, cols, row + 1, col, marked)
                    + movingCountCore(threshold, rows, cols, row - 1, col, marked)
                    + movingCountCore(threshold, rows, cols, row, col - 1, marked)
                    + movingCountCore(threshold, rows, cols, row, col + 1, marked);
        }
        return count;
    }

    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] marked) {
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && ((getDigitSum(row) + getDigitSum(col)) <= threshold)
                && !marked[row][col]) {
            return true;
        }
        return false;
    }

    private static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) { //除数
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
