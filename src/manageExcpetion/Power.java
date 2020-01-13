package manageExcpetion;

/**
 * @author cj
 * @date 2019/12/31
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power {

    public static void main(String[] args) {
        System.out.println(power(2,4));
        for (char i = 65; i <= 90; i++) {
            System.out.println(i);
        }
    }

    /**
     * 此种解法考虑不周全，仅考虑次方为正数时的情况
     * 未考虑次方为0或为负数的情况
     * base为0时，exponent = 0也需考虑
     * @param base
     * @param exponent
     * @return
     */
    public static double power(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}
