package school;

import java.util.ArrayList;

public class School {

    private static School instance = new School();
    private ArrayList<Subject> subjectList = new ArrayList<>();
    private ArrayList<Student> studentList = new ArrayList<>();

    private School(){}

    public static School getInstance(){
        if(instance == null){
            instance = new School();
        }
        return instance;
    }

    public void addSubject(Subject subject){
        subjectList.add(subject);
    }

    public void removeSubject(Subject subject){
        subjectList.remove(subject);
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    public void removeStudent(Student student){
        studentList.remove(student);
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }
}
