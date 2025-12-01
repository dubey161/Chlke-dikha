package EnumClass;

public class Main {
    public static void main(String[] args) {

        int x = 10, y = 5;

        System.out.println(Operation.ADD.apply(x, y));        // 15
        System.out.println(Operation.SUBTRACT.apply(x, y));   // 5
        System.out.println(Operation.DIVIDE.apply(x, y));   // 50
        Operation.DIVIDE.hello();  // 50

        // Loop all operations
        for (Operation op : Operation.values()) {
            System.out.println(op + " => " + op.apply(x, y));
        }

        for (Planet p : Planet.values()) {
            System.out.println(p + ": mass=" + p.getMass() + ", radius=" + p.getRadius()
                    + ", gravity=" + p.surfaceGravity());
        }

        // Access a specific planet
        System.out.println("Earth's gravity: " + Planet.EARTH.surfaceGravity());
    }

}
