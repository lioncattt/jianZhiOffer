package str;

import java.util.Arrays;

/**
 * @author cj
 * @date 2019/12/19
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 */
public class ReplaceBlank {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We are happy.");
        System.out.println(replaceBlankByStr(sb));

    }

    /**
     * 先计算替换后str多出来的长度，由于%20比空格多2个字符，因此替换后str长度为空格数目 * 2
     * 从后往前复制直到p1遇到空格，p2替换为%20，循环直至p1和p2相遇表示空格已全部替换
     * @param str
     * @return
     * 时间复杂度为O(n)
     */
    public static String replaceBlankByStr(StringBuffer str) {
        int p1 = str.length() - 1;
        for (int i = 0; i < p1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int p2 = str.length() - 1;
        while (p1 >= 0 && p1 < p2) {
            char c = str.charAt(p1--);
            if (c != ' ') {
                str.setCharAt(p2--, c);
            } else {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            }
        }

        return str.toString();
    }
}
