package app;

import org.edu.school.*;
import hyper.cringe.pc.*;
import stat.cringe.StatBook;

public class Main {

    public static void schoolStuff() {
        Teacher firstTeacher = new Teacher(
                new HumanInfo(
                        "Виктория",
                        "Романова",
                        "Александровна",
                        true,
                        26
                ),
                new Subject(
                        "Литература",
                        1,
                        2,
                        true
                ),
                68
        );

        Teacher secondTeacher = new Teacher(
                new HumanInfo(
                        "Виктор",
                        "Романов",
                        "Александрович",
                        false,
                        42
                ),
                new Subject(
                        "Физ-ра",
                        1,
                        8,
                        false
                ),
                66
        );

        Student firstStudent = new Student(
                new HumanInfo(
                        "Виталий",
                        "Сизый",
                        "Викторович",
                        false,
                        19
                ),
                6
        );

        Student secondStudent = new Student(
                new HumanInfo(
                        "Алина",
                        "Петрова",
                        "Витальевна",
                        true,
                        17
                ),
                2
        );

        School firstSchool = new School(
                530,
                "ГБОУ",
                new Teacher[]{firstTeacher, secondTeacher},
                new Student[]{firstStudent, secondStudent}
        );

        System.out.println(firstSchool.getTeacher()[0].getTeacherInfo());
        System.out.println(firstSchool.getTeacher()[1].getTeacherInfo() + '\n');
        System.out.println(firstSchool.getStudent()[0].getStudentInfo());
        System.out.println(firstSchool.getStudent()[1].getStudentInfo() + '\n');

        firstSchool.work(0,0);
        firstSchool.work(1,1);
        firstSchool.nextYear();

        System.out.println('\n' + firstSchool.getTeacher()[0].getTeacherInfo());
        System.out.println(firstSchool.getTeacher()[1].getTeacherInfo() + '\n');
        System.out.println(firstSchool.getStudent()[0].getStudentInfo());
        System.out.println(firstSchool.getStudent()[1].getStudentInfo());

        org.edu.school.Book[] coolBooks = new Book[] {
                new Book("Cringe machine", "Cringe Man", 690),
                new Book("Apocalyptic cringe", "Unknown", 420),
                new Book("Epic cringe 2021", "Cringe Man", 228)
        };

        System.out.println("--------------------------------------------------------------------");

        Library coolLibrary = new Library(
                "Best Library in country",
                coolBooks
        );

        System.out.println("Pages quantity: " + coolLibrary.getAllPages() + '\n');

        String bookToFind1 = "Cringe machine";
        String bookToFind2 = "Never cringe";

        System.out.println("Book \"" + bookToFind1 + "\" was found: " + coolLibrary.hasBook(bookToFind1));
        System.out.println("Book \"" + bookToFind2 + "\" was found: " + coolLibrary.hasBook(bookToFind2) + '\n');

        String authorToFind1 = "Cringe Man";
        String authorToFind2 = "Strange Dude";

        coolLibrary.printAuthorBooks(authorToFind1);
        coolLibrary.printAuthorBooks(authorToFind2);

    }

    public static void pcStuff() {
        CPU coolCPU = new CPU(
                "Fufix j17-3000",
                64,
                (float)2.28,
                (float)4.20
        );
        GPU coolGPU = new GPU(
                "FX-RTX 4069",
                (float) 8.00,
                true
        );
        Memory coolMemory1 = new Memory(
                (float)16.00,
                (float)6666
        );
        Memory coolMemory2 = new Memory(
                (float)8.00,
                (float)3222
        );
        PC coolPC = new PC(
                "Hyper Cringe 2008",
                coolCPU,
                coolGPU,
                new Memory[] {
                        coolMemory1,
                        coolMemory2
                }
        );

        PC badPC = coolPC.copy();

        badPC.setCpu(new CPU(
                "Cringe3 2002",
                2,
                (float)1.11,
                (float)1.20)
        );

        badPC.setTitle("Most Cringe PC ever");

        badPC.setGpu(new GPU(
                "Radeocringe 2003",
                (float) 0.512,
                false
            )
        );

        System.out.print(coolPC); System.out.println(coolPC.getRating());
        System.out.print(badPC); System.out.println(badPC.getRating());
    }

    public static void statStuff() {
        StatBook[] statBooks = new StatBook[] {
                new StatBook("Book1", "Author1", 55),
                new StatBook("Book2", "Author2", 66),
                new StatBook("Book3", "Author3", 77)
        };
        for (StatBook currStatBook : statBooks) {
            System.out.println(currStatBook.getId());
        }
    }

    public static void main(String[] args) {
        //schoolStuff();
        //pcStuff();
        statStuff();
    }
}
