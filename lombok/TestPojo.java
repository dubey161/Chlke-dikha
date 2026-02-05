//package lombok;
//
//public class TestPojo {
//
//    private String name;
//    private String address;
//    private int age;
//    private static String COMPANY = "Concept & Coding";
//
//    public TestPojo() {}
//
//    public TestPojo(String name, String address, int age) {
//        if (address == null) {
//            throw new NullPointerException("address is marked non-null but is null");
//        }
//        this.name = name;
//        this.address = address;
//        this.age = age;
//    }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public String getAddress() { return address; }
//    public void setAddress(String address) {
//        if (address == null) {
//            throw new NullPointerException("address is marked non-null but is null");
//        }
//        this.address = address;
//    }
//
//    public int getAge() { return age; }
//    public void setAge(int age) { this.age = age; }
//
//    @Override
//    public String toString() {
//        return "TestPojo(name=" + name + ", address=" + address + ", age=" + age + ")";
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof TestPojo)) return false;
//        TestPojo that = (TestPojo) o;
//        return age == that.age &&
//               java.util.Objects.equals(name, that.name) &&
//               java.util.Objects.equals(address, that.address);
//    }
//
//    @Override
//    public int hashCode() {
//        return java.util.Objects.hash(name, address, age);
//    }
//}
