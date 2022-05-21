package systemClass.class07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
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
}
