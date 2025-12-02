//package FunctionInterface;
//
//public class voidMain {
//    public static void main(String[] args) {
////        voidAccept<Integer> voidAccept= t->{
////            System.out.println(t);
////        };
////        voidAccept.accept(2);
//
//
////        voidAccept<Integer,String> voidAcc= num-> "Hi"+num;
////        System.out.println(voidAcc.accept(1));
//
//
////        voidAccept<Integer> voidAcc=num->num%2==0;
////        System.out.println(voidAcc.accept(1));
//
////        voidAccept<Integer,Integer> voidAcc= (a,b)->a*b;
////        System.out.println(voidAcc.accept(10,27));
//
//        voidAccept<Integer,Integer,String> voidAcc=(a,b)->(a+b+"HI");
//        System.out.println(voidAcc.accept(2,4));
//
//        voidAccept<Integer,Integer,Integer> voidAcc2=(a,b)->(a+b);
//        System.out.println(voidAcc2.accept(2,4));
//    }
//
//}

package FunctionInterface;

public class voidMain {
    public static void main(String[] args) {

        // ----------------------------------------------------------------------
        // 1) Consumer-like: takes T and prints it (NO return)
        // ----------------------------------------------------------------------
        // voidAccept<Integer> voidAcc = t -> {
        //     System.out.println("Consumer: received = " + t);
        // };
        // voidAcc.accept(2);

        // ----------------------------------------------------------------------
        // 2) Function-like: takes T and RETURNS String
        // ----------------------------------------------------------------------
        // voidAccept<Integer, String> voidAcc = num -> "Hi " + num;
        // System.out.println(voidAcc.accept(1));

        // ----------------------------------------------------------------------
        // 3) Predicate-like: takes T and returns boolean
        // ----------------------------------------------------------------------
        // voidAccept<Integer> voidAcc = num -> num % 2 == 0;
        // System.out.println("Is even? " + voidAcc.accept(1));

        // ----------------------------------------------------------------------
        // 4) BiFunction-like: takes (T, R) returns W
        // ----------------------------------------------------------------------
        voidAccept<Integer, Integer, String> voidAcc = (a, b) -> (a + b + " HI");

        System.out.println("BiFunction-like result: " + voidAcc.accept(2, 4));
        // Output → "6 HI"

        // Another example returning Integer
        voidAccept<Integer, Integer, Integer> voidAcc2 = (a, b) -> (a + b);
        System.out.println("BiFunction sum: " + voidAcc2.accept(2, 4));
        // Output → 6
    }
}

