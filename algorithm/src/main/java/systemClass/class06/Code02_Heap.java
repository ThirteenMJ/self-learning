package systemClass.class06;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 大根堆
 * 欠：对数器
 *
 * @author: thirteenmj
 * @date: 2022-05-17 22:55
 */
public class Code02_Heap {

    public static class MyMaxHeap {
        private int[] heap;
        private final int limit;
        private int heapSize;

        public MyMaxHeap(int limit) {
            this.heap = new int[limit];
            this.limit = limit;
            this.heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return this.heapSize == this.limit;
        }

        public void push(int value) {
            if (isFull()) {
                throw new RuntimeException("heap is full");
            }
            this.heap[this.heapSize] = value;
            heapInsert(heap, heapSize++);
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("heap is empty");
            }
            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap,0, heapSize);
            return ans;
        }

        private void heapify(int[] arr, int index, int maxIndex) {
            int left = index * 2 + 1;
            while (left < maxIndex) {
                int large = left + 1 < maxIndex && arr[left + 1] > arr[left]  ? left + 1: left;
                int target = arr[index] < arr[large] ? large : index;

                if (target == index) {
                    break;
                }

                swap(arr, target, index);
                index = target;
                left = 2 * large + 1;
            }
        }

        private void heapInsert(int[] arr, int index) {
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) >> 1);
                index = (index - 1) / 2;
            }
        }

        private void swap(int[] arr, int index, int target) {
            int temp = arr[index];
            arr[index] = arr[target];
            arr[target] = temp;
        }
    }

    public static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        int maxValue = 10000;
        int maxLength = 10000;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int limit = (int) (Math.random() * maxLength);
            MyMaxHeap myMaxHeap = new MyMaxHeap(limit);
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new MyComparator());
            for (int j = 0; j < limit; j++) {
                if (myMaxHeap.isEmpty() ^ queue.isEmpty()) {
                    System.out.println("两个的是否空余不一致");
                    return;
                }
                double time = Math.random();
                if (time < 0.5) {
                    if (!myMaxHeap.isFull()) {
                        int value = ((int) (Math.random() * maxValue) - (int) (Math.random() * maxValue));
                        queue.add(value);
                        myMaxHeap.push(value);
                    }
                } else {
                    if (!myMaxHeap.isEmpty()) {
                        int myMaxHeapPop = myMaxHeap.pop();
                        int queuePop = queue.poll();
                        if (myMaxHeapPop != queuePop) {
                            System.out.println("两个弹出的内容不一致！");
                            System.out.println("myAns:" + myMaxHeapPop);
                            System.out.println("testAns:" + queuePop);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("success!");
    }
}
