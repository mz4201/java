

import java.io.*;
import java.util.*;
import java.awt.*;

public class Names{
   
   //constant through out the program
   public static final int YEAR = 1880;
   public static final int DECADES = 14;
   public static final int WIDTH = 70;
   public static final String FILENAME = "names.txt";
   
   //main method
   public static void main(String[] args) throws FileNotFoundException{
      Scanner input = new Scanner(new File(FILENAME));
      Scanner console = new Scanner(System.in);
      
      intro();
      //find name in the file and assign string variable line
      String line = find(console, input);
      
      //if the find(console, input) method return null,
      //the file will print the following text
      if (line == null){
         System.out.println("name/sex combination not found");
      }else {   //if file does contain the name
         //draw background
         DrawingPanel panel = new DrawingPanel(DECADES * WIDTH, 550);
         Graphics g = panel.getGraphics();
         drawGrid(g);
         printDrawCoord(g, line);
      }
   }
   
   //method to print the intro with a variable YEAR that can be modified
   public static void intro(){
      System.out.println("This program allows you to search through the");
      System.out.println("data from the Social Security Administration");
      System.out.println("to see how popular a particular name has been");
      System.out.println("since " + YEAR +".");
      System.out.println();
   }
   
   //method find that takes in scanner console, scanner input as paramenter
   //returns an integer
   public static String find(Scanner console, Scanner input){
      //prompt for input and assign variables
      System.out.print("name? ");
      String name = console.nextLine();
      System.out.print("sex (M or F)? ");
      String sex = console.nextLine();
      //this while loop read the file and find the line that contains the name
      while (input.hasNextLine()){  //if there are a next line in the file
         //assign variable line to the next token line in the file
         String line = input.nextLine();
         //change the line to lower case and assign new variable
         String lowerCasedLine = line.toLowerCase();
         //new scanner to read the lower cased line
         Scanner scanLine = new Scanner (lowerCasedLine);
         //the first token in the line would be the name
         String lineName = scanLine.next();
         //then the token after the name would be the sex
         String lineSex = scanLine.next();
         //if the nama in the line(regardless of case) and the sex in the line
         //is the same as the user's input of name and sex...
         if(lineName.equalsIgnoreCase(name) && lineSex.equalsIgnoreCase(sex)){
            return line;   //this method will return the line
         }
      }
      //if there are no more lines, return null
      return null;
   }

   //this method will draw the grid using Graphics
   public static void drawGrid(Graphics g){
      g.drawLine(0, 25, DECADES * WIDTH, 25);
      g.drawLine(0, 525, DECADES * WIDTH, 525);
      //draw DECADES amouont of vertical lines
      //print out the years
      for (int i = 0; i < DECADES; i++){
         g.drawLine(i * WIDTH, 0, i * WIDTH, 550);
         g.drawString(String.valueOf(YEAR + 10 * i), i * WIDTH, 550);
      }
   }

   //this method will find, print and draw the coordinates
   //takes Graphics, and line in the parameter   
   public static void printDrawCoord (Graphics g, String line){
      g.setColor(Color.RED);
      //reads the line and assign variable findCoord
      Scanner findCoord = new Scanner (line);
      //the variable nameSex contains the first token in the line
      String nameSex = findCoord.next();
      //add the uppcased next token to the nameSex variable
      nameSex = nameSex + " " + findCoord.next().toUpperCase();
      
      //priming for, x, y, and newY
      int y = 0;
      int x = 0;
      int newY = 0;
      
      //this for loop will read the rest of the line
      //assign variables to x, y, newY
      //print the nameSex and rank
      //connect and draw the graph
      //the loop will repeat DECADES amount
      for ( int i = 0; i < DECADES; i++){
         //the variable number is the next integer token in the line
         int number = findCoord.nextInt();
         //integer variable newY is the same as y
         newY = y;
         //this if/else statement will modify the y variable
         if (number > 0) {
            //if y is bigger than 0, it will divide by 2 to fit in the drawing panel
            y = 25 + (number / 2);
         } else {//if it is 0 or less, y = 525, which means 0 on the graph
            y = 525;
         }
         //draw the description with name, sex, and rank next the the coordinate
         g.drawString(nameSex + " " + String.valueOf(number), x, y);
         //draw a line from last coordinate to the next coordinate
         //x would be the same as the vertical lines on the grid
         //y would be old coordinate Y to the newY coordinate
         g.drawLine(x, y , x - WIDTH, newY);
         x = x + WIDTH;
      }
   }
   
}