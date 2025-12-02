//package FunctionInterface;

//public interface voidAccept<T> {
////    void accept(T t);
//
//}

//public interface voidAccept<T,R> {
//    R accept(T t);
//}


//public interface voidAccept<T> {
//    boolean accept(T t);
//}

//public interface voidAccept<T,R> {
//    R accept(T t,R r);
//}


//public interface voidAccept<T,R,W> {
//    W accept(T t,R r);
//}


package FunctionInterface;

/**
 * CUSTOM FUNCTIONAL INTERFACE EXAMPLES
 *
 * Below are different variations of the same interface.
 *
 * Only ONE interface definition can be active at a time,
 * so the others are fully commented out to avoid errors.
 */

// ----------------------------------------------------------------------
// 1) Takes T, returns void  (Consumer-like)
// ----------------------------------------------------------------------
// public interface voidAccept<T> {
//     /**
//      * Accepts a value of type T and performs some action (NO return).
//      */
//     void accept(T t);
// }

// ----------------------------------------------------------------------
// 2) Takes T, returns R (Function-like)
// ----------------------------------------------------------------------
// public interface voidAccept<T, R> {
//     /**
//      * Accepts an input of type T and RETURNS a value of type R.
//      */
//     R accept(T t);
// }

// ----------------------------------------------------------------------
// 3) Takes T, returns boolean (Predicate-like)
// ----------------------------------------------------------------------
// public interface voidAccept<T> {
//     /**
//      * Evaluates a condition on T and returns boolean.
//      */
//     boolean accept(T t);
// }

// ----------------------------------------------------------------------
// 4) Takes (T, R) returns W (BiFunction-like)
// ----------------------------------------------------------------------
// public interface voidAccept<T, R, W> {
//     /**
//      * Accepts two inputs (T, R) and RETURNS a value W.
//      */
//     W accept(T t, R r);
// }

// ----------------------------------------------------------------------
// FINAL ACTIVE INTERFACE (uncommented)
// This one takes (T, R) and returns W.
// This matches your last example.
// ----------------------------------------------------------------------
public interface voidAccept<T, R, W> {
    /**
     * Accepts two inputs: T and R
     * Returns a result of type W
     */
    W accept(T t, R r);
}
