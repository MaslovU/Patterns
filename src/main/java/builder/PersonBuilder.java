package builder;

public class PersonBuilder {

    protected String name = "";
    protected String surname = "";
    protected int age = 0;
    protected String city = "";
    private int count = 0;

    public PersonBuilder setName(String name) {
        this.name = name;
        count++;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        count++;
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
        if (count >= 2) {
            return new Person(this);
        } else {
            throw new IllegalStateException();
        }
    }
}
