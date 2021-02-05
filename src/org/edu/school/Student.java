package org.edu.school;

public class Student {
    private HumanInfo humanInfo;
    private int level;

    public Student(HumanInfo humanInfo, int level) {
        this.humanInfo = humanInfo;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Student{" +
                "humanInfo=" + humanInfo +
                ", level=" + level +
                '}';
    }

//  ------------------------------------------------------------------------

    public String getStudentInfo() {
        return this.humanInfo.getShortName() + " | Cеместр: " + this.level;
    }

    public void nextYear() {
        this.humanInfo.nextYear();
        this.level++;
    }

//  ------------------------------------------------------------------------

    public HumanInfo getHumanInfo() {
        return humanInfo;
    }

    public void setHumanInfo(HumanInfo humanInfo) {
        this.humanInfo = humanInfo;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
