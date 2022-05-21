package systemClass.class07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 还没写完
 *
 * @author: thirteenmj
 * @date: 2022-05-21 17:56
 */
public class HeapGreater<V> {

    private ArrayList<V> heap;
    private HashMap<V, Integer> indexMap;
    private int heapSize;
    private Comparator<? super V> comparator;

    public HeapGreater(Comparator<V> comparator) {
        this.comparator = comparator;
        this.heap = new ArrayList<>();
        this.indexMap = new HashMap<>();
        this.heapSize = 0;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public int size() {
        return this.heapSize;
    }

    public boolean contains(V object) {
        return indexMap.containsKey(object);
    }

    public V peek() {
        return heap.get(0);
    }

    public void push(V object) {
        heap.add(object);
        indexMap.put(object, heapSize);
        heapInsert(heapSize++);
    }

    public V pop() {
        V object = heap.get(0);
        swap(0, heapSize - 1);
        heap.remove(--heapSize);
        indexMap.remove(object);
        heapify(0);
        return object;
    }

    private void heapify(int index) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int large = left + 1 < heapSize && comparator.compare(heap.get(left + 1), heap.get(left)) < 0 ? left + 1 : left;
            large = comparator.compare(heap.get(large), heap.get(left)) < 0 ? large : left;
            if (large == left) {
                break;
            }

            swap(index, large);
            index = large;
            left = 2 * large + 1;
        }

    }

    private void heapInsert(int index) {
        while (comparator.compare(heap.get(index), heap.get((index - 1) / 2 )) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void swap(int index, int target) {
        V object1 = heap.get(index);
        V object2 = heap.get(target);
        heap.set(index, object2);
        heap.set(target, object1);
        indexMap.put(object1,target);
        indexMap.put(object2,index);
    }
}
