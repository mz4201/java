

import java.awt.*;
import java.util.*;

public class Lion extends Critter {
   //private variables for count of steps and oldColor,
   private int step;
   private Color oldColor;
   //private program that returns the randomly chosen color
   private Color newColor(){
      Random r = new Random();
      int color = r.nextInt(3);
      if (color == 0){
         return Color.RED;
      } else if(color == 1){
         return Color.GREEN;
      } else{
         return Color.BLUE;
      }
   }
   //use the count of step to determine if it's a new random color or keep
   //the current color. Then return the color.
   public Color getColor(){
      this.step++;
      if(this.step % 3 == 0){
         Color color = newColor();
         this.oldColor = color;
         return color;
      } else{
         return this.oldColor;
      }
   }
   
   //return the decision move for lion
   public Action getMove(CritterInfo info) {
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL ) {
         return Action.LEFT;
      } else if (info.getFront() == Neighbor.SAME){
         return Action.RIGHT;
      } else {
         return Action.HOP;
      }
   }
   
   //return the String representation value for Lion
   public String toString() {
      return "L";
   }
}