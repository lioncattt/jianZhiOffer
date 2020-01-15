package leetcode;

import java.util.Arrays;

/**
 * @author cj
 * @date 2020/1/14
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * O O O
 * O O O
 * O O O
 * 不变
 *
 * X X X X
 * X O O X
 * X X O X
 * X O O X
 * 不变
 *
 *
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，
 * 或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：关键在于利用dfs找出所有与边界连通的O，替换为其他字符#，再把剩余不在边界的O且不与
 * 边界连通的O替换为'X', 再还原'#'为'O'
 *
 * 思考：若从不在边界的O开始走，无法确定何时才能走到边界
 * 反过来想，可以先从边界O开始走，由外向内递归
 */
public class FindSurroundingArea {
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},
                {'X','X','O','X'},{'X','O','O','X'}};
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    public static void solve(char[][] board) {
        if (board == null || board.length <= 0) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean isArea = i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1;
                // 从边界O开始递归
                if (isArea && board[i][j] == 'O') {
                    solve(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 先替换剩余不和边界相连的O
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                // 再还原与边界O相连的O
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private static void solve(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i > board.length - 1
                || j > board[0].length - 1 || board[i][j] == 'X' || board[i][j] == '#') {
            // board[i][j] = '#' 表示已遍历过
            return;
        }
        board[i][j] = '#';
        solve(board, i + 1, j);
        solve(board, i - 1, j);
        solve(board, i, j - 1);
        solve(board, i, j + 1);
    }
}
