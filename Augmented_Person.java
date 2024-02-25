import java.util.Objects;
import java.lang.IllegalArgumentException;
public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String address;
    private String telephone;

    public Person(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
        this.age = age;
        this.address = null;
        this.telephone = null;
    }

    public Person(String name, int age, String address) {
        this(name, age);
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void changeName(String newName) {
        name = newName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void changeAddress(String newAddress) {
        address = newAddress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void changeTelephone(String newPhoneNumber) {
        if (newPhoneNumber == null || newPhoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Telephone number cannot be empty or null");
        }
        for (char c : newPhoneNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Telephone number must contain only digits");
            }
        }
        telephone = newPhoneNumber;

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        return age == other.age && Objects.equals(name, other.name);
    }

    @Override
    public int compareTo(Person o) {
        int nameCompare = this.name.compareTo(o.name);
        if (nameCompare != 0) {
            return nameCompare;
        }
        return Integer.compare(this.age, o.age);
    }
}

