package binary;

public class ShiftDemo {

    public static void main(String[] args) {

        int x = 5;        // 0000 0101
        int neg = -5;     // 2's complement number

        // -----------------------------
        // 1. LEFT SHIFT <<
        // -----------------------------
        System.out.println("x << 1 = " + (x << 1));  
        // 0000 0101 << 1 = 0000 1010 (5 * 2 = 10)

        System.out.println("neg << 1 = " + (neg << 1));
        // Negative left shift keeps sign bit; shifts left normally.


        // -----------------------------
        // 2. RIGHT SHIFT >> (SIGNED)
        // -----------------------------
        System.out.println("x >> 1 = " + (x >> 1));  
        // 0000 0101 >> 1 = 0000 0010 (divide by 2)

        System.out.println("neg >> 1 = " + (neg >> 1));
        // Arithmetic right shift: sign bit (1) copies
        // Example: 1111 1011 >> 1 = 1111 1101


        // -----------------------------
        // 3. UNSIGNED RIGHT SHIFT >>> 
        // -----------------------------
        System.out.println("x >>> 1 = " + (x >>> 1));
        // Same as >> for positive numbers (fills with 0)

        System.out.println("neg >>> 1 = " + (neg >>> 1));
        // Logical shift: fills with ZERO
        // Very large positive number (because MSB becomes 0)


        // -----------------------------
        // 4. Show 2's Complement
        // -----------------------------
        System.out.println("\n2's complement of x = " + (~x + 1));
        // ~x flips bits; +1 gives -x

        System.out.println("Binary of x:    " + Integer.toBinaryString(x));
        System.out.println("Binary of -x:   " + Integer.toBinaryString(-x));


        // -----------------------------
        // 5. Binary print helper
        // -----------------------------
        printBinary("x", x);
        printBinary("neg", neg);
        printBinary("neg >> 1", neg >> 1);
        printBinary("neg >>> 1", neg >>> 1);
    }

    static void printBinary(String label, int n) {
        System.out.println(label + ": " +
                String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0'));
    }
}
