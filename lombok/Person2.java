package lombok;

import lombok.Value;

/*

| Feature                 | `@Value`                                                           |
| ----------------------- | ------------------------------------------------------------------ |
| Mutability              | Immutable (fields cannot change)                                   |
| Getter                  | Yes, for all fields                                                |
| Setter                  | ❌ No setters                                                       |
| `toString()`            | Yes                                                                |
| `equals()`/`hashCode()` | Yes, all fields                                                    |
| Constructor             | All-args constructor (all fields required)                         |
| Immutability            | ✅ Immutable                                                        |
| Typical usage           | Value objects, DTOs, objects passed around safely without mutation |


Mutability:

@Data → mutable (fields can change)

@Value → immutable (fields final, no setters)

Class finality:

@Data → class can be extended

@Value → class is final

Constructor behavior:

@Data → required args constructor for final and @NonNull

@Value → all-args constructor for all fields

Setter presence:

@Data → setters for non-final fields

@Value → no setters

Use case:

@Data → when object needs to change state (mutable)

@Value → when object should never change (immutable, safer for multithreading)


Short direct answer (first)
✔ @Value

All fields become private final

All-args constructor is generated

Constructor contains ALL fields

No setters

✔ @Data

Fields are NOT final by default

Required-args constructor is generated

Constructor contains only final and @NonNull fields

Setters are generated

So yes 👇

In @Value, all fields are final → all fields go into constructor
In @Data, only final + @NonNull fields go into constructor
 */

@Value
public class Person2 {
    String name;
    String address;
    int age;
}
