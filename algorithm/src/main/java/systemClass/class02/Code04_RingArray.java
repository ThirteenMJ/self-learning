package systemClass.class02;


/**
 * 欠：对数器
 *
 * @author: thirteenmj
 * @date: 2022-05-06 22:16
 */
public class Code04_RingArray {

    public class MyQueue {
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
}
