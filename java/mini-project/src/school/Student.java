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

}
