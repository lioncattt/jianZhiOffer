package array.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cj
 * @date 2020/2/10
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * abaccdeff
 */
public class FirstNotRepeatingChar {
    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar("adaccdff"));
    }

    /**
     * 空间复杂度O(n) 时间复杂度O(n)
     * @param str
     * @return
     */
    public static int firstNotRepeatingChar(String str) {
        if (str == null || str.length() <= 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, count);
            } else {
                map.put(c, ++count);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
