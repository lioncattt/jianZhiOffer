package dynamicPlanning.fibonacci;

/**
 * @author cj
 * @date 2019/12/27
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 2 * n --> f(n)
 * n = 1 --- 1种 竖着放
 * n = 2 --- 2种 横着放和竖着放
 * n > 2 --- 竖着放，则总共方法=剩余矩形的所有方法f(n - 1) 横着放，剩余矩形方法 = f(n - 2)
 */
public class RectCover {
    public static void main(String[] args) {

    }

    public static int rectCover(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

}
