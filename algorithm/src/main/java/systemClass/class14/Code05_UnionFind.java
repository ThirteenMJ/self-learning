package systemClass.class14;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author: thirteenmj
 * @date: 2022-10-13 17:20
 */
public class Code05_UnionFind {

    public static final class Node<V> {
        V vale;

        public Node() {
        }

        public Node(V vale) {
            this.vale = vale;
        }
    }

    public static class UnionFind<V> {
        public HashMap<V, Node<V>>  nodes;
        public HashMap<Node<V>, Node<V>> parents;
        public HashMap<Node<V>, Integer> sizeMap;

        public UnionFind(List<V> values) {
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMap = new HashMap<>();

            for (V value : values) {
                Node<V> node = new Node<>(value);
                nodes.put(value, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node<V> findFather(Node<V> cur) {
            Stack<Node<V>> path = new Stack<>();
            while (cur != parents.get(cur)) {
                path.add(cur);
                cur = parents.get(cur);
            }
            while (!path.isEmpty()) {
                parents.put(path.pop(), cur);
            }
            return cur;
        }

        public boolean isSameSet(V a, V b) {
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        public void union(V a, V b) {
            Node<V> aNode = findFather(nodes.get(a));
            Node<V> bNode = findFather(nodes.get(b));
            if (aNode != bNode) {
                Integer aMapSize = sizeMap.get(aNode);
                Integer bMapSize = sizeMap.get(bNode);
                Node<V> big = aMapSize >= bMapSize ? aNode : bNode;
                Node<V> small = big == aNode ? bNode : aNode;
                parents.put(small, big);
                sizeMap.put(big, aMapSize + bMapSize);
                sizeMap.remove(small);
            }
        }

        public int sets() {
            return sizeMap.size();
        }
    }

}
