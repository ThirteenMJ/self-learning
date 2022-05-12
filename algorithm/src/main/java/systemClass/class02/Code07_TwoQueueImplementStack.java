package systemClass.class02;

import java.util.LinkedList;
import java.util.Queue;

/**
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
    }
}
