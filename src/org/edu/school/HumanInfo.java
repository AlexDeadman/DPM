package org.edu.school;

public class HumanInfo {
    private String firstname;
    private String surname;
    private String patronymic;
    private boolean gender;
    private int age;

    public HumanInfo(String firstname, String surname, String patronymic, boolean gender, int age) {
        this.firstname = firstname;
        this.surname = surname;
        this.patronymic = patronymic;
        this.gender = gender;
        this.age = age;
    }

    public HumanInfo(String firstname, String surname, boolean gender, int age) {
        this(firstname, surname, null, gender, age);
    }

    @Override
    public String toString() {
        return "HumanInfo{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }

//  ------------------------------------------------------------------------

    public String getFullName() {
        return surname + " " + firstname + (patronymic == null ? "" : (" " + patronymic));
    }

    public String getShortName() {
        return surname + " " + firstname.charAt(0) + "." + (patronymic == null ? "" : (" " + patronymic.charAt(0) + "."));
    }

    public void nextYear() {
        this.age++;
    }

//  ------------------------------------------------------------------------

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
