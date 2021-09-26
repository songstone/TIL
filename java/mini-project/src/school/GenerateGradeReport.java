package school;

public class GenerateGradeReport {
    private StringBuffer report;

    private static final String TITLE = " 과목 수강생 학점 \t\t\n";
    private static final String HEADER = " 이름  |  학번  |  전공  |  점수  \n";
    private static final String LiNE = "-------------------------";


    public GenerateGradeReport(){
        report = new StringBuffer();
    }
}
