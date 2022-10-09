package systemClass.class14;

/**
 * 给定一个字符串，全部是有 x 和  . 组成，要求在点上放灯，灯可以照亮相邻的两个点，求最少需要多少盏灯才能将其全部照亮
 * @author: thirteenmj
 * @date: 2022-10-09 19:01
 */
public class Code01_Light {

    public static int minLight2(String road) {
        char[] chars = road.toCharArray();
        int i = 0;
        int light = 0;
        while (i < chars.length) {
            if (chars[i] == 'x') {
                i++;
            } else {
                light++;
                if (chars[i + 1] == 'X') {
                    i += 2;
                } else {
                    i += 3;
                }
            }
        }
        return light;
    }
}
