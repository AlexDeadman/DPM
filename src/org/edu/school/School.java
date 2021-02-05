package org.edu.school;

import java.util.Arrays;

public class School {
    private int index;
    private String title;
    private Teacher[] teacher;
    private Student[] student;

    public School(int index, String title, Teacher[] teacher, Student[] student) {
        this.index = index;
        this.title = title;
        this.teacher = teacher;
        this.student = student;
    }

    public School(int index, String title) {
        this(index, title, new Teacher[2], new Student[2]);
    }

    @Override
    public String toString() {
        return "School{" +
                "index=" + index +
                ", title='" + title + '\'' +
                ", teacher=" + Arrays.toString(teacher) +
                ", student=" + Arrays.toString(student) +
                '}';
    }


//  ------------------------------------------------------------------------

    public void work(int teacher_id, int student_id ) {
        System.out.println(
                this.teacher[teacher_id].getHumanInfo().getShortName() +
                " учит " + this.student[student_id].getHumanInfo().getShortName() +
                " на предмете " + this.teacher[teacher_id].getSubject().getTitle()
        );
    }

    public void nextYear() {
        for (Student curStudent : student) {
            curStudent.nextYear();
        }
        for (Teacher curTeacher : teacher) {
            curTeacher.nextYear();
        }

        System.out.println("\n Произошло 1 сентября");
    }

//  ------------------------------------------------------------------------


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Teacher[] getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher[] teacher) {
        this.teacher = teacher;
    }

    public Student[] getStudent() {
        return student;
    }

    public void setStudent(Student[] student) {
        this.student = student;
    }
}
