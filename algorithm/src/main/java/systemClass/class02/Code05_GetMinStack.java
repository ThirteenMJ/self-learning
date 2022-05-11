package systemClass.class02;

import java.util.Stack;

/**
 * 每次弹出的都是栈内的最小值
 * 欠：对数器未写
 *
 * @author: thirteenmj
 * @date: 2022-05-11 15:25
 */
public class Code05_GetMinStack {

    public static class MyStack1 {
        public Stack<Integer> stackData;
        public Stack<Integer> stackMin;

        public MyStack1() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int value) {
            if (stackMin.isEmpty()) {
                stackMin.push(value);
            } else {
                Integer peek = stackMin.peek();
                if (value < peek) {
                    stackMin.push(value);
                }
            }
            stackData.push(value);
        }

        public Integer pop() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            Integer pop = this.stackData.pop();
            if (pop.equals(this.getMin())) {
                this.stackMin.pop();
            }
            return pop;
        }

        public Integer getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            return this.stackMin.peek();
        }
    }

    public static class MyStack2 {
        public Stack<Integer> stackData;
        public Stack<Integer> stackMin;

        public MyStack2() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
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
        }

        public Integer pop() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            this.stackData.pop();
            return this.stackMin.pop();
        }

        public Integer getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            return this.stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());

        System.out.println("=============");

        MyStack2 stack2 = new MyStack2();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }
}
