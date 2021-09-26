package school;

import java.util.ArrayList;

public class GenerateGradeReport {
    private StringBuffer report;
    private School school;

    private GradeEvaluation basicEval;
    private GradeEvaluation majorEval;

    private static final String TITLE = " 과목 수강생 학점 \t\t\n";
    private static final String HEADER = " 이름  |  학번  |  전공  |  점수  \n";
    private static final String LINE = "-------------------------\n";


    public GenerateGradeReport(){
        school = School.getInstance();
        basicEval = new BasicEvaluation();
        majorEval = new MajorEvaluation();
    }

    public void gradeReport(){
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
        for(Student student : subject.getStudentList()){
            report.append(student.getStudentName() + " | ");
            report.append(student.getStudentID() + " | ");
            report.append(student.getMajor() + " | ");
            report.append(getGrade(student, subject.getSubjectID())+"\n");
            report.append(LINE);
        }
    }

    private String getGrade(Student student, String subjectID){
        GradeEvaluation evaluation;
        String majorID = student.getMajor().getSubjectID();
        ArrayList<Score> scoreList = student.getScoreList();
        for(Score score : scoreList){
            if(score.getSubject().getSubjectID().equals(subjectID)){
                if(majorID.equals(subjectID)){
                    evaluation = majorEval;
                }else{
                    evaluation = basicEval;
                }
                return score.getPoint() + " : " + evaluation.getGrade(score.getPoint());
            }
        }
        return null;
    }

    private void makeFooter(Subject subject){

    }
}
