package school;

import java.util.ArrayList;
import java.util.Calendar;

public class Student {

    private static int seq = 0;
    private static Calendar calendar = Calendar.getInstance();

    private String studentID;
    private String studentName;
    private Subject major;
    private ArrayList<Score> scoreList;

    public Student(String studentName, Subject major){
        this.studentID = String.format(calendar.get(Calendar.YEAR)+"%04d",++seq);
        this.studentName = studentName;
        this.major = major;
        this.scoreList = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Subject getMajor() {
        return major;
    }

    public void setMajor(Subject major) {
        this.major = major;
    }

    public ArrayList<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(ArrayList<Score> scoreList) {
        this.scoreList = scoreList;
    }
}
