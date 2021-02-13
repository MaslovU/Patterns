package builder;

public class PersonBuilder {

    protected String name = "";
    protected String surname = "";
    protected int age = 0;
    protected String city = "";

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age > 0) {
            this.age = age;
            return this;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        if (name.equals("") || surname.equals("")) {
            throw new IllegalStateException();
        } else if (age > 0 && city.equals("")) {
            return new Person(name, surname, age);
        } else if (age == 0 && city.equals("")) {
            return new Person(name, surname);
        } else if (age == 0 && !city.isEmpty()) {
            return new Person(name, surname, city);
        } else {
            return new Person(name, surname, age, city);
        }
    }
}
