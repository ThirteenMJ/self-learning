package systemClass.class02;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 每次弹出的都是栈内的最小值
 *
 * @author: thirteenmj
 * @date: 2022-05-11 15:25
 */
public class Code05_GetMinStack {

    /**
     * 当添加一个数时，这个值比最小栈的栈顶值小时，才放入最小值
     */
    public static class MyStack1 {
        public Stack<Integer> stackData;
        public Stack<Integer> stackMin;
        public int size;

        public MyStack1() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
            this.size = 0;
        }

        public void push(int value) {
            if (stackMin.isEmpty()) {
                stackMin.push(value);
            } else {
                Integer peek = stackMin.peek();
                if (value <= peek) {
                    stackMin.push(value);
                }
            }
            stackData.push(value);
            size++;
        }

        public Integer pop() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            Integer pop = this.stackData.pop();
            Integer min = this.getMin();
            if (pop.equals(min)) {
                this.stackMin.pop();
            }
            size--;
            return min;
        }

        public Integer getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            return this.stackMin.peek();
        }

        public int size() {
            return this.size;
        }
    }

    /**
     * 每当添加一个数时，最小栈都会存入一个对应的最小值
     */
    public static class MyStack2 {
        public Stack<Integer> stackData;
        public Stack<Integer> stackMin;
        public int size;

        public MyStack2() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
            this.size = 0;
        }

        public void push(int value) {
            if (stackMin.isEmpty()) {
                stackMin.push(value);
            } else if (value < this.getMin()){
                stackMin.push(value);
            } else {
                Integer peek = stackMin.peek();
                stackMin.push(peek);
            }
            stackData.push(value);
            size++;
        }

        public Integer pop() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            this.stackData.pop();
            size--;
            return this.stackMin.pop();
        }

        public Integer getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            return this.stackMin.peek();
        }

        public Integer size() {
            return this.size;
        }
    }

    public static void main(String[] args) {
//        MyStack1 stack1 = new MyStack1();
//        stack1.push(3);
//        System.out.println(stack1.getMin());
//        stack1.push(4);
//        System.out.println(stack1.getMin());
//        stack1.push(1);
//        System.out.println(stack1.getMin());
//        System.out.println(stack1.pop());
//        System.out.println(stack1.getMin());
//
//        System.out.println("=============");
//
//        MyStack2 stack2 = new MyStack2();
//        stack2.push(3);
//        System.out.println(stack2.getMin());
//        stack2.push(4);
//        System.out.println(stack2.getMin());
//        stack2.push(1);
//        System.out.println(stack2.getMin());
//        System.out.println(stack2.pop());
//        System.out.println(stack2.getMin());
//        System.out.println("======================");

        int maxValue = 10;
        int testTime = 10;
        for (int i = 0; i < testTime; i++) {
            int operateTime = (int) (Math.random() * testTime);
            MyStack1 myStack1 = new MyStack1();
            MyStack2 myStack2 = new MyStack2();
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int j = 0; j < operateTime; j++) {
                if (myStack1.size != myStack2.size || myStack1.size != queue.size()) {
                    System.out.println("数量对不上！");
                    System.out.println("myStack1:" + myStack1.size());
                    System.out.println("myStack2:" + myStack2.size());
                    System.out.println("queue:" + queue.size());
                    return;
                }
                double time = Math.random();
                if (time < 0.33) {
                    int value = (int) (Math.random() * maxValue);
                    myStack1.push(value);
                    myStack2.push(value);
                    queue.add(value);
                } else if (time < 0.66) {
                    if (myStack1.size() > 0) {
                        int value1 = myStack1.pop();
                        int value2 = myStack2.pop();
                        int value3 = queue.poll();
                        if (value1 != value2 || value1 != value3) {
                            System.out.println("弹出结果不对！");
                            System.out.println("myStack1:" + value1);
                            System.out.println("myStack2:" + value2);
                            System.out.println("queue:" + value3);
                            return;
                        }
                    }
                } else {
                    if (myStack1.size() > 0) {
                        int value1 = myStack1.getMin();
                        int value2 = myStack2.getMin();
                        int value3 = queue.peek();
                        if (value1 != value2 || value1 != value3) {
                            System.out.println("查看结果不对！");
                            System.out.println("myStack1:" + value1);
                            System.out.println("myStack2:" + value2);
                            System.out.println("queue:" + value3);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("success!");
    }
}
