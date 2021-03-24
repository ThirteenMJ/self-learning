package nz2003.bLambda;

/**
 * @author thirteenmj
 * Date: 2021/3/24 22:59
 */
public class Lambda2 {

    private static class Person {
        String name;
        int age;
        public Person() {
            System.out.println("Person类的无参构造方法执行了");
        }


        public Person(String name) {
            System.out.println("Person类的有参构造方法执行了");
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
            System.out.println("Person类的两个参数构造方法执行了");
        }
    }

    @FunctionalInterface
    private interface GetPersonWithNoneParameter{
        Person get();
    }

    @FunctionalInterface
    private interface GetPersonWithSingleParameter{
        Person get(String name);
    }

    @FunctionalInterface
    private interface GetPersonWithMultipleParameter{
        Person get(String name, int age);
    }

    public static void main(String[] args) {
        //1、使用lambda表达式，实现GetPersonWithNoneParameter接口
        GetPersonWithNoneParameter getPerson = Person::new;

        //2、使用lambda表达式，实现GetPersonWithSingleParameter接口
        GetPersonWithSingleParameter getPerson2 = Person::new;

        //3、使用lambda表达式，实现GetPersonWithMultipleParameter接口
        GetPersonWithMultipleParameter getPerson3 = Person::new;

        Person person = getPerson.get();
        getPerson2.get("");
        getPerson3.get("", 1);
    }
}
