package GenericWildCard;

import java.util.List;

class Util {
    public static <T> void printTwice(T value) {
        System.out.println(value);
        System.out.println(value);
    }
    public static <T> void printList(List<T> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }
    public static void printLists(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static double sumList(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
    }

    public static <T> boolean compare(List<T> a, List<T> b) {
        return a.equals(b);
    }

    /*
    /BUT — IMPORTANT:

This method does NOT guarantee that both lists are of the same type.

You could also do:

compare(List.of("a"), List.of(1));   // Also allowed ❗
     */

    static boolean compares(List<?> a, List<?> b) {
        return a.equals(b);
    }

    public static void mix(List<?> a, List<?> b) {
        System.out.println(a);
        System.out.println(b);
    }

    public static <T> void copyFirst(List<T> dest, List<? extends T> src) {
        // copy first element from src to dest
        if (!src.isEmpty()) {
            dest.add(src.get(0));
        }
    }








}
