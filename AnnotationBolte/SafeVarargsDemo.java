package AnnotationBolte;

import java.util.List;

public class SafeVarargsDemo {

    @SafeVarargs
    private static void printLists(List<String>... lists) {
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        printLists(List.of("A", "B"), List.of("X", "Y"));
    }
}
