

import java.awt.*;

public class Giant extends Critter {
   //private varialbe for the count of step and the String 
   //representation for Giant
   private int step;
   private String name;
   
   //return the decision move for Giant
   public Action getMove(CritterInfo info) {
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY){
         return Action.HOP;
      } else{
         return Action.RIGHT;
      }
   }
   
   //return the color of the String
   public Color getColor() {
      return Color.GRAY;
   }
   
   //return the String to represent the Giant
   //change every 6 steps, start again after four changes
   public String toString() {
      if(this.step < 23){ // if step is less than 23
         if(this.step / 6 == 0){ //the first 6 steps will apear as "fee"
            name = "fee";
         } else if (this. step / 6 == 1){  //second set of 6 steps appear as "fie"
            name = "fie";
         } else if (this. step / 6 == 2){  //third set appear as "foe"
            name = "foe";
         } else {  //this.step/6 == 3
            name = "fum";  //fourth set appear as "fum"
         }
         this.step++;  
         return name;
      } else{  //when step reach 24, the step reset to 0
         this.step = 0;
         return name;
      }
   }
}