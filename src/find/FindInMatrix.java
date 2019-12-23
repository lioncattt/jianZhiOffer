package find;

/**
 * @author cj
 * @date 2019/12/19
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * 1 2 8 9
 * 2 4 9 12
 * 4 7 10 13
 * 6 8 11 15
 */
public class FindInMatrix {
    public static void main(String[] args) {

        int[][] matrix = {{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
        // 测试用例
        int n1 = 15; // maxNumber:15
        int n2 = 1; // minNumber:1
        int n3 = 2; // between MAX and Min
        int n4 = 0; // does not exist and less than Min
        int n5 = 16; // does not exist and greater than Max
        int n6 = 3; // does not exist and  in the rage of matrix
        int[][] m = {};
        System.out.println(findInMatrix(matrix, n3));
    }

    /**
     * 找左下角或右上角的数字分析，因为处于该位置的数字可以缩小最多的范围，不会出现重叠的范围
     * @param matrix
     * @param n
     * @return
     * 时间复杂度 O(n)
     */
    public static boolean findInMatrix(int[][] matrix, int n) {
        if (matrix == null || matrix.length <= 0) {
            return false;
        }
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column < matrix[0].length) {
            if (n == matrix[row][column]) {
                return true;
            } else if (n > matrix[row][column]) {
                row++;
            } else {
                column--;
            }

        }
        return false;
    }
}
