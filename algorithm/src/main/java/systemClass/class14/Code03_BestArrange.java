package systemClass.class14;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给一组宣讲会的时间，找出能安排场数最多的数量
 * @author: thirteenmj
 * @date: 2022-10-08 23:04
 */
public class Code03_BestArrange {
    public static class Program {
        public int start;
        public int end;

        public Program() {
        }

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int bestArrange2(Program[] programs) {
        Arrays.sort(programs, new ProgramComparator());
        int timeLine = 0;
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (timeLine <= programs[i].start) {
                result++;
                timeLine = programs[i].end;
            }
        }
        return result;

    }

    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }
}
