package beginClass.class04;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 利用双链表实现双端队列
 *
 * @author: thirteenmj
 * @date: 2022-04-25 09:35
 */
public class Code03_DoubleLinkedListToDeque {

    public static class DoubleNode<V> {
        public DoubleNode pre = null;
        public DoubleNode next = null;
        public V value = null;

        public DoubleNode() {
        }

        public DoubleNode(V value) {
            this.value = value;
        }
    }

    public static class MyDeque<V> {
        public DoubleNode<V> head;
        public DoubleNode<V> tail;
        public int size;

        public MyDeque() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public int size() {
            return this.size;
        }

        public void pushHead(V value) {
            if (null == value) {
                return;
            }
            DoubleNode<V> node = new DoubleNode<>(value);

            if (head != null) {
                node.next = head;
                head.pre = node;
            } else {
                tail = node;
            }
            head = node;
            size++;
        }

        public void pushTail(V value) {
            if (null == value) {
                return;
            }
            DoubleNode<V> node = new DoubleNode<>(value);
            if (tail != null) {
                tail.next = node;
                node.pre = tail;
            } else {
                head = node;
            }
            tail = node;
            size++;
        }

        public V pollHead() {
            V ans = null;
            if (head == null) {
                return ans;
            }
            ans = head.value;
            size--;

            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.pre = null;
            }

            return ans;
        }

        public V pollTail() {
            V ans = null;
            if (head == null) {
                return ans;
            }
            ans = tail.value;
            size--;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.pre;
                tail.next = null;
            }

            return ans;
        }

        public V peekHead() {
            return null == head ? null : head.value;
        }

        public V peekTail() {
            return null == tail ? null : tail.value;
        }

    }

    public static void testMyDeQueue(int testTime, int maxValue) {
        MyDeque<Integer> myDeque = new MyDeque<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < testTime; i++) {
            if (myDeque.isEmpty() != deque.isEmpty()) {
                System.out.println("判断是否为空出错！");
                System.out.println("myQueue:" + myDeque.isEmpty());
                System.out.println("queue:" + deque.isEmpty());
                break;
            }
            if (myDeque.size() != deque.size()) {
                System.out.println("大小不一致");
                System.out.println("myDeque:" + myDeque.size());
                System.out.println("deque:" + deque.size());
                break;
            }
            double time = Math.random();
            double time2 = Math.random();
            if (time < 0.33) {
                Integer ans = (int) (Math.random() * maxValue);
                if (time2 < 0.5) {
                    myDeque.pushHead(ans);
                    deque.addFirst(ans);
                } else {
                    myDeque.pushTail(ans);
                    deque.addLast(ans);
                }
            } else if (time < 0.66) {
                if (!myDeque.isEmpty()) {
                    Integer myDequePoll = null;
                    Integer dequePoll = null;
                    if (time2 < 0.5) {
                        myDequePoll = myDeque.pollHead();
                        dequePoll = deque.pollFirst();
                    } else {
                        myDequePoll = myDeque.pollTail();
                        dequePoll = deque.pollLast();
                    }
                    if (!myDequePoll.equals(dequePoll)) {
                        System.out.println("弹出内容不一致！");
                        System.out.println("myQueue:" + myDequePoll);
                        System.out.println("queue:" + dequePoll);
                        break;
                    }
                }
            } else {
                if (!myDeque.isEmpty()) {
                    if (time2 < 0.5) {
                        if (!myDeque.peekHead().equals(deque.peekFirst())) {
                            System.out.println("查询头部内容不一致！");
                            System.out.println("myQueue:" + myDeque.peekHead());
                            System.out.println("queue:" + deque.peekFirst());
                            break;
                        }
                    } else {
                        if (!myDeque.peekTail().equals(deque.peekLast())) {
                            System.out.println("查询尾部内容不一致！");
                            System.out.println("myQueue:" + myDeque.peekTail());
                            System.out.println("queue:" + deque.peekLast());
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int testTime = 1000000;
        int maxValue = 10000;
        testMyDeQueue(testTime, maxValue);
    }
}
