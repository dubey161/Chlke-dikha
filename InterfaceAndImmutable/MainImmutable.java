package InterfaceAndImmutable;

public class MainImmutable {
    public static void main(String[] args) {
        String[] hobbies = {"Reading", "Swimming"};
        ImmutablePerson person = new ImmutablePerson(25, hobbies);

        System.out.println(person);

        // Try modifying original array
        hobbies[0] = "Hacking";
        System.out.println("After modifying original array: " + person);

        // Try modifying returned array
        String[] personHobbies = person.getHobbies();
        personHobbies[1] = "Dancing";
        System.out.println("After modifying returned array: " + person);
    }
}
