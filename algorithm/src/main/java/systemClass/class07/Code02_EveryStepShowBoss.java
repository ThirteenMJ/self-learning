package systemClass.class07;

import java.util.Comparator;
import java.util.HashMap;

/**
 * 消费 -> 抽奖问题
 *
 * @author: thirteenmj
 * @date: 2022-05-19 22:18
 */
public class Code02_EveryStepShowBoss {

    public static class Customer {
        public int id;
        public int bug;
        public int enterTime;

        public Customer(int id, int bug, int enterTime) {
            this.id = id;
            this.bug = bug;
            this.enterTime = enterTime;
        }
    }

    /**
     * 候选区比较器
     *
     * 如果购物数不同，谁大谁放前面，如果相同，谁先进入谁先放前面
     */
    public static class CandidateComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
            return o2.bug != o1.bug ? (o2.bug - o1.bug) : o2.enterTime - o1.enterTime;
        }
    }

    /**
     * 获奖区比较器
     *
     * 如果购物数不同，谁小谁放在最前面，如果相同，谁先进入谁放在前面
     */
    public static class DaddyComparator implements Comparator<Customer> {

        @Override
        public int compare(Customer o1, Customer o2) {
            return o1.bug != o2.bug ? (o1.bug -o2.bug) : (o2.enterTime - o1.enterTime);
        }
    }

    public static class WhoIsYourDaddy {
        private HashMap<Integer, Customer> customer;
        private HeapGreater daddyHeap;
        private HeapGreater caddyHeap;
        private final int daddyLimit;

        public WhoIsYourDaddy(int limit) {
            this.daddyLimit = limit;
            this.customer = new HashMap<>();
            this.daddyHeap = new HeapGreater(new DaddyComparator());
            this.caddyHeap = new HeapGreater(new CandidateComparator());
        }
    }
}
