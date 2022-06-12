package systemClass.class02;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 环形数组实现队列
 *
 * @author: thirteenmj
 * @date: 2022-05-06 22:16
 */
public class Code04_RingArray {

    public static class MyQueue {
        public int[] arr;
        public int size;
        public int head;
        public int tail;
        public int limit;

        public MyQueue(int limit) {
            this.limit = limit;
            this.head = 0;
            this.tail = 0;
            this.size = 0;
            this.arr = new int[limit];
        }

        public int size() {
            return this.size;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列已满，不能再加了");
            }
            size++;
            arr[tail] = value;
            tail = nextIndex(tail);
        }

        public int pop() {
            if (size == 0){
                throw new RuntimeException("队列空了，不能再拿了");
            }
            size--;
            int value = arr[head];
            head = nextIndex(head);
            return value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private int nextIndex(int tail) {
            return tail < limit - 1 ? tail + 1 : 0;
        }
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int maxValue = 10000;
        for (int i = 0; i < testTime; i++) {
            Queue<Integer> queue = new LinkedList<>();
            int limit = (int) ((Math.random() * testTime) + 1);
            MyQueue myQueue = new MyQueue(limit);
            int operateTime = (int) (Math.random() * maxValue);
            for (int j = 0; j < operateTime; j++) {
                if (queue.isEmpty() != myQueue.isEmpty()) {
                    System.out.println("判断是否为空结果不一致！");
                    System.out.println("queue:" + queue.isEmpty());
                    System.out.println("myQueue:" + myQueue.isEmpty());
                    return;
                }
                if (queue.size() != myQueue.size) {
                    System.out.println("数量结果不一致！");
                    System.out.println("queue:" + queue.size());
                    System.out.println("myQueue:" + myQueue.size());
                    return;
                }
                int time = (int) Math.random();
                if (time < 0.5) {
                    if (myQueue.size() < limit) {
                        int value = (int) (Math.random() * maxValue);
                        myQueue.push(value);
                        queue.add(value);
                    }
                } else {
                    if (myQueue.size > 0) {
                        int value1 = myQueue.pop();
                        int value2 = queue.poll();
                        if (value1 != value2) {
                            System.out.println("弹出结果不一致");
                            System.out.println("queue:" + value1);
                            System.out.println("myQueue:" + value2);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("success");
    }
}
