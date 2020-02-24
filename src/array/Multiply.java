package array;

/**
 * @author cj
 * @date 2020/2/23
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。（注意：
 * 规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 *
 * 思路：
 * 从上往下先求A[0] ~ A[i-1]
 * 从下往上求A[i + 1] ~ A[n - 1] 累乘原来的B[i]
 */
public class Multiply {
    public static void main(String[] args) {
        int[] a = new int[1];

    }

    // 暴力破解 O(n^2)
    public static int[] multiply(int[] A) {
        if (A == null || A.length < 2) {
            return null;
        }
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            int temp = 1;
            for (int j = 0; j < A.length; j++) {
                if (i == j) {
                    continue;
                }
                temp *= A[j];
            }
            B[i] = temp;
        }
        return B;
    }

    //构建矩阵，时间复杂度为O(n)
    public static int[] multiply2(int[] A) {
        if (A == null || A.length < 2) {
            return null;
        }
        int[] B = new int[A.length];
        B[0] = 1;
        // 从上到下构造
        for (int i = 1; i < B.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }

        // 从下往上构造
        int temp = 1;
        for (int i = B.length - 2; i >=0 ; i--) {
            temp *= A[i + 1];
            B[i] *= temp;
        }
        return B;
    }
}
