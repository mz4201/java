

import java.awt.*;

public class Doodle {
   
   public static void main(String[] args) {
   //the three line of codes below setup the canvas to 200px x 200px with black background.
      DrawingPanel panel = new DrawingPanel(200, 200);
      Graphics g = panel.getGraphics();
      panel.setBackground(Color.BLACK);
      
      //the lines below draws circles and rectangles in different color at different coordinates.
      g.setColor( Color. RED);
      g.fillRect( 20, 20, 160, 160);
      
      g.setColor( Color. ORANGE);
      g.fillOval( 20, 20, 160, 160);
      
      g.setColor( Color. YELLOW);
      g.fillRect( 43, 43, 113, 113);
      
      g.setColor( Color. GREEN);
      g.fillOval( 43, 43, 113, 113);
      
      g.setColor( Color. CYAN);
      g.fillRect( 59, 59, 80, 80);
      
      g.setColor( Color. BLUE);
      g.fillOval( 59, 59, 80, 80);
      
      g.setColor( Color. MAGENTA);
      g.fillRect( 70, 70, 57, 57);
      
      g.setColor( Color. PINK);
      g.fillOval( 70, 70, 57, 57);
      
      g.setColor( Color. BLACK);
      g.fillRect( 78, 78, 40, 40);
      
   }
   
}