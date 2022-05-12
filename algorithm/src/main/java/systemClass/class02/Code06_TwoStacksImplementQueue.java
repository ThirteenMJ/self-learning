package systemClass.class02;

import java.util.Stack;

/**
 * @author: thirteenmj
 * @date: 2022-05-11 15:48
 */
public class Code06_TwoStacksImplementQueue {

    public static class MyQueue<V> {
        public Stack<V> stackPush;
        public Stack<V> stackPop;

        public MyQueue() {
            this.stackPop = new Stack<>();
            this.stackPush = new Stack<>();
        }

        public void add(V value) {
            stackPush.push(value);
            pushToPop();
        }

        public V poll() {
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            pushToPop();
            return stackPop.pop();
        }

        public V peek() {
            if (stackPush.isEmpty() && stackPop.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            pushToPop();
            return stackPop.peek();
        }

        private void pushToPop() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> test = new MyQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
}
