
package baitapver3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student extends Person {

    private float gpa;
    private String major;

    public Student(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void updateStudent(String newName, float newGpa, String newMajor) {
        this.fullName = newName;
        this.gpa = newGpa;
        this.major = newMajor;
    }

    @Override
    public void displayInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Student ID: " + id + ", Name: " + fullName + ", Date of Birth: " + sdf.format(dateOfBirth)
                + ", GPA: " + gpa + ", Major: " + major);
    }
}
