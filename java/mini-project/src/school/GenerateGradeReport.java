package school;

import java.sql.Struct;

public class GenerateGradeReport {
    private StringBuffer report;
    private School school;

    private static final String TITLE = " 과목 수강생 학점 \t\t\n";
    private static final String HEADER = " 이름  |  학번  |  전공  |  점수  \n";
    private static final String LINE = "-------------------------";


    public GenerateGradeReport(){
        school = School.getInstance();
    }

    public void gradeReport(){
        report = new StringBuffer();
        for(Subject subject : school.getSubjectList()){

        }
    }

    public void gradeReport(Subject subject){

    }

    private void makeHeader(Subject subject){
        report.append(LINE);
        report.append(subject.getSubjectName());
        report.append(TITLE);
        report.append(HEADER);
        report.append(LINE);
    }

    private void makeBody(Subject subject){

    }

    public void makeFooter(Subject subject){

    }
}
