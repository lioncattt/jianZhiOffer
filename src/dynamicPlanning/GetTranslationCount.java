package dynamicPlanning;

/**
 * @author cj
 * @date 2020/2/4
 * 给定一个数字，按照如下规则翻译成字符串：0翻译成“a”，1翻译成“b”…25翻译成“z”。
 * 一个数字有多种翻译可能，
 * 例如12258一共有5种，分别是bccfi，bwfi，bczi，mcfi，mzi。
 * 实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 思路：
 * 每个数字有两种选择方案
 * 第一种：
 * 选当前数字翻译, 递归下一个数字
 * 第二种：
 * 选当前数字和下一个数字一起翻译，递归下下一个数字，前提是加了该数字后范围在10 ~ 25
 *
 * 总数目 = 两种方案数目之和
 *
 */
public class GetTranslationCount {
    public static void main(String[] args) {
        System.out.println(getTranslationCount(12258));

    }

    public static int getTranslationCount(int digits) {
       if (digits < 0) {
           return -1;
       }
       String s = String.valueOf(digits);
       int len = s.length();
       String[] str = new String[len];
       for (int i = 0; i < len; i++) {
          str[i] = s.substring(i, i + 1);
       }
       return getTranslationCountCore(str, 0);

    }

    private static int getTranslationCountCore(String[] str, int i) {
        // 递归出口
        if (i >= str.length - 1) {
            // 表示该轮递归结束 返回1
            return 1;
        }
        String temp = str[i] + str[i + 1];
        int cur = Integer.valueOf(temp);
        int result =  getTranslationCountCore(str, i + 1)
                + (cur >= 10 && cur <= 25 ? getTranslationCountCore(str, i + 2) : 0);
        return result;
    }


}
