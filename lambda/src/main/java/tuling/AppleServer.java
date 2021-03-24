package tuling;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author thirteenmj
 * Date: 2021/3/24 22:06
 */
public class AppleServer {

    private List<Apple> appleStore = new ArrayList<>();

    //获取 red 红颜色的苹果
     public List<Apple> getRedApple() {
         List<Apple> result = new ArrayList<>();
         for (Apple apple : appleStore) {
             if ("red".equals(apple.getColor())) {
                 result.add(apple);
             }
         }
         return result;
     }

    //获取 green 绿颜色的苹果
    public List<Apple> getGreenApple() {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : appleStore) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    //根据颜色来获取
    public List<Apple> getAppleByColor(String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : appleStore) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    //获取 green 绿颜色的苹果
    public List<Apple> getAppleByPredicate(Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : appleStore) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AppleServer server = new AppleServer();

        server.getAppleByPredicate(a -> "red".equals(a.getColor()) && a.getWeight() > 500);
        server.getAppleByColor("red");
        server.getRedApple();
    }
}
