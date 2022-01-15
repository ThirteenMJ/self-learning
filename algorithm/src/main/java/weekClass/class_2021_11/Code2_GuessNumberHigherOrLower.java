package weekClass.class_2021_11;

/**
 *
 *
 * @author: thirteenmj
 * @date: 2022-01-09 20:44
 */
public class Code2_GuessNumberHigherOrLower {

    /**
     * 正确的数字，在 1～n 之间
     * 每次猜错，花费就是你猜的数字
     * 返回：永远最倒霉的情况下，也能赢的胜利，所需要的最小钱数
     */
    public static int minGold(int n) {
        return zuo(1, n);
    }

    /**
     * 目前锁定了正确的数字在 l～r 范围上，除了这个范围都不可能了！
     * 返回，永远最倒霉的情况下，猜中这个数字，所需要的最小钱数
     *
     * @param l
     * @param r
     * @return
     */
    public static int zuo(int l, int r) {
        if (l == r) {
            return 0;
        }

        if (l == r - 1) {
            return l;
        }

        // l - r 不止两个数
        int p1 = l + zuo(l + 1, r);
        int p2 = r + zuo(l, r -1);

        int min = Math.min(p1, p2);

        for (int i = l + 1; i < r; i++) {
            // i 猜的数字，每一个都试试
            int left = zuo(l, r - 1);
            int right = zuo(i + 1, r);
            int cur = i + Math.max(left, right);

            min = Math.min(min, cur);
        }

        return min;

    }

    /**
     * 暴力递归
     */
    public static int minGold2(int n) {
        int[][] dp = new int[n + 1][n + 1];

        // 因为初始化都是0，所以 dp 的对角线，不用填了
        for (int i = 1; i < n; i++) {
            dp[i][i + 1] = i;
        }

        for (int l =  n - 2; l >= 1; l--) {
            for (int r = l + 2; r <= n; r++) {
                int min = Math.min(l + dp[l + 1][r], r + dp[l][r - 1]);

                for (int i = l + 1; i < r; i++) {
                    min = Math.min(min, i + Math.max(dp[l][i - 1], dp[i + 1][r]));
                }

                dp[l][r] = min;


            }
        }
        return dp[1][n];
    }



}
