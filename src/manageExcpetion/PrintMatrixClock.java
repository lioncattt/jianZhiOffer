package manageExcpetion;

import java.util.ArrayList;

/**
 * @author cj
 * @date 2020/1/14
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字
 * 1,2,3,4,
 * 8,12,16,15,
 * 14,13,9,5,
 * 6,7,11,10.
 */
public class PrintMatrixClock {
    public static void main(String[] args) {

    }

    public static ArrayList printMatrixClockWisely(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return null;
        }

        return printMatrixInCircle(matrix);
    }

    public static ArrayList printMatrixInCircle(int[][] matrix) {

        return null;
    }
}
