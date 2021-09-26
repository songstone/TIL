package school;

public class GradeReportTest {
    public static void main(String[] args) {
        School school = School.getInstance();
        GenerateGradeReport test = new GenerateGradeReport();

        Subject math = new Subject("Math");
        Subject english = new Subject("English");
        Subject physics = new Subject("Physics");

        Student student1 = new Student("song", math);
        Student student2 = new Student("min", math);
        Student student3 = new Student("ku", english);
        Student student4 = new Student("hong", physics);
        Student student5 = new Student("kang", physics);

        school.addSubject(math);
        school.addSubject(english);
        school.addSubject(physics);

        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);
        school.addStudent(student4);
        school.addStudent(student5);

        student1.addScore(math,100);
        student1.addScore(english,97);
        student1.addScore(physics,93);

        student2.addScore(math,92);
        student2.addScore(english,100);
        student2.addScore(physics,60);

        student3.addScore(math,93);
        student3.addScore(english,65);
        student3.addScore(physics,94);

        student4.addScore(math,50);
        student4.addScore(english,40);
        student4.addScore(physics,94);

        student5.addScore(math,75);
        student5.addScore(english,93);
        student5.addScore(physics,83);

        test.gradeReport();
        

    }
}
