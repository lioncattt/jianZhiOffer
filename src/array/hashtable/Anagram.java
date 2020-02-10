package array.hashtable;

/**
 * @author cj
 * @date 2020/2/11
 * 在英语中，如果两个单词中出现的字母相同，
 *并且每个字符出现的次数也相同，那么这两个单词互为变位词（Anagram）.
 * 例如slient与listen、evil与live等互为变位词。
 * 请完成一个函数，判断输入的两个字符串是不是互为变位词。
 */
public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("evil", "live"));
    }

    public static boolean isAnagram(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() <= 0
            || str2.length() <= 0) {
            return false;
        }
        int[] arr = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            arr[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            arr[str2.charAt(i)]--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
