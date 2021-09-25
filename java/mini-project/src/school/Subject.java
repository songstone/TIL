package school;

import java.util.ArrayList;

public class Subject {

    private static int seq = 0;

    private String subjectID;
    private String subjectName;
    private ArrayList<Student> studentList;

    public Subject(String subjectName){
        this.subjectName = subjectName;
        this.subjectID = String.format("%04d",seq);
        studentList = new ArrayList<>();
    }

    public boolean register(Student student){
        studentList.add(student);
        return true;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
}
