public class Lab2{

    public static void main(String[] args){
        // CSE116 Grade Calculator (http://www.cse.buffalo.edu/~mhertz/courses/cse116/syllabus.pdf)

        double midterm1 = 100.0;
        double midterm2 = 100.0;
        double finalExam = 100.0;

        double midtermWeight = 0.25;
        double finalWeight = 0.5;

        double examAverage = midterm1 * midtermWeight + midterm2 * midtermWeight + finalExam * finalWeight;


        // Can declare 33 variables for the assignments instead of using the average here
        // We would store these 33 values in a data structure, but this lab came before data structures
        double homeworkAverage = 100.0;

        double learningQuestionsAverage = 100.0;

        double recitation1 = 100.0;
        double recitation2 = 100.0;
        double recitation3 = 100.0;
        double recitation4 = 100.0;
        double recitation5 = 100.0;
        double recitation6 = 100.0;
        double recitation7 = 100.0;
        double recitation8 = 100.0;
        double recitation9 = 100.0;
        double recitation10 = 100.0;
        double recitation11 = 100.0;
        double recitation12 = 100.0;
        double recitation13 = 100.0;

        // Again, this would be much cleaner with data structures
        double recitationAverage = (recitation1 + recitation2 + recitation3 + recitation4 +
                recitation5 + recitation6 + recitation7 + recitation8 + recitation9 +
                recitation10 + recitation11 + recitation12 + recitation13) / 13.0;

        double projectGrade = 100.0;


        double examWeight = 0.5;
        double homeworkWeight = 0.15;
        double learningQuestionsWeight = 0.1;
        double recitationWeight = 0.15;
        double projectWeight = 0.1;

        double finalGrade = examAverage * examWeight +
                homeworkAverage * homeworkWeight +
                learningQuestionsAverage * learningQuestionsWeight +
                recitationAverage * recitationWeight +
                projectGrade * projectWeight;


        // Declare letterGrade before the if statements so it doesn't fall out of scope. This allows us to
        // to use the variable after all the if statements.
        String letterGrade;

        if(finalGrade >= 93.0){
            letterGrade = "A";
        }else if(finalGrade >= 90.0){
            letterGrade = "A-";
        }else if(finalGrade >= 87.0){
            letterGrade = "B+";
        }else if(finalGrade >= 83.0){
            letterGrade = "B";
        }else if(finalGrade >= 80.0){
            letterGrade = "B-";
        }else if(finalGrade >= 77.0){
            letterGrade = "C+";
        }else if(finalGrade >= 73.0){
            letterGrade = "C";
        }else if(finalGrade >= 70.0){
            letterGrade = "C-";
        }else if(finalGrade >= 67.0){
            letterGrade = "D+";
        }else if(finalGrade >= 60.0){
            letterGrade = "D";
        }else{
            letterGrade = "F";
        }

        System.out.println("Final Grade: " + finalGrade);
        System.out.println("Letter Grade: " + letterGrade);
    }

}
