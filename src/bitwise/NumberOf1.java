package bitwise;

/**
 * @author cj
 * @date 2019/12/31
 * 输入一个整数，输出该数二进制表示中1的个数
 */
public class NumberOf1 {
    public static void main(String[] args) {
        System.out.println(numberOf1(9));
        System.out.println(numOf1(9));
    }

    /**
     * 与1做&运算
     * 每次用num最右边的数和1作&运算(1&1=1 0&1=0) 若最右边数为1则得1，为0则得0
     * 只有两种结果
     *
     * 此种方法遇到负数会死循环
     * @param num
     * @return
     */
    public static int numberOf1(int num) {
       int count = 0;
       while (num != 0) {
          if ((num & 1) == 1) {
            count++;
          }
          num = num >> 1;
       }
       return count;
    }

    /**
     * 常规解法：让flag每次向左移一位，和num逐位比较
     * @param num
     * @return
     */
    public static int numOf1(int num) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((num & flag) != 0) {
                count++;
            }
            flag = (flag << 1);
        }
        return count;
    }




}
