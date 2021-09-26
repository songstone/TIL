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


}
