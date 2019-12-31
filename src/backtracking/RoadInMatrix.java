package backtracking;

/**
 * @author cj
 * @date 2019/12/27
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 */
public class RoadInMatrix {
    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = {'b', 'c', 'c', 'e', 'd'};
        System.out.println(hasPath(matrix, 3, 4, str));
    }

    /**
     * 时间复杂度O(n^2) 空间复杂度O(n^2)
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }
        boolean[] memo = new boolean[matrix.length]; // 记录当前元素是否可回溯
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, memo, rows, cols, row, col, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean hasPathCore(char[] matrix, boolean[] memo, int rows, int cols,
                                       int row, int col, char[] str, int strIndex) {
        if (strIndex >= str.length) { // 匹配完至最后一个字符
            return true;
        }
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            return false;
        }

        boolean hasPath = false;
        //当前节点 = 当前字符串中对应节点 并且 该节点可进入
        if (matrix[row * cols + col] == str[strIndex] && (memo[row * cols + col] == false)) {
            strIndex++; // 比较下一个字符
            memo[row * cols + col] = true; //标记当前节点已进入过
            //若满足有一条路径找到则返回
            hasPath = hasPathCore(matrix, memo, rows, cols, row, col - 1, str, strIndex)
                    || hasPathCore(matrix, memo, rows, cols, row + 1, col, str, strIndex)
                    || hasPathCore(matrix, memo, rows, cols, row - 1, col, str, strIndex)
                    || hasPathCore(matrix, memo, rows, cols, row, col + 1, str, strIndex);

            //若递归此次节点未找到任何一条路径 则重置memo 并且 返回之前的字符 继续尝试递归
            if (!hasPath) {
                memo[row * cols + col] = false; //还原，让该节点能继续被下次遍历递归
                strIndex--;
            }

        }
        return hasPath;
    }
}
