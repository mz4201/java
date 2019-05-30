

import java.io.*;
import java.util.*;

public class Personality{
   
   //constant throughout the program for documentation purpose
   public static final int DIMENSIONS = 4;
   
   //main method 
   public static void main (String[] args) throws FileNotFoundException {
   
      Scanner console = new Scanner(System.in);
      intro();
      //prompt for input file name and output file name
      System.out.print("input file name? ");
      Scanner input = new Scanner(new File(console.next()));
      System.out.print("output file name? ");
      PrintStream output = new PrintStream(new File(console.next()));
      
      //while loop to read the file
      while (input.hasNextLine()){
         //create arrays for count of A and count of B
         int[] countA = new int[DIMENSIONS];
         int[] countB = new int[DIMENSIONS];
         //step 1: count number of A and B in the line
         //call method countAB and assignment inputName to the returned value
         String inputName = countAB(input, countA, countB);
         //create array for the B percentage
         int[] percentage = new int[DIMENSIONS];
         //step 2: calculate the B percentage
         percentage(countA, countB, percentage);
         //create string array for type of personality
         String[] type = new String[4];
         //step 3: use the B percentage to find the type of personality
         getType(percentage, type);
         //step 4: arrange the format and create output file
         results(output, inputName, percentage, type);
      }
   }
   
   //this is a simple method that will print out the prompt
   public static void intro(){
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter.  It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }
   
   //this mehod will take in the Scanner input, arrays countA and countB
   //it will calculat the amount of A and B in one line of input
   //return a String, which is the name
   public static String countAB(Scanner input, int[] countA, int[] countB){
      //modify line and assign variables
      String name = input.nextLine();
      String data = input.nextLine().toLowerCase();
      
      //priming
      int count = 0;
      
      //for loop to repeat for 10 times as there are 10 sets of data
      for ( int i = 0; i < 10;  i++){
         //determine which array the first value in the set belongs
         if (data.charAt(i * 7) == 'a'){
            countA[0]++;
         }
         if (data.charAt(i * 7) == 'b'){
            countB[0]++;
         }
         //count is representing how many or which value has been counted
         count++;
         
         //for loop to repeat for 3 times because these data determines
         //the S/N, T/F, J/P
         for ( int j = 1; j <= 3; j++){
            //for loop that will loop two times because two values is a set
            //to determine the personality letter
            for ( int k = 1; k <= 2; k++){
               //determine which arrays the character belongs
               if (data.charAt(count) == 'a'){
                  countA[j]++;
               }
               if (data.charAt(count) == 'b'){
                  countB[j]++;
               }
               count++;
            }
         }
      }
      //return the name value
      return name;
   }
   
   //this method uses the arrays count of A and B and the empty percentage array
   //modify the percentage array
   //no need for return value
   public static void percentage(int[] countA, int[] countB, int[] percentage){
      //loop for four times because the calculation need to be done for all four
      //numbers
      for (int i = 0 ; i < DIMENSIONS; i++){
         //formula for percentage: ( B / ( A + B ) ) * 100
         //round to nearest integer, converting between double and int
         percentage[i] = (int) Math.round((double) countB[i] / (countB[i] + countA[i]) * 100);
      }
   }
   
   //this method will use the percentage array and the empty string array
   //no need for return because it modifies the array
   public static void getType(int[] percentage, String[] type){
      //reference arrays
      //A[] is for the left side which is <50
      //B[] is for the right side which is >50
      String[] A = {"E", "S", "T", "J"};
      String[] B = {"I", "N", "F", "P"};
      
      //the for loop will loop four times because there are four personality
      //letters
      for (int i = 0; i < DIMENSIONS; i++){
         //for each letter, this for loop will loop four times
         //because of the four possibilities
         for (int j = 0; j < DIMENSIONS; j++){
            //if percentage is <50, the percentage[j] will change
            //to the according j value in A[j]
            //same for the else if statement
            if (percentage[j] < 50){
               type[j] = A[j];
            }else if(percentage[j] > 50){
               type[j] = B[j];
            //if percentage is 50, the letter would be X
            }else{
               type[j] = "X";
            }
         }
      }
   }
   
   //this method will conclude the result and export it in a txt file
   //it will use PrintStream output, the inputName, percentage array
   //and personality array
   //all the System.out.println/print are output.println/print 
   //because they will be exported to a txt file
   public static void results(PrintStream output, String inputName, int[] percentage, String[] type){
      output.print(inputName + ": " + Arrays.toString(percentage) + " = ");
      String resultType = "";
      //this for loop help format the personality type into "XXXX" instead of "[X,X,X,X]
      for(int i = 0; i < DIMENSIONS; i++) {
         resultType = type[i];
         output.print(resultType);
      }
      output.println();
   }
   
}