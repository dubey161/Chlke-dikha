//package lombok;
//
//public class LombokMain {
//
//    public static void main(String[] args) {
//
//        // Builder Pattern
//        TestPojo pojo = TestPojo.builder()
//                .name("Ved")
//                .address("India")
//                .age(25)
//                .build();
//
//        System.out.println(pojo);
//
//        // Immutable object
//        User user = new User("Amit", 30, "amit@gmail.com");
//        System.out.println(user);
//
//        // Equals & HashCode
//        Employee e1 = new Employee();
//        e1.setId(1);
//        e1.setName("John");
//        e1.setDepartment("IT");
//
//        Employee e2 = new Employee();
//        e2.setId(1);
//        e2.setName("John");
//        e2.setDepartment("HR");
//
//        System.out.println(e1.equals(e2)); // TRUE
//
//        // ToString
//        Student s = new Student();
//        System.out.println(s);
//    }
//}
