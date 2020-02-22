package array.doublepointer;

/**
 * @author cj
 * @date 2020/2/22
 *  翻转单词顺序列
 * NowCoder
 *
 * 题目描述
 * Input:
 * "I am a student."
 *
 * Output:
 * "student. a am I"
 *
 * 保持单词的顺序不变
 */
public class Reverse {
    public static void main(String[] args) {
        String s = " ";
        String s2 = null;
        String s3 = "";
        String s4 = "I am a student.";
        System.out.println(reverse(s));
        System.out.println(reverse2(s4));
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param str
     * @return
     */
    public static String reverse(String str) {
        if (str.trim().equals("")) {
            return str;
        }
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb = i != 0 ? sb.append(arr[i] + " ") : sb.append(arr[i]);
        }
        return sb.toString();
    }

    /**
     * 先翻转整个字符串，再反转每个单词
     * @param str
     * @return
     */
    public static String reverse2(String str) {
        if (str.trim().equals("")) { //排除包含多个空格或者空串
            return str;
        }
        char[] a = str.toCharArray();
        // 翻转整个句子
        reverseCore(a, 0, a.length - 1);
        int i = 0;
        while (i < a.length) {

            //先找出第一个不为" "的字符下标
            while (a[i] == ' ') {
                i++;
            }
            int end = i + 1;
            while (end < a.length && a[end] != ' ') {
                end++;
            }
            //局部翻转单词
            reverseCore(a, i, end - 1);
            i = end;
        }
        return new String(a);

    }

    private static void reverseCore(char[] a, int start, int end) {
        while (start < end) {
            swap(a, start++, end--);
        }
    }

    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
