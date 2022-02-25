package school;

public class BasicEvaluation implements GradeEvaluation{
    @Override
    public String getGrade(int point) {
        if(point >= 90 && point <= 100)
            return "A";
        else if(point >= 80)
           return "B";
        else if(point >= 70)
            return "C";
        else if(point >= 55)
            return "D";
        else if(point >=0 && point < 55)
            return "F";
        else
            return null;
    }
}
