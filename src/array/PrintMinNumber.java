package array;

import java.util.Arrays;

/**
 * @author cj
 * @date 2020/2/4
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 *
 * 思路：定义排序规则，重新将数组按该规则排序
 * a, b为数组中的某两个元素
 * 若ab > ba，则b排在a前面
 */
public class PrintMinNumber {

    public static void main(String[] args) {
        int[] a = {3, 32, 321};
        System.out.println(printMinNumber(a));

    }

    public static String PrintMinNumber(int [] numbers) {
        String str = "";
        for (int i=0; i<numbers.length; i++){
            for (int j=i+1; j<numbers.length; j++){
                int a = Integer.valueOf(numbers[i]+""+numbers[j]);
                int b = Integer.valueOf(numbers[j]+""+numbers[i]);
                if (a > b){
                    int t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }

            }
        }
        for (int i = 0; i < numbers.length; i++) {
            str += String.valueOf(numbers[i]);
        }
        return str;
    }

    public static String printMinNumber(int [] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return "";
        }

        String[] str = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, (s1, s2)->(s1 + s2).compareTo(s2 + s1));
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

}
