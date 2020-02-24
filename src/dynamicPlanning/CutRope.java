package dynamicPlanning;

import java.util.Collections;
import java.util.HashSet;

/**
 * @author cj
 * @date 2019/12/31
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CutRope {
    public static void main(String[] args) {
        cutRope(8);
    }

    public static int cutRope(int target) {
        HashSet<Integer> set = new HashSet<>();
        count(0, target, set, 1);
        return Collections.max(set);
    }

    // 暴力递归 找出所有可能组合
    public static void count(int curSum, int target, HashSet<Integer> set, int j) {
        if (curSum > target) {
            return;
        } else if (curSum == target) {
            set.add(j);
        } else {
            for (int i = 1; i < target; i++) {
                count(curSum + i, target, set, j * i);
            }
        }
    }

    //动态规划 空间复杂度O(n) 时间复杂度O(n^2)
    public int cutRope2(int target) {
        // 动态规划

        if (target < 2)
            return 0;
        else if (target == 2)
            return 1;
        else if (target == 3)
            return 2;

        int[] dp = new int[target + 1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        int res=0;//记录最大的
        for (int i = 4; i <= target; i++) {
            for (int j = 1; j <= i/2 ; j++) {
                res=Math.max(res, dp[j]*dp[i-j]);
            }
            dp[i]=res;
        }
        return dp[target];
    }




}
