
public class DrawRocket {
   public static final int SIZE = 3;
   
// The codes below is the main method that calls the other methods to construct the rocket.
   public static void main(String[] args) {
      drawHead();
      drawLine();
      drawTopHalf();
      drawBottomHalf();
      drawLine();
      drawBottomHalf();
      drawTopHalf();
      drawLine();
      drawHead();
   }

// The method drawHead calls the top of the rocket. It includes four foor loops
//that calls each type of symbols.   
   public static void drawHead() {
      for (int line = 1; line <= 2 * SIZE - 1; line++) {
         for (int space = 1; space <= -1 * line + SIZE * 2; space++) {
            System.out.print(" ");
         }
         for (int dash = 1; dash <= line; dash++) {
            System.out.print("/");
         }
         System.out.print("**");
         for (int backslash = 1; backslash <= line; backslash++) {
            System.out.print("\\");
         }
         for (int space = 1; space <= -1 * line + SIZE * 2; space++) {
            System.out.print(" ");
         }
         System.out.println();
      }
   }

// The method drawLine draws the line in the rocket.
// the output should be "+=*=*=*=*+" and the length depends on SIZE.   
   public static void drawLine() {
      System.out.print("+");
      for (int i = 1; i <= SIZE * 2; i++) {
         System.out.print("=*");
      }
      System.out.println("+");
   }

//The method drawTopHalf includes nested for loops.
// the halfTriangles's out put would be "..../\...."(depends on SIZE).
// It will be printed on the same line
// drawTopHalf repeat halfTriangle twice and print it in new lines.
// Tthe number of lines will depends on the SIZE.   
   public static void drawTopHalf() {
      for (int line = 1; line <= SIZE; line++) {
         System.out.print("|");
         for (int halfTriangles = 1; halfTriangles <= 2; halfTriangles++) {
            
            for (int dots = 1; dots <= -1 * line + SIZE; dots++) {
               System.out.print(".");
            }
            for (int dashes = 1; dashes <= line; dashes++) {
               System.out.print("/\\");
            };
            for (int dots = 1; dots <= -1 * line + SIZE; dots++) {
               System.out.print(".");
            }
         }
         System.out.println("|");
      }
   }
// The method drawBottomHalf is the reverse of drawTopHalf
   public static void drawBottomHalf() {
      for (int line = SIZE; line >= 1; line--) {
         System.out.print("|");
         for (int halfTriangles = 1; halfTriangles <= 2; halfTriangles++) {
            
            for (int dots = 1; dots <= -1 * line + SIZE; dots++) {
               System.out.print(".");
            }
            for (int dashes = 1; dashes <= line; dashes++) {
               System.out.print("\\/");
            };
            for (int dots = 1; dots <= -1 * line + SIZE; dots++) {
               System.out.print(".");
            }
         }
         System.out.println("|");
      }
   }
}