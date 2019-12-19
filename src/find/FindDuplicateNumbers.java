package find;

/**
 * @author cj
 * @date 2019/11/21
 * 找出数组中重复的数字
 *  在一个长度为n的数组里的所有数字都在0~n-1的范围内。
 *  数组中的某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 *  请找出数组中任意一个重复数字。
 *  例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是重复数字2或者3。
 * 这里要特别注意~返回任意重复的一个，赋值duplication[0]
 *  Return value: true if the input is valid,
 *  and there are some duplications in the array number
 *  otherwise false
 *
 */
public class FindDuplicateNumbers {
    public static void main(String[] args) {
        // 测试用例
        int[] b = {2,3,1,0,2,5,3};
        int[] a = {1,2,0};
        int[] c = {7};
        int[] dup = new int[1];
        System.out.println(duplicate2(b, b.length, dup));
        System.out.println(dup[0]);
    }

    /**
     * 哈希表: 数字为0 ~ n - 1正好对应长度n的数组，下标(key)为当前数字，值为计算当前数字出现的次数
     * @param numbers
     * @param length
     * @param duplication
     * @return
     * 时间复杂度O(n) 空间复杂度O(n)
     */
    public static boolean duplicate(int numbers[],int length,int[] duplication) {
       int[] hash = new int[length];
       for (int i = 0; i < length; i++) {
           if (hash[numbers[i]] == 0) {
               hash[numbers[i]] = 1;
           } else {
               duplication[0] = numbers[i];
               return true;
           }
       }
       return false;
    }

    /**
     * 由于当前数字对应下标，想办法将当前数字交换到当前数组中对应下标的位置
     * @param n
     * @param length
     * @param dup
     * @return true 重复
     * 时间复杂度O(n) 空间复杂度O(1)
     */
    public static boolean duplicate2(int n[], int length, int dup[]) {
        if (n == null || n.length <= 1) {
            return false;
        }
        for (int i = 0; i < n.length; i++) {
            while (n[i] != i) {
                if (n[i] == n[n[i]]) {
                    dup[0] = n[i];
                    return true;
                }
                int temp = n[i];
                n[i] = n[temp];
                n[temp] = temp;
            }
        }
        return false;
    }
}
