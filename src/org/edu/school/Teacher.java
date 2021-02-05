package org.edu.school;

import java.awt.print.Book;
import java.util.Arrays;

public class Teacher {
    private HumanInfo humanInfo;
    private Subject subject;
    private int exp;
    private final String[] warnings = new String[3];
    private boolean banned = false;

    public Teacher(HumanInfo humanInfo, Subject subject, int exp) {
        this.humanInfo = humanInfo;
        this.subject = subject;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "humanInfo=" + humanInfo +
                ", subject='" + subject + '\'' +
                ", exp=" + exp +
                ", warnings=" + Arrays.toString(warnings) +
                '}';
    }

//  -------------------------------------------------------------------

    public void addWarn(String warn) {
        for (int i = 0; i < warnings.length; i++) {
            if (warnings[i] == null) {
                warnings[i] = warn;
                return;
            }
        }
        System.out.println(this.humanInfo.getFullName() + " banned");
        this.banned = true;
    }

    public boolean hasWarn(String warn) {
        for (String s : warnings) {
            if (warn.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public void delWarn(String warn) {
        for (int i = 0; i < warnings.length; i++) {
            if (warn.equals(warnings[i])) {
                warnings[i] = null;
            }
        }
    }

    public String getTeacherInfo() {
        return this.humanInfo.getShortName() + " | " + this.subject.getTitle() +
                " | стаж " + this.exp + " | banned: " + this.banned;
    }

    public void nextYear() {
        this.humanInfo.nextYear();
        this.exp++;
    }

//  -------------------------------------------------------------------

    public HumanInfo getHumanInfo() {
        return humanInfo;
    }

    public void setHumanInfo(HumanInfo humanInfo) {
        this.humanInfo = humanInfo;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }
}