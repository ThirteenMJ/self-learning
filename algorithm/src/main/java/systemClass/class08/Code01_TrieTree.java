package systemClass.class08;


import java.util.HashMap;

/**
 * 代码有问题
 *
 * @author: thirteenmj
 * @date: 2022-05-21 17:39
 */
public class Code01_TrieTree {

    public static class Node1 {
        public int pass;
        public int end;
        public Node1[] nexts;

        public Node1() {
            this.pass = 0;
            this.end = 0;
            this.nexts = new Node1[26];
        }
    }

    public static class trie1 {
        private Node1 root;

        public trie1() {
            this.root = new Node1();
        }

        public void insert(String word) {
            if (null == word) {
                return;
            }

            char[] charArray = word.toCharArray();

            Node1 node1 = root;
            node1.pass++;
            for (char c : charArray) {
                int index = (int) (c - 'a');
                if (null == node1.nexts[index]) {
                    node1.nexts[index] = new Node1();
                }
                node1 = node1.nexts[index];
                node1.pass++;
            }

            node1.end++;
        }

        /**
         * 判断该字符是否加入过
         *
         * @param word
         * @return
         */
        public int search(String word) {
            if (null == word) {
                return 0;
            }
            char[] charArray = word.toCharArray();
            Node1 node1 = root;
            for (char c : charArray) {
                int index = c - 'a';
                if (null == node1.nexts[index]) {
                    return 0;
                }
                node1 = node1.nexts[index];
            }
            return node1.end;
        }

        public int prefixNumber(String word) {
            if (null == word) {
                return 0;
            }
            char[] charArray = word.toCharArray();
            Node1 node1 = root;
            for (char c : charArray) {
                int index = c - 'a';
                if (null == node1.nexts[index]) {
                    return 0;
                }
                node1 = node1.nexts[index];
            }
            return node1.pass;
        }

        public void delete(String word) {
            if (search(word) > 0) {
                char[] charArray = word.toCharArray();
                Node1 node1 = root;
                node1.pass--;
                for (char c : charArray) {
                    int index = c - 'a';
                    if (--node1.nexts[index].pass == 0) {
                        node1.nexts[index] = null;
                        return;
                    }
                    node1 = node1.nexts[index];
                }
                node1.end--;
            }
        }
    }

    public static class Node2 {
        public int pass;
        public int end;
        public HashMap<Integer, Node2> nexts;

        public Node2() {
            this.pass = 0;
            this.end = 0;
            this.nexts = new HashMap<>();
        }
    }

    public static class trie2 {
        private Node2 root;

        public trie2() {
            this.root = new Node2();
        }

        public void insert(String word) {
            if (null == word) {
                return;
            }
            char[] charArray = word.toCharArray();
            Node2 node2 = root;
            node2.pass++;
            for (char c : charArray) {
                int index = c;
                if (!node2.nexts.containsKey(index)) {
                    node2.nexts.put(index, new Node2());
                }
                node2 = node2.nexts.get(index);
                node2.pass++;
            }
            node2.end++;
        }

        public int search(String word) {
            if (null == word) {
                return 0;
            }
            char[] charArray = word.toCharArray();
            Node2 node2 = root;
            for (char c : charArray) {
                int index = c;
                if (!node2.nexts.containsKey(index)) {
                    return 0;
                }
                node2 = node2.nexts.get(index);
            }
            return node2.end;
        }

        public int prefixNumber(String word) {
            if (null == word) {
                return 0;
            }
            char[] charArray = word.toCharArray();
            Node2 node2 = root;
            for (char c : charArray) {
                int index = c;
                if (!node2.nexts.containsKey(index)) {
                    return 0;
                }
                node2 = node2.nexts.get(index);
            }
            return node2.pass;
        }

        public void delete(String word) {
            if (search(word) > 0) {
                char[] charArray = word.toCharArray();
                Node2 node2 = root;
                node2.pass--;
                for (char c : charArray) {
                    int index = c;
                    if (--node2.nexts.get(index).pass == 0) {
                        node2.nexts.remove(index);
                        return;
                    }
                    node2 = node2.nexts.get(index);
                }
                node2.end--;
            }
        }
    }

    public static class Test {
        private HashMap<String, Integer> map;

        public Test() {
            this.map = new HashMap<>();
        }

        public void insert(String word) {
            if (null == word) {
                return;
            }

            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        public void delete(String word) {
            if (null == word) {
                return;
            }
            if (map.containsKey(word)) {
                if (map.get(word) == 1) {
                    map.remove(word);
                } else {
                    map.put(word, map.get(word) - 1);
                }
            }
        }

        public int search(String word) {
            if (map.containsKey(word)) {
                return map.get(word);
            } else {
                return 0;
            }
        }

        public int prefixNumber(String word) {
            int ans = 0;
            for (String key : map.keySet()) {
                if (key.startsWith(word)) {
                    ans += map.get(key);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int testTime = 10000;
        int maxLength = 10;
        int strLen = 10;
        for (int i = 0; i < testTime; i++) {
            String[] strArr = generateRandomString(maxLength, strLen);
            trie1 trie1 = new trie1();
            trie2 trie2 = new trie2();
            Test test = new Test();
            for (int j = 0; j < strArr.length; j++) {
                double time = Math.random();
                if (time < 0.25) {
                    trie1.insert(strArr[j]);
                    trie2.insert(strArr[j]);
                    test.insert(strArr[j]);
                } else if (time < 0.5){
                    trie1.delete(strArr[j]);
                    trie2.delete(strArr[j]);
                    test.delete(strArr[j]);
                } else if (time < 0.75) {
                    int search1 = trie1.search(strArr[j]);
                    int search2 = trie2.search(strArr[j]);
                    int search3 = test.search(strArr[j]);
                    if (search1 != search2 || search1 != search3) {
                        System.out.println("查询出现次数出错了");
                        printStringArray(strArr);
                        System.out.println("查询目标：" + strArr[j]);
                        System.out.println("trie1：" + search1);
                        System.out.println("trie2：" + search2);
                        System.out.println("test：" + search3);
                        return;
                    }
                } else {
                    int search1 = trie1.prefixNumber(strArr[j]);
                    int search2 = trie2.prefixNumber(strArr[j]);
                    int search3 = test.prefixNumber(strArr[j]);
                    if (search1 != search2 || search1 != search3) {
                        System.out.println("查询前缀次数出错了");
                        printStringArray(strArr);
                        System.out.println("查询目标：" + strArr[j]);
                        System.out.println("trie1：" + search1);
                        System.out.println("trie2：" + search2);
                        System.out.println("test：" + search3);
                        return;
                    }
                }
            }
        }
        System.out.println("success!");
    }

    private static void printStringArray(String[] arr) {
        System.out.print("数组：");
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static String[] generateRandomString(int arrMaxLength, int strMaxLength) {
        int arrLength = (int) (Math.random() * arrMaxLength);
        String[] strArr = new String[arrLength];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = generateString(strMaxLength);
        }
        return strArr;
    }

    private static String generateString(int strMaxLength) {
        char[] chars = new char[(int) (strMaxLength * Math.random())];
        for (int i = 0; i < chars.length; i++) {
            int value = (int) (Math.random() * 10);
            chars[i] =(char) (97 + value);
        }
        return String.valueOf(chars);
    }
}
