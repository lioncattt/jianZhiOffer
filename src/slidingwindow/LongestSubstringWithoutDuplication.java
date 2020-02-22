package slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cj
 * @date 2020/2/10
 * 最长不含重复字符的子字符串
 * 题目描述
 * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。
 * 例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 *
 * 思路：使用滑动窗口，类似一个数组或有节集合，窗口会根据某些条件向一边扩展它的边界和移动
 *
 * 以字符串每个字母为起始，判断由它开始的字符串最长多长无重复
 * 用一个set去重集合存储当前不重复的子串(滑动窗口)
 * 假设[i, j]为不重复子字符串, j + 1为出现过在[i,j]中的字符
 * 表示遇到一个与set中相同的字符，当前子字符串统计完毕，移除set中i位字符， 重置窗口，
 * 滑动窗口左边界至下一个字符
 *
 * 每一次都拿滑动窗口右边界的下一个字符和set中元素比较是否重复
 * 循环不定式：[i, j]为不重复子字符串
 *
 *
 */
public class LongestSubstringWithoutDuplication {
    public static void main(String[] args) {
        String  s = "pwwkew";
        System.out.println(longestSubstringWithoutDuplication(s));

    }

    public static int longestSubstringWithoutDuplication(String str) {

        if (str == null || str.length() <= 0) {
            return 0;
        }
        int result = 0; // 最大长度
        int i = 0; // 滑动窗口左边界
        int j = 0; // 滑动窗口右边界
        int n = str.length();
        Set<Character> sets = new HashSet<>();
        while (j < n) {
            // 与set中字符不相同则加入set 统计
            if (!sets.contains(str.charAt(j))) {
                sets.add(str.charAt(j++));
                result = Math.max(result, j - i); // 统计长度取更大值
            } else {
                sets.remove(str.charAt(i++));
            }
        }
        return result;
    }

}
