

//importing the java drawing library
import java.awt.*;

public class CafeWall {
   
   //fixed number of mortar throughout the program.
   public static final int MORTAR = 2;
   
   //main method that can call to draw rows and grid with input setting.
   //background is grey; canvas is 650px x 400 px; panel renamed to g
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(650, 400);
      Graphics g = panel.getGraphics();
      panel.setBackground(Color.GRAY);
      drawRow(g, 0, 0, 20, 4);
      drawRow(g, 50, 70, 30, 5);
      
      drawGrid(g, 10, 150, 25, 4, 0);
      drawGrid(g, 10, 150, 25, 4, 0);
      drawGrid(g, 250, 200, 25, 3, 10);
      drawGrid(g, 425, 180, 20, 5, 10);
      drawGrid(g, 400, 20, 35, 2, 35);    
   }

   //drawRow method uses formulas to make a for loop that can drap pairs of 
   //tiles with blue X. It will draw a pair of tiles each time it runs.
   //The parameter will be used and bring in data such as the coordinate,
   //size, and pair.   
   public static void drawRow(Graphics g, int x, int y, int size, int pair) {
      for (int i = 0; i < pair; i++) {
         g.setColor(Color.BLACK);
         g.fillRect(size * 2 * i + x , y, size, size);
         g.setColor(Color.WHITE);
         g.fillRect(size + size * 2 * i + x, y, size, size);
         g.setColor(Color.BLUE);
         g.drawLine( size * 2 * i + x, y + size , size + size * 2 * i + x, y);
         g.drawLine( size * 2 * i + x, y, size + size * 2 * i + x, y + size);         
      }
   }
   
   // drawGrid method will use a for loop to call the drawRow method to draw the grid.
   // Each times the for loop calls, it will draw two lines of tiles.
   // The first line will be regular and second line will be applied with offset setting.
   // The constant mortar will also be called in this method. Parameter will also be used.   
   public static void drawGrid(Graphics g, int x, int y, int size, int pair, int offset){
      for (int i = 0; i < pair; i++) {
         drawRow( g, x, y + 2 * i * (size + MORTAR), size, pair);
         drawRow( g, x + offset, y + 2 * i * (size + MORTAR ) + MORTAR + size, size, pair);
      }
   }
   
}