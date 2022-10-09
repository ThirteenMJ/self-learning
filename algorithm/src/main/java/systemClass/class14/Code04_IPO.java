package systemClass.class14;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: thirteenmj
 * @date: 2022-10-09 12:17
 */
public class Code04_IPO {

    /**
     *
     * @param K 最多K个项目
     * @param W W是初始资金
     * @param Profits 收入数组
     * @param Capital 支出数组，Profits[] Capital[] 一定等长
     * @return 返回最终最大的资金
     */
    public static int findMaximizedCapital(int K, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Program> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Program> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());

        for (int i = 0; i < Profits.length; i++) {
            minCostQ.add(new Program(Profits[i], Capital[i]));
        }

        for (int i = 0; i < K; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return W;
            }
            W += maxProfitQ.poll().p;
        }
        return W;
    }

    public static class MaxProfitComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o2.p - o1.p;
        }
    }

    public static class MinCostComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.c - o2.c;
        }
    }


    public static class Program {
        /**
         * 收入
         */
        public int p;

        /**
         * 支出
         */
        public int c;

        public Program() {
        }

        public Program(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }
}
