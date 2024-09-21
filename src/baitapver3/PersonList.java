
package baitapver3;

import java.util.ArrayList;
import java.util.Date;

class PersonList {

    private ArrayList<Person> personList;

    public PersonList() {
        personList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        personList.add(student);
    }

    public void addTeacher(Teacher teacher) {
        personList.add(teacher);
    }

    public void updatePerson(String id, String newName, Object... updateParams) {
        Person person = findPersonById(id);
        if (person != null) {
            if (person instanceof Student) {
                Student student = (Student) person;
                student.setFullName(newName);
                if (updateParams.length == 2 && updateParams[0] instanceof Float && updateParams[1] instanceof String) {
                    student.setGpa((Float) updateParams[0]);
                    student.setMajor((String) updateParams[1]);
                }
                System.out.println("Student updated.");
            } else if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                teacher.setFullName(newName);
                if (updateParams.length == 3 && updateParams[0] instanceof Date && updateParams[1] instanceof String && updateParams[2] instanceof String) {
                    teacher.setDateOfBirth((Date) updateParams[0]);
                    teacher.setDepartment((String) updateParams[1]);
                    teacher.setTeachingSubject((String) updateParams[2]);
                }
                System.out.println("Teacher updated.");
            }
        } else {
            System.out.println("Person ID not found.");
        }
    }

    public void deletePersonById(String id) {
        Person person = findPersonById(id);
        if (person != null) {
            personList.remove(person);
            System.out.println("Person deleted.");
        } else {
            System.out.println("Person not found.");
        }
    }

    public Person findPersonById(String id) {
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    public void displayEveryone() {
        for (Person person : personList) {
            person.displayInfo();
        }
    }
    public Person findPersonByID(String id) {
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }
    
    public Student findTopStudent() {
        Student topStudent = null;
        for (Person person : personList) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (topStudent == null || student.getGpa() > topStudent.getGpa()) {
                    topStudent = student;
                }
            }
        }
        return topStudent;
    }

    public Teacher findTeacherByDepartment(String department) {
        for (Person person : personList) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getDepartment().equals(department)) {
                    return teacher;
                }
            }
        }
        return null;
    }
}
