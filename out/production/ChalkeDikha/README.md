# Chlke-dikha
Java Generics & Wildcards Summary
1. Generic Type Parameter <T>
   Definition:

<T> declares a named type parameter that can be used in:

Method parameters

Return type

Multiple parameters or multiple type parameters

Example:
public static <T> T getFirst(List<T> list) {
return list.get(0);
}

List<Integer> nums = List.of(1, 2);
Integer x = getFirst(nums);  // T = Integer

Key Points:

Type T is known at compile-time.

Preserves type in return type.

Can relate multiple parameters with same type:

public static <T> boolean compare(List<T> a, List<T> b) {
return a.equals(b);  // Both must be same type
}


Works for multiple type parameters:

public static <T, U> void printPairs(List<T> a, List<U> b) { ... }

2. Wildcard ?
   Definition:

? is unknown type.

Can only read elements safely (as Object or upper bound type)

Cannot safely write elements except null

Example:
public static Object getFirst(List<?> list) {
return list.get(0);  // Returns Object
}

Key Points:

Type unknown → compiler cannot assume any type

Return type must be Object (unless you cast manually)

Cannot enforce relationships between multiple wildcard lists

Can accept any subtype with bounds:

List<? extends Number> nums;  // upper bound
List<? super Integer> ints;   // lower bound

3. Differences: <T> vs ?
   Feature	<T>	? Wildcard
   Read elements	✔ T	✔ Object (or U if bounded)
   Return type	✔ preserves type	❌ becomes Object
   Enforce same type for multiple lists	✔ Yes	❌ No
   Add elements	✔ (if list is List<T>)	❌ Only null (except super bounds)
   Upper bound	✔ <T extends Number>	✔ ? extends Number
   Lower bound	❌	✔ ? super Integer
   Multiple parameters	✔ <T, U>	❌ cannot relate types directly
4. Using <T> and ? Together
   Example 1: Copying with bounds (PECS)
   public static <T> void copyFirst(List<T> dest, List<? extends T> src) {
   if (!src.isEmpty()) {
   dest.add(src.get(0));
   }
   }


? extends T = some unknown subtype of T

Can read safely

Can write into dest, but not src

Example 2: Multiple type parameters
public static <T, U> void printPairs(List<T> a, List<? extends U> b) {
for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
System.out.println(a.get(i) + " - " + b.get(i));
}
}


U inferred by compiler

? extends U allows passing subtypes of U

Example: List<String> and List<Object> works, compiler infers U = Object

5. Key Rules
   Wildcard rules (PECS principle)

Producer (? extends T) → safe to read, cannot write

Consumer (? super T) → safe to write, cannot read specific type

Generic <T> rules

Can read/write elements safely

Preserves type in return type

Can enforce type consistency between multiple lists

6. Examples of Type Inference
   Method	Call Example	Result
   <T> T getFirst(List<T> list)	List<Integer> nums	Returns Integer
   Object getFirst(List<?> list)	List<String> names	Returns Object
   <T> boolean compare(List<T> a, List<T> b)	List<String> a, List<Integer> b	❌ Compile error
   printPairs(List<T> a, List<? extends U> b)	List<String>, List<Object>	OK, U = Object
7. Important Notes

List<?> cannot return a generic type T → always returns Object

List<T> preserves type → can return T safely

? super T only works with wildcards → cannot use T super X

Using both <T> and ? together is common for flexibility:

<T> void copy(List<T> dest, List<? extends T> src)

This captures all the discussion we had — from basic T and wildcard usage, return types, upper/lower bounds, to using them together.

If you want, I can also make a one-page visual diagram showing <T> vs ? vs ? extends T vs ? super T, which makes these concepts super easy to memorize.

Do you want me to make that diagram?

You said:
yes
ChatGPT said:

Perfect! Here’s a clear visual diagram / cheat sheet for <T> and wildcards with read/write rules and type relationships.

Java Generics & Wildcards Diagram
+---------------------+
|      List<T>        |   <- Generic type
|  T is known type    |
|  Can read/write T   |
+---------------------+
^
|
| preserves type in return
|
+---------------------+
|  <T> T getFirst(...)|
|  Returns T safely   |
+---------------------+

--------------------------------------------

             +---------------------+
             |     List<?>         |   <- Wildcard
             |  ? = unknown type   |
             |  Can read Object    |
             |  Cannot write       |
             +---------------------+
                       ^
                       |
                       | returns Object
                       |
             +---------------------+
             | Object getFirst(...)|
             +---------------------+

--------------------------------------------

             +---------------------+
             | List<? extends T>   |  <- Upper bound
             | ? = unknown subtype |
             | Can read T safely   |
             | Cannot write T      |
             +---------------------+

             +---------------------+
             | List<? super T>     |  <- Lower bound
             | ? = unknown super  |
             | Can write T safely |
             | Read as Object     |
             +---------------------+

--------------------------------------------

             <T> and ? together
--------------------------------------------
Example:

public static <T> void copyFirst(List<T> dest, List<? extends T> src)

- dest = List<T> -> can write
- src  = List<? extends T> -> can read safely
- Allows subtypes flexibility

PECS Rule (Producer / Consumer)
Rule	Example	Read/Write
Producer	List<? extends T>	Read T safely, cannot write
Consumer	List<? super T>	Write T safely, read as Object
Summary Table
Feature	<T>	?	? extends T	? super T
Known type?	✔ Yes	❌ No	❌ No	❌ No
Return type preserved?	✔ Yes	❌ Object	❌ Object	❌ Object
Can read safely?	✔ T	✔ Object	✔ T	✔ Object
Can write safely?	✔ T	❌	❌	✔ T
Enforce same type in multiple lists?	✔ Yes	❌	❌	❌