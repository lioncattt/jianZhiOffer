package array.hashtable;

/**
 * @author cj
 * @date 2020/2/11
 * 删除字符串中所有重复出现的字符
 * 例如输入google => gole
 */
public class DeleteDuplicatedChar {
    public static void main(String[] args) {
        System.out.println(deleteDuplicatedChar("google"));
    }

    public static String deleteDuplicatedChar(String str) {
        boolean memo[] = new boolean[256];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!memo[str.charAt(i)]) {
                memo[str.charAt(i)] = true;
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
