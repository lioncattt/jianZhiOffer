package array.doublepointer;

/**
 * @author cj
 * @date 2020/2/23
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 */
public class LeftRotateString {
    public static void main(String[] args) {
        String s = "abcXYZdef";
        String s2 = "";
        String s3 = null;
        System.out.println(LeftRotateString(s2, 6));
        System.out.println(LeftRotateString(s, 3));
        System.out.println(LeftRotateString(s3, 8));
    }

    public static String LeftRotateString(String str,int n) {
        if (str == null || str.trim().equals("") || n <= 0) {
            return str;
        }
        char[] a = str.toCharArray();
        reverse(a, 0, n - 1);
        reverse(a, 0, a.length - 1);
        reverse(a, 0, a.length - n - 1);
        return new String(a);
    }

    private static void reverse(char[] a, int i, int j) {
        while (i < j) {
            swap(a, i++, j--);
        }
    }

    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
