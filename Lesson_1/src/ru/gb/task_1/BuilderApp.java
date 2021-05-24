package ru.gb.task_1;

public class BuilderApp {

    public static void main(String[] args) {
        createPerson();
    }

    public static void createPerson() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setFirstName("Константин");
        personBuilder.setLastName("Терёхин");
        personBuilder.setMiddleName("Александрович");
        personBuilder.setCountry("Россия");
        personBuilder.setAddress("Казань");
        personBuilder.setPhone("+7980000000");
        personBuilder.setAge(30);
        personBuilder.setGender("Мужской");
        Person person = personBuilder.build();
        System.out.println(person.toString());
    }
}
