

import java.util.*;

public class Guess {
   //fixed number of maximumm guessing number throughout the program
   public static final int MAX = 100;
   
   public static void main(String[] args) {
      
      //priming and setups
      Scanner console = new Scanner(System.in);
      Random r = new Random();
      int totalGuesses = 0;
      int games = 0;
      int bestGuess = 666666;
      boolean playGame = true;
      
      intro();
      
      //player wants to play game; start with 'true' to start first game
      while (playGame == true) {
         
         //collect number of guesses in one round of game
         int numGuesses = oneGame(console, r, totalGuesses);
         //change the total number of guesses as more games are played
         totalGuesses = totalGuesses + numGuesses;

         //calculate the bestGuess by changing the bestGuess value to
         //the higher value after each round of game         
         if (numGuesses < bestGuess) {
            bestGuess = numGuesses;
         }
        
        
         //after each round, the value of games +1 
         games++;
         
         System.out.print("Do you want to play again? ");
         String choice = console.next();

         //the input will be changed to lowercase
         //if the first letter is 'n', the game will end
         //if the first letter is 'y', the game will continue going back to line 34
         //in the while loop         
         if (choice.toLowerCase().startsWith("n")) {
            playGame = false;
         }
      }
      results(games, bestGuess, totalGuesses);
   }
   
   public static void intro() {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println("100 and will allow you to guess until");
      System.out.println("you get it.  For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
   }
   
   //method to play one game with the user   
   public static int oneGame(Scanner console, Random r, int totalGuesses) {
      System.out.println();
      System.out.println("I'm thinking of a number between 1 and " + MAX + "...");
      
      //generate a random number; and priming the while loop       
      int number = r.nextInt(MAX) + 1;     
      int guess = 0;
      int numGuesses = 0;
      
      //this while loop determine if the input is higher or lower than the random number
      while (guess != number) {  //when the input is a wrong number
         System.out.print("Your guess? ");
         guess = console.nextInt();
         if (guess > number){
            System.out.println("It's lower.");
         } else if (guess < number){
            System.out.println("It's higher.");
         }
  
         //number of guesses in this turn +1
         numGuesses++;
      }
      
      //if it's a right answer, system will read after this line
      if (numGuesses == 1){
         System.out.println("You got it right in " + numGuesses + " guess");
      } else {
         System.out.println("You got it right in " + numGuesses + " guesses");
      }
      return numGuesses;
   }
 
   //method to report overall results to the user   
   public static void results(int games, int bestGuess, int totalGuesses) {
      System.out.println();
      System.out.println("Overall results:");
      System.out.println("    total games   = " + games);
      System.out.println("    total guesses = " + totalGuesses);
      //totalGuesses * 1.0 changes the totalGuesses to a double
      //and then roundNumber method round the number to one decimal      
      System.out.println("    guesses/game  = " + roundNumber(totalGuesses * 1.0 / games ));
      System.out.println("    best game     = " + bestGuess);
   }
   
   public static double roundNumber(double number) {
      return (Math.round(number * 10)) / 10.0;
   }
}
