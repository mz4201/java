
public class AsciiArt {
   
   public static void main(String[] args) {
      drawLine();
      drawTopHalf();
      drawBottomHalf();
      drawLine();
   }
   
   public static void drawLine() {
      System.out.print("|");
      for (int i = 1; i <= 18; i++) {
         System.out.print("*");
      }
      System.out.println("|");
   }
   
   public static void drawTopHalf() {
      for (int line = 1; line <= 7; line++) {
         System.out.print("|");
         for (int star = 1; star <= -1 * line + 8; star++) {
            System.out.print("*");
         }
         System.out.print("//");
         for (int space = 1; space <= 2 * line - 2; space++) {
            System.out.print(" ");
         }
         System.out.print("\\\\");
         for (int star = 1; star <= -1 * line + 8; star++) {
            System.out.print("*");
         }
         System.out.println("|");
      }
   }
   
   public static void drawBottomHalf() {
      for (int line = 7; line >= 1; line--) {
         System.out.print("|");
         for (int star = 1; star <= -1 * line + 8; star++) {
            System.out.print("*");
         }
         System.out.print("\\\\");
         for (int space = 1; space <= 2 * line - 2; space++) {
            System.out.print(" ");
         }
         System.out.print("//");
         for (int star = 1; star <= -1 * line + 8; star++) {
            System.out.print("*");
         }
         System.out.println("|");
      }
   }
}