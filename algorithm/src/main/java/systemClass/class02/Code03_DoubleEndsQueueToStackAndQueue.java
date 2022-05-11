package systemClass.class02;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: thirteenmj
 * @date: 2022-05-06 22:17
 */
public class Code03_DoubleEndsQueueToStackAndQueue {

    public static class Node<V> {
        public Node next;
        public Node pre;
        public V val;

        public Node() {
        }

        public Node(V val) {
            this.val = val;
            next = null;
            pre = null;
        }
    }

    public static class DoubleEndsQueue<V> {
        public Node<V> head;
        public Node<V> tail;

        public DoubleEndsQueue() {
            head = null;
            tail = null;
        }

        public DoubleEndsQueue(Node<V> head, Node<V> tail) {
            this.head = head;
            this.tail = tail;
        }

        public void addFromHead(V value) {
            Node<V> node = new Node<>(value);

            if (null == head) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.pre = node;
                head = node;
            }
        }

        public void addFromTail(V value) {
            Node<V> node = new Node<>(value);
            if (null == tail) {
                tail = node;
                head = node;
            } else {
                tail.next = node;
                node.pre = tail;
                tail = node;
            }
        }

        public V popFromHead() {
            if (null == head) {
                return null;
            }

            Node<V> node = head;

            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.pre = null;
            }

            return node.val;
        }

        public V popFromBottom() {
            if (null == tail) {
                return null;
            }

            Node<V> node = tail;

            if (tail == head) {
                head = null;
                tail = null;
            } else {
                tail = tail.pre;
                tail.next = null;
            }
            return node.val;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    public static class MyStack<V> {
        public DoubleEndsQueue<V> queue;

        public MyStack() {
            queue = new DoubleEndsQueue<>();
        }

        public void push(V value) {
            queue.addFromTail(value);
        }

        public V pop() {
            return queue.popFromBottom();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static class MyQueue<V> {
        public DoubleEndsQueue<V> queue;

        public MyQueue() {
            queue = new DoubleEndsQueue<>();
        }

        public void push(V value) {
            queue.addFromTail(value);
        }

        public V pop() {
            return queue.popFromHead();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        int maxValue = 100000;
        int testTime = 100000;
        int maxLength = 100;

        for (int i = 0; i < testTime; i++) {

            MyQueue<Integer> myQueue = new MyQueue<>();
            MyStack<Integer> myStack = new MyStack<>();
            Queue<Integer> queue = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();

            for (int j = 0; j < maxLength; j++) {

                int nums = ((int) (Math.random() * maxValue) - (int) (Math.random() * maxValue));
                if (myStack.isEmpty() && stack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (myStack.isEmpty() ^ stack.isEmpty()) {
                        System.out.println("栈是否为空结果不一致");
                        break;
                    }

                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {
                        Integer myStackPop = myStack.pop();
                        Integer stackPop = stack.pop();
                        if (!myStackPop.equals(stackPop)) {
                            System.out.println("栈出错了");
                            System.out.println("自己实现的栈结果：" + myStackPop);
                            System.out.println("系统实现的栈结果：" + stackPop);
                            break;
                        }
                    }
                }

                int numq = ((int) (Math.random() * maxValue) - (int) (Math.random() * maxValue));

                if (myQueue.isEmpty() && queue.isEmpty()) {
                    myQueue.push(numq);
                    queue.add(numq);
                } else {
                    if (myQueue.isEmpty() ^ queue.isEmpty()) {
                        System.out.println("队列否为空结果不一致");
                        break;
                    }
                    if (Math.random() < 0.5) {
                        myQueue.push(nums);
                        queue.add(nums);
                    } else {
                        Integer myQueuePop = myQueue.pop();
                        Integer stackPoll = queue.poll();
                        if (!myQueuePop.equals(stackPoll)) {
                            System.out.println("队列出错了");
                            System.out.println("自己实现的队列结果：" + myQueuePop);
                            System.out.println("系统实现的队列结果：" + stackPoll);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("success");
    }
}
