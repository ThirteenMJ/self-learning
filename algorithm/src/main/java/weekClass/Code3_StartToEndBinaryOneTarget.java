package weekClass;

/**
 * @author: thirteenmj
 * @date: 2022-01-11 22:20
 */
public class Code3_StartToEndBinaryOneTarget {

    // 暴力验证
    // 为了验证
    public static long nums1(long start, long end, int target) {
        if (start < 0 || end < 0 || start > end || target < 0) {
            return -1;
        }

        long ans = 0;

        for (long i = start; i <= end; i++) {
            if (bitOne(i) == target) {
                ans++;
            }
        }

        return ans;
    }

    public static int bitOne(long num) {
        int bits = 0;

        for (int i = 63; i >= 0; i--) {
            if ((num & (1L << i)) != 0) {
                bits++;
            }
        }

        return bits;
    }

}
