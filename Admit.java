

import java.util.*;

//main method contains the scanner setup and outline of the program
public class Admit{
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      
      //direct to intro method for prompt
      intro();
      
      //direct to promptExam method to get the exam option and calculate exam score, assigned
      //variable will be examScore1 for first applicant
      double examScore1 = promptExam(console, 1);
      //direct to promptGPA method to get the gpa score, assigned variable will be gpaScore1
      double gpaScore1 = promptGPA(console);
      //direct to totalScore method with variables of examScore1 and gpaScore1 to calculate
      //the total score for applicant 1
      double totalScore1 = totalScore(examScore1, gpaScore1);
      
      //repeat the line13, 15, 18 for applicant 2
      double examScore2 = promptExam(console, 2);
      double gpaScore2 = promptGPA(console);
      double totalScore2 = totalScore(examScore2, gpaScore2);
      
      //print out the total score for both applicants with rounded results
      System.out.println("First applicant overall score  = " + roundNumber(totalScore1));
      System.out.println("Second applicant overall score = " + roundNumber(totalScore2));
      
      //direct to compareScore method with totalScore variables for both applicants
      //program will also print out the result after comparing them
      compareScore(totalScore1, totalScore2);
   }
   
   //intro method print out the intro in four separate lines
   public static void intro(){
      System.out.println("This program compares two applicants to");
      System.out.println("determine which one seems like the stronger");
      System.out.println("applicant.  For each candidate I will need");
      System.out.println("either SAT or ACT scores plus a weighted GPA.");
      System.out.println();
   }
   
   //promptExam use parameter to take in # for applicant and scanner
   //prompt for suer input of exam time then use if/else statement to
   //direct to another method to calculate exam score
   //if will print out and return the examscore
   public static double promptExam(Scanner console, int applicant){
      System.out.println("Information for applicant #" + applicant + ":");
      System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
      int scoreType = console.nextInt();
      double examScore;
      if (scoreType == 1){    //SAT score
         examScore = satScore(console);
      }
      else {     //ACT score
         examScore = actScore(console);
      }
      System.out.println("    exam score = " + roundNumber(examScore));
      return examScore;
   }
   
   //if user entered 1 in method promptExam, the program will be here
   //it will prompt for scores and calculate the exam score
   //this method will return the examscore to promptExam
   public static double satScore(Scanner console){
      System.out.print("    SAT math? ");
      double satMath = console.nextInt();
      System.out.print("    SAT critical reading? ");
      double satReading = console.nextInt();
      System.out.print("    SAT writing? ");
      double satWriting = console.nextInt();
      double examScore = (2 * satMath + satReading + satWriting) / 32;
      return examScore;
   }
   
   //just like the purpose for satScore method but for ACT exam
   //this method will be used if the input was 2
   //will return examscore to promptExam
   public static double actScore(Scanner console){
      System.out.print("    ACT English? ");
      int actEnglish = console.nextInt();
      System.out.print("    ACT math? ");
      int actMath = console.nextInt();
      System.out.print("    ACT reading? ");
      int actReading = console.nextInt();
      System.out.print("    ACT science? ");
      int actScience = console.nextInt();
      double examScore = (actEnglish + 2 * actMath + actReading + actScience) / 1.8;
      return examScore;
   }
   
   //prompt for GPA score input and calculate gpa score
   //it will print and reurn calculated gpaScore
   //method will be used for both applicants
   public static double promptGPA(Scanner console){
      System.out.print("    overall GPA? ");
      double overallGpa = console.nextDouble();
      System.out.print("    max GPA? ");
      double maxGpa = console.nextDouble();
      System.out.print("    Transcript Multiplier? ");
      double multiplier = console.nextDouble();
      double gpaScore = overallGpa / maxGpa * 100 * multiplier;
      System.out.println("    GPA score = " + roundNumber(gpaScore));
      System.out.println();
      return gpaScore;
   }
   
   //this method will use the examScore and gpa Score variable to
   //calculate the total score by adding them together
   //and return the totalscore
   public static double totalScore(double examScore, double gpaScore){
      return examScore + gpaScore;
   }
   
   //this method will use the totalscore for both applicants
   //results are compared with if/else if/else statement
   //also print out the compare result
   public static void compareScore(double totalScore1, double totalScore2){
      if (totalScore1 > totalScore2) {
         System.out.println("The first applicant seems to be better");
      } else if (totalScore1 < totalScore2) {
         System.out.print("The second applicant seems to be better");
      } else { //totalScore1 = totalScore2
         System.out.println("The two applicants seem to be equal");
      }
   }
   
   //this method will round numbers to one decimal
   public static double roundNumber(double number) {
      return ( Math.round(number * 10)) / 10.0;
   }
   
}