package InterfaceAndImmutable;

import java.util.Arrays;

public final class ImmutablePerson {
    private final int age;
    private final String[] hobbies;

    public ImmutablePerson(int age, String[] hobbies) {
        this.age = age;
        this.hobbies = hobbies != null ? Arrays.copyOf(hobbies, hobbies.length) : null;
    }

    public int getAge() {
        return age;
    }

    public String[] getHobbies() {
        return hobbies != null ? Arrays.copyOf(hobbies, hobbies.length) : null;
    }

    @Override
    public String toString() {
        return "ImmutablePerson{age=" + age + ", hobbies=" + Arrays.toString(hobbies) + "}";
    }
}
