package beginClass.class04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 利用单链表实现队列和栈
 *
 * @author: thirteenmj
 * @date: 2022-04-24 16:01
 */
public class Code02_LinkedListToQueueAndStack {

    public static class Node<T> {
        T value;
        Node next;

        public Node() {
        }

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 利用单链表结构实现的队列
     *
     * @param <T>
     */
    public static class MyQueue<T> {

        public Node<T> head;
        public Node<T> tail;
        public int size = 0;

        public MyQueue() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        /**
         * 判断是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 获取队列的大小
         *
         * @return
         */
        public int size() {
            return size;
        }

        /**
         * 将队列中放入一个值
         *
         * @param value
         */
        public void offer(T value) {
            if (null == value) {
                return;
            }

            Node<T> node = new Node(value);

            if (tail == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
            size++;
        }

        /**
         * 弹出最上方的值
         *
         * @return
         */
        public T poll() {
            if (head == null) {
                return null;
            }

            T ans = null;

            if (head != null) {
                ans = head.value;
                head = head.next;
            }

            if (head == null) {
                tail = null;
            }
            size--;

            return ans;
        }

        /**
         * 查看最上方的值
         *
         * @return
         */
        public T peek() {
            if (head == null) {
                return null;
            }

            T ans = head.value;

            return ans;
        }
    }

    /**
     * 测试自己实现的队列是否正确
     *
     * @param testTime
     * @param maxValue
     */
    public static void testQueue(int testTime, int maxValue) {
        System.out.println("开始验证队列是否正确");
        MyQueue<Integer> myQueue = new MyQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < testTime; i++) {
            if (myQueue.isEmpty() != queue.isEmpty()) {
                System.out.println("判断是否为空出错！");
                System.out.println("myQueue:" + myQueue.isEmpty());
                System.out.println("queue:" + queue.isEmpty());
                break;
            }

            if (myQueue.size() != queue.size()) {
                System.out.println("大小不一致");
                System.out.println("myQueue:" + myQueue.size());
                System.out.println("queue:" + queue.size());
                break;
            }

            double time = Math.random();

            if (time < 0.33) {
                Integer ans = (int) (Math.random() * maxValue);
                myQueue.offer(ans);
                queue.add(ans);
            } else if (time < 0.66) {
                if (!myQueue.isEmpty() && !queue.isEmpty()) {
                    Integer myQueuePoll = myQueue.poll();
                    Integer queuePoll = queue.poll();
                    if (!myQueuePoll.equals(queuePoll)) {
                        System.out.println("弹出内容不一致！");
                        System.out.println("myQueue:" + myQueuePoll);
                        System.out.println("queue:" + queuePoll);
                        break;
                    }
                }
            } else {
                if (!myQueue.isEmpty() && !queue.isEmpty()) {
                    if (!myQueue.peek().equals(queue.peek())) {
                        System.out.println("查询内容不一致！");
                        System.out.println("myQueue:" + myQueue.peek());
                        System.out.println("queue:" + queue.peek());
                        break;
                    }
                }
            }

        }
        System.out.println("验证队列是否正确结束");
    }

    public static void main(String[] args) {
        int maxValue = 100;
        int maxLength = 100000;
        int testTime = 10000;
        testQueue(testTime, maxValue);
    }
}
