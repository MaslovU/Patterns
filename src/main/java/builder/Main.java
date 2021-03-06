package builder;

import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Anna")
                .setSurname("Petrova")
                .setAge(28)
                .setCity("Ekat")
                .build();

        System.out.println(mom.hasAge());
        System.out.println(mom.hasCity());
        System.out.println(mom.getName());
        System.out.println(mom.getAge());
        System.out.println(mom.getCity());
        mom.happyBirthday();
        System.out.println(mom.getAge());
        Person child = mom.newChildBuilder()
                .setName("Sacha")
                .build();

        System.out.println("This mom " + mom + " has a child, " + child);

        try {
            // Не хватает обяхательных полей
            new PersonBuilder()
                    .setName("Sergey")
                    .setAge(29)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Не хватает обяхательных полей: имени или фамилии");;
        }

        try {
            // Возраст недопустимый
            new PersonBuilder()
                    .setName("Olga")
                    .setSurname("Lak")
                    .setAge(-100)
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Введен недопустимый возраст");
        }
    }
}
