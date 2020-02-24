package bitwise;

/**
 * @author cj
 * @date 2020/2/23
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。h
 */
public class Add {
    public static void main(String[] args) {

    }

    public int add(int num1,int num2) {
        while (num2 != 0) { //如果进位值不为0，则继续加，直到进位值为0
            int temp = num1 ^ num2;//异或求二进制不进位加
            num2 = (num1 & num2) << 1;//且运算然后左移一位求进位值
            num1 =temp;
        }
        return num1;
    }
}
