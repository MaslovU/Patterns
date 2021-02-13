package builder;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(PersonBuilder personBuilder) {
        name = personBuilder.name;
        surname = personBuilder.surname;
        age = personBuilder.age;
        city = personBuilder.city;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.getSurname())
                .setAge(3)
                .setCity(this.getCity());
    }

    public boolean hasAge() {
        return this.age > 0;
    }


    public boolean hasCity() {
        return !this.city.equals("");
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String setCity(String city) {
        this.city = city;
        return this.city;
    }

    public void happyBirthday() {
        this.age = age + 1;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
