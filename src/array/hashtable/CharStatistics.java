package array.hashtable;

/**
 * @author cj
 * @date 2020/2/11
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * 思路：定义一个字符数组(哈希表)，
 * 当arr[i] = -1:表示未初始化，赋值当前字符下标
 * 当arr[i] = -2：表示再次遇到该字符，
 * arr[i] = index >= 0 表示该下标为只出现1次的字符
 *
 * 查找下标最小的大于等于0数(第一个只出现一次的数)返回对应下标(字符)
 */
public class CharStatistics {

    int[] box;
    int index;

    CharStatistics() {
        box = new int[256];
        for (int i = 0; i < box.length; i++) {
            box[i] = -1;
        }
    }

    //Insert one char from stringstream
    public CharStatistics Insert(char ch)
    {
        if (box[ch] == -1) {
            box[ch] = index;
        } else if (box[ch] >= 0) {
            box[ch] = -2;
        }
        index++;
        return this;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int minIndex = Integer.MAX_VALUE; // 通过该变量找第一次出现的，最小下标即第一次
        char ch = '\0';
        for (int i = 0; i < box.length; i++) {
            if (box[i] >= 0 && box[i] <= minIndex) {
                ch = (char)i;
                minIndex = box[i];
            }
        }
        if (minIndex != Integer.MAX_VALUE) {
            return ch;
        }

        return '#';
    }

    public static void main(String[] args) {
        System.out.println(new CharStatistics().Insert('g')
                .Insert('o').Insert('g')
                .FirstAppearingOnce());
    }
}
