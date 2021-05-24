package ru.gb.task_1;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public Person(String firstName, String lastName, String middleName, String country, String address, String phone, int age, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.country = country;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person:" + '\n' +
                "firstName=" + firstName + '\n' +
                "lastName=" + lastName + '\n' +
                "middleName=" + middleName + '\n' +
                "country=" + country + '\n' +
                "address=" + address + '\n' +
                "phone=" + phone + '\n' +
                "age=" + age + '\n' +
                "gender=" + gender;
    }
}
