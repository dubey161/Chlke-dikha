package EnumClass;
import java.util.*;

public class EnumnMain {
    public static void main(String[] args) {
        System.out.println(Day.SATURDAY.getType());
        int x = 10, y = 5;
        for (Operation op : Operation.values()) {
            System.out.print(op + ": " + op.apply(x, y) + " => ");
            op.hello();
        }
        EnumnInterfacej enumk=EnumnInterfacej.THURSDAY;
        System.out.println(enumk.toLowerCase());
        System.out.println(enumk.ordinalXfive());
    }

}
