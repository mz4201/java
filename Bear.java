

import java.awt.*;

public class Bear extends Critter {
   //private variables for the count of steps and
   //he boolean value for bear - help determine color
   private boolean polar;
   private int step;
   
   //constructor for the critter bear
   public Bear(boolean polar) {
      this.polar = polar;
   }
   
   //return the decision move for bear
   public Action getMove(CritterInfo info) {
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
      } else {
         return Action.LEFT;
      }
   }
   
   //return the color for bear
   //determined by the boolean value polar
   public Color getColor() {
      if (this.polar){  //if polar is true
         return Color.WHITE;
      }else{   //if polar is false
         return Color.BLACK;
      }
   }
   
   //return the String representation for Bear
   //alterante every step
   public String toString() {
      this.step++;
      if (step % 2 == 0) { //even number step is "/"
         return "/";
      } else { //odd number step is "\"
         return "\\";
      }
   }
   
}