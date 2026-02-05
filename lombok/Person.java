package lombok;

import lombok.Data;
import lombok.NonNull;

/*

getName(), setName(String) → yes

getAddress(), setAddress(String) → yes

getAge() → yes, setAge() → ❌ because age is final

equals() and hashCode() → based on name, address, age

Mutable → you can change name and address using setters

| Feature                 | `@Data`                                                   |
| ----------------------- | --------------------------------------------------------- |
| Mutability              | Mutable (fields can change)                               |
| Getter                  | Yes, for all fields                                       |
| Setter                  | Yes, for all non-final fields                             |
| `toString()`            | Yes                                                       |
| `equals()`/`hashCode()` | Yes, all non-static fields                                |
| Constructor             | RequiredArgsConstructor for `final` and `@NonNull` fields |
| Immutability            | ❌ Not immutable                                           |
| Typical usage           | Standard POJOs where values may change                    |


 */

@Data
public class Person {
    private String name;
    @NonNull
    private String address;
    private final int age = 30;
}
