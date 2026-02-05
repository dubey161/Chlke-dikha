//package lombok;
//

/*
5️⃣ INTERVIEW SUMMARY (VERY IMPORTANT)
🔥 Why Lombok?

Removes boilerplate

Cleaner code

Less bugs

Faster development

🔥 When NOT to use Lombok?

Public libraries / SDKs

When debugging bytecode-level issues

Overuse of @Data in domain models


@Data
@Builder
@Getter / @Setter
@Value
@EqualsAndHashCode
@ToString
@NonNull


@Data is the most commonly used Lombok annotation for regular mutable POJOs.

What it does automatically:

Getters for all fields (public by default)

Setters for all non-final fields (public by default)

toString() method

equals() and hashCode() using all non-static fields

RequiredArgsConstructor → constructor for final fields and fields annotated with @NonNull




/
 */




//public final class User {
//
//    private final String name;
//    private final int age;
//    private final String email;
//
//    public User(String name, int age, String email) {
//        this.name = name;
//        this.age = age;
//        this.email = email;
//    }
//
//    public String getName() { return name; }
//    public int getAge() { return age; }
//    public String getEmail() { return email; }
//
//    @Override
//    public String toString() {
//        return "User(name=" + name + ", age=" + age + ", email=" + email + ")";
//    }
//
//    @Override
//    public boolean equals(Object o) { ... }
//
//    @Override
//    public int hashCode() { ... }
//}
