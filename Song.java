
public class Song {
   public static void main(String[] args) {
      fly1();
      spider1();
      bird1();
      cat1();
      dog1();
      donkey1();
      horse1();
   }
   
   public static void fly1() {
      System.out.println("There was an old woman who swallowed a fly.");
      fly2();
   }
   
   public static void spider1() {
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      spider2();
   }
   
   public static void bird1() {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      bird2();
   }
   
   public static void cat1() {
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      cat2();
   }
   
   public static void dog1() {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      dog2();
   }
   
   public static void donkey1() {
      System.out.println("There was an old woman who swallowed a donkey,");
      System.out.println("How wonky to swallow a donkey.");
      donkey2();
   }
   
   public static void horse1() {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }
   
   public static void fly2() {
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
      System.out.println();
   }
   
   public static void spider2() {
      System.out.println("She swallowed the spider to catch the fly,");
      fly2();
   }
   
   public static void bird2 () {
      System.out.println("She swallowed the bird to catch the spider,");
      spider2();
   }
   
   public static void cat2() {
      System.out.println("She swallowed the cat to catch the bird,");
      bird2();
   }
   
   public static void dog2() {
      System.out.println("She swallowed the dog to catch the cat,");
      cat2();
   }
   
   public static void donkey2() {
      System.out.println("She swallowed the donkey to catch the dog,");
      dog2();
   }
   
}