package systemClass.class13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: thirteenmj
 * @date: 2022-09-23 16:32
 */
public class Code04_MaxHappy {

    public static class Employee {
        public int happy;
        public List<Employee> nexts;

        public Employee(int h) {
            happy = h;
            nexts = new ArrayList<>();
        }
    }

    public static class Info {
        int no;
        int yes;

        public Info() {
        }

        public Info(int no, int yes) {
            this.no = no;
            this.yes = yes;
        }
    }

    public static int maxHappy2(Employee head) {
        Info info = process(head);
        return Math.max(info.no, info.yes);
    }

    private static Info process(Employee head) {
        if (null == head) {
            return new Info(0, 0);
        }
        int no = 0;
        int yes = head.happy;

        for (Employee next : head.nexts) {
            Info nextInfo = process(next);
            yes += nextInfo.no;
            no += Math.max(nextInfo.no, nextInfo.yes);
        }

        return new Info(no, yes);
    }
}
