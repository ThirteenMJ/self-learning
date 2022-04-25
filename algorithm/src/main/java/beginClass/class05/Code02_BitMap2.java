package beginClass.class05;

import java.util.HashSet;

/**
 * 实现位图
 *
 * @author: thirteenmj
 * @date: 2022-04-25 21:40
 */
public class Code02_BitMap2 {

    public static class BitMap {
        public long[] bits;

        public BitMap(int max) {
            this.bits = new long[(max + 64) >> 6];
        }

        public void add(int value) {
            bits[value >> 6] |= (1L << (value & 63));
        }

        public void delete(int value) {
            bits[value >> 6] &= ~(1L << (value & 63));
        }

        public boolean containsKey(int value) {
            return (bits[value >> 6] & (1L << (value & 63))) != 0;
        }
    }

    public static void main(String[] args) {
        int maxValue = 100000;
        int testTime = 10000000;

        BitMap bitMap = new BitMap(maxValue);
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < testTime; i++) {
            int num = (int) (Math.random() * (maxValue + 1));
            double time = Math.random();
            if (time < 0.33) {
                bitMap.add(num);
                hashSet.add(num);
            } else if (time < 0.66) {
                bitMap.delete(num);
                hashSet.remove(num);
            } else {
                boolean result1 = bitMap.containsKey(num);
                boolean result2 = hashSet.contains(num);
                if (result1 != result2) {
                    System.out.println("是否包含不一致！");
                    System.out.println("bitMap：" + result1);
                    System.out.println("hashSet：" + result2);
                    break;
                }

            }
        }
        System.out.println("测试结束！");
    }
}
