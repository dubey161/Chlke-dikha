package AnnotationBolte;

public class RepeatableDemo {
    public static void main(String[] args) {
        Category[] categories = Eagle.class.getAnnotationsByType(Category.class);

        for (Category c : categories) {
            System.out.println(c.value());
        }
    }
}
