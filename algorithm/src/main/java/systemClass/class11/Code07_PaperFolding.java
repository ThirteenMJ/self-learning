package systemClass.class11;

/**
 * 折纸问题
 * @author: thirteenmj
 * @date: 2022-09-20 13:26
 */
public class Code07_PaperFolding {

    public static void printAllFolds(int N) {
        process(1, N, true);
    }

    /**
     * 函数的功能：中序打印以你想象的节点为头的整棵树
     * @param i 第 i 层
     * @param N 一共 N 层
     * @param down 当节点为凹时，true，当节点为凸时，false
     */
    public static void process(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        process(i + 1, N, true);
        System.out.print(down ? "凹 " : "凸 ");
        process(i + 1, N, false);
    }

    public static void main(String[] args) {
        int N = 3;
        printAllFolds(N);
    }
}
