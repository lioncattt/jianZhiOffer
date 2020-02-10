package array.hashtable;

/**
 * @author cj
 * @date 2020/2/10
 * 定义一个函数，输入两个字符串，从第一个字符串中删除在第二个字符串中
 * 出现的所有字符。例如 We are students.   |    aeiou
 * =>W r Stdnts.
 */
public class DeleteAppearChar {
    public static void main(String[] args) {
        String s1 = "We are students";
        String s2 = "aeiou";
        System.out.println(s1.length());
        System.out.println(deleteAppearChar(s1, s2 ));
    }

    public static String deleteAppearChar(String str1, String str2) {

        StringBuilder sb = new StringBuilder();
        int[] arr = new int[256];
        for (int i = 0; i < str2.length(); i++) {
            arr[str2.charAt(i)] = 1;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (arr[str1.charAt(i)] != 1) {
                sb.append(str1.charAt(i));
            }
        }
        return sb.toString();
    }
}
