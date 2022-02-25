package school;

public class MajorEvaluation implements GradeEvaluation{
    @Override
    public String getGrade(int point) {
        if(point >= 95 && point <= 100)
            return "S";
        else if(point >= 90)
            return "A";
        else if(point >= 80)
            return "B";
        else if(point >= 70)
            return "C";
        else if(point >= 60)
            return "D";
        else if(point >=0 && point < 60)
            return "F";
        else
            return null;
    }
}
