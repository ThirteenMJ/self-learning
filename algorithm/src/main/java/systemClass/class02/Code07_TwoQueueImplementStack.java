package systemClass.class02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈
 * 欠：对数器
 *
 * @author: thirteenmj
 * @date: 2022-05-11 15:48
 */
public class Code07_TwoQueueImplementStack {

    public static class MyStack<V> {
        public Queue<V> queue;
        public Queue<V> help;

        public MyStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(V value) {
            queue.offer(value);
        }

        public V poll() {
            if (queue.size() == 0) {
                throw new RuntimeException("the stack is empty");
            }

            queueToPoll();

            return queue.poll();
        }

        public V peek() {
            if (queue.size() == 0) {
                throw new RuntimeException("the stack is empty");
            }
            queueToPoll();
            return queue.peek();
        }

        private void queueToPoll() {
            while (queue.size() > 1) {
                V poll = queue.poll();
                help.offer(poll);
            }
            Queue<V> temp = queue;
            queue = help;
            help = temp;
        }
    }
}
