import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
* JUnit test for Weke_ula I'a subclass.
* @author Lisa Miller
* @since 3/15/22
*/

public class Weke_ulaTest {
   /** constant reproductive mode for this Ia. */
   static final String REPRODUCTIVE_MODE = "serial";
   /** constant array of what the fish eats. */
   static final String[] DIET_ITEMS = {"worms", "mollusks", "invertebrates"};
   /** constant maximum length for this Ia. */
   static final double MAX_LENGTH = 30.0;
   /** constant minimum length for this Ia. 
   */
   static final double MIN_LENGTH = 7.0;


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Constructor with random length test.*/
   @Test public void constructorAndGetterTest(){
      I_a i = new Weke_ula();
      String name = i.getName();
      String engName = i.getEnglishName();
      String sciName = i.getScientificName();
      double length = i.getLength();
      boolean dietOk = false;
      String bodColor = i.getBodyColor();
      String finColor = i.getFinColor();
      String sex = i.getSex();
      
      Assert.assertTrue("Name is not correct. It is " + name + " but should be Weke'ula",
             name.equalsIgnoreCase("Weke'ula"));
      Assert.assertTrue("English name is not correct. It is " + engName + " but should be Yellowfin Goatfish",
             engName.equalsIgnoreCase("Yellowfin Goatfish"));
      Assert.assertTrue("Scientific name is not correct. It is " + sciName 
            + " but should be Mulloidichthys vanicolensis",
             sciName.equalsIgnoreCase("Mulloidichthys vanicolensis"));
      Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
            + " but should be between " + MIN_LENGTH + " and " + MAX_LENGTH, (length >= MIN_LENGTH && length < MAX_LENGTH));

      Assert.assertTrue("Body color is not correct. It is " + bodColor 
            + " but should be white with yellow stripe", 
            bodColor.equalsIgnoreCase("white with yellow stripe"));
      Assert.assertTrue("Fin color is not correct. It is " + finColor + " but should be yellow", 
            finColor.equalsIgnoreCase("yellow"));

     Assert.assertTrue("Fish sex is not correct. It is " + sex 
         + " but should be male or female", 
         (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female")));
   
   }
   
   
   /** Constructor with given length test.*/
   @Test public void constructorWLengthAndGetterTest(){
      I_a i = new Weke_ula(11.0);
      String name = i.getName();
      String engName = i.getEnglishName();
      String sciName = i.getScientificName();
      double length = i.getLength();
      boolean dietOk = false;
      String bodColor = i.getBodyColor();
      String finColor = i.getFinColor();
      String sex = i.getSex();
      
      Assert.assertTrue("Name is not correct. It is " + name + " but should be Weke'ula",
            name.equalsIgnoreCase("Weke'ula"));
      Assert.assertTrue("English name is not correct. It is " + engName + " but should be Yellowfin Goatfish",
             engName.equalsIgnoreCase("Yellowfin Goatfish"));
      Assert.assertTrue("Scientific name is not correct. It is " + sciName 
            + " but should be Mulloidichthys vanicolensis",
             sciName.equalsIgnoreCase("Mulloidichthys vanicolensis"));
      Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
            + " but should be between " + MIN_LENGTH + " and " + MAX_LENGTH, (length >= MIN_LENGTH && length < MAX_LENGTH));

      Assert.assertTrue("Body color is not correct. It is " + bodColor 
            + " but should be white with yellow stripe", 
            bodColor.equalsIgnoreCase("white with yellow stripe"));
      Assert.assertTrue("Fin color is not correct. It is " + finColor + " but should be yellow", 
            finColor.equalsIgnoreCase("yellow"));

     Assert.assertTrue("Fish sex is not correct. It is " + sex 
         + " but should be male or female", 
         (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female")));
   
   }
   
     /** Constructor with length Exception test.*/
   @Test(expected=FishSizeException.class)
   public void constructorLengthTooLongTest(){
      I_a i = new Weke_ula(33.1);
   }

     /** Constructor with length Exception test.*/
   @Test(expected=FishSizeException.class)
   public void constructorLengthTooShortTest(){
      I_a i = new Weke_ula(-0.1);
   }

   /** setLength Exception test.*/
   @Test(expected=FishSizeException.class)
   public void setLengthTooLongTest(){
      I_a i = new Weke_ula();
      i.setLength(39.5);
   }

      /** setLength Exception test.*/
   @Test(expected=FishSizeException.class)
   public void setLengthTooShortTest(){
      I_a i = new Weke_ula();
      i.setLength(-0.1);
   }
   
   /**
      Checks fish eats all diet items with no Exception.
    */
   @Test public void eatingDietTest(){
      I_a a = new Weke_ula();
      String food = "";
      boolean foodListCorrect = true;
      String bad = "";
      for(int i = 0; i < DIET_ITEMS.length; i++){
         food = DIET_ITEMS[i];
         try{
            a.eat(food);
         } catch(FishFoodException fe) {
            foodListCorrect = false;
            bad = food;
         } catch(FishSizeException fs) {
            //do nothing food ok but fish got too big
         }
      
      }
      Assert.assertTrue("Fish diet items are not correct. " + bad 
         + " is not a diet item", foodListCorrect);

   } //eating test
   
  /**
  * Test FishFoodException throwing
  */
  
  @Test(expected=FishFoodException.class)
  public void fishFoodExceptionTest()throws FishFoodException {
    I_a a = new Weke_ula();
    a.eat("raisins");
  }
  
  /**
  * Test grow and eat methods.
  */
  public void growthTest(){
   I_a a = new Weke_ula(1.0);
   double newLen = 0;
   a.eat("worms");
   newLen = a.getLength();
   Assert.assertTrue("Fish does not grow bigger when eating. Start length: 1.0, End length: "
    + newLen, newLen > 1.0);
  }
  
  /**
  * Test need to levelUp from eat method.
  */
//   @Test(expected=FishSizeException.class)
//   public void growthSizeExceptionTest()throws FishSizeException {
//     I_a a = new Weke_ula(29.999);
//     boolean tooBig = false;
//     while(!tooBig) {
//       a.eat("worms");
//     }
//   }
  
    /**
  * Test levelUp method.
  */

 //  @Test public void levelUpTest() {
//     I_a a = new Weke_ula(29.999);
//     boolean tooBig = false;
//     while(!tooBig) {
//       try {
//          a.eat("worms");
//       } catch (FishSizeException fse) {
//          tooBig = true;
//       }
//     }
//     I_a i = a.levelUp();
//     //check that i is next level fish
//       String name = i.getName();
//       String engName = i.getEnglishName();
//       String sciName = i.getScientificName();
//       double length = i.getLength();
//       boolean dietOk = false;
//       String bodColor = i.getBodyColor();
//       String finColor = i.getFinColor();
//       String sex = i.getSex();
//       double leveledUpMaxLength = 30.0;
//       double leveledUpMinLength = 7.0;
//       
//       Assert.assertTrue("Name is not correct. It is " + name + " but should be Weke'ula or Weke'a",
//              (name.equalsIgnoreCase("Weke'ula") || name.equalsIgnoreCase("Weke'a")));
//       Assert.assertTrue("English name is not correct. It is " + engName 
//             + " but should be Yellowfin Goatfish or Yellowfin Goatfish",
//              (engName.equalsIgnoreCase("Yellowfin Goatfish") || engName.equalsIgnoreCase("Yellowfin Goatfish")));
//       Assert.assertTrue("Scientific name is not correct. It is " + sciName 
//             + " but should be Mulloidichthys vanicolensis or Mulloidichthys Vanicolensis",
//              (sciName.equalsIgnoreCase("Mulloidichthys vanicolensis") 
//              || sciName.equalsIgnoreCase("Mulloidichthys Vanicolensis")));
//       Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
//             + " but should be between " + leveledUpMinLength + " and " + leveledUpMaxLength, (length >= leveledUpMinLength && length < leveledUpMaxLength));
// 
//       Assert.assertTrue("Body color is not correct. It is " + bodColor 
//             + " but should be white with yellow stripe and black spot or white with yellow stripe", 
//             (bodColor.equalsIgnoreCase("white with yellow stripe") 
//             || bodColor.equalsIgnoreCase("white with yellow stripe and black spot") ));
//       Assert.assertTrue("Fin color is not correct. It is " + finColor + " but should be yellow or white", 
//             (finColor.equalsIgnoreCase("white") || finColor.equalsIgnoreCase("yellow")
//             || finColor.equalsIgnoreCase("yellow or white") ));
// 
//       Assert.assertTrue("Fish sex is not correct. It is " + sex + " but should be male or female", (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female")));
//   } //end level up test
  
  /************* Fishable methods tests ****************************/
  //****************** Check for Fishable Implementation ***********/
  @Test public void isFishableTest() {
        Weke_ula a = new Weke_ula();
        Assert.assertTrue(a.getName() + " is not Fishable as required", (a instanceof Fishable));
  }
  //*********** Not yet completed ************
  /** test isLegalSize. */
  @Test public void isLegalSizeTest() {
      Weke_ula a = new Weke_ula();
      Assert.assertEquals("This fish has no minimum size", true, a.isLegalSize());
  }
  /** test isBait. */
    @Test public void isBaitTest() {
      Weke_ula a = new Weke_ula();
      Assert.assertEquals("This fish is used for bait", true, a.isBait());
  }
  
  /** test isGameFish method. */
      @Test public void isGamefishTest() {
      Weke_ula a = new Weke_ula();
      Assert.assertEquals("This fish is used for eating", true, a.isGamefish());
  }
  // test getCatchMethods
  /** test getCatchMethods method. */
      @Test public void getCatchMethodsTest() {
      Weke_ula a = new Weke_ula();
      String[] validCatchMeth = {"net", "trap", "pole"};
      String[] fishCatchMeth = a.getCatchMethods();
      boolean match = false;
      for(int i = 0; i < validCatchMeth.length; i++){
         for(int j= 0; j < fishCatchMeth.length; j++){
            if(validCatchMeth[i].equalsIgnoreCase(fishCatchMeth[j])){
               match = true;
            }
         
         }
         Assert.assertTrue("This fish is missing "+ validCatchMeth[i] + "as a catch method", match);
         match = false;
      }
      
  }
 //******************** colorChangeable requirements ********************************
    //****************** Check for ColorChangeable Implementation ***********/
  @Test public void isColorChangeableTest() {
        Weke_ula a = new Weke_ula();
        Assert.assertTrue(a.getName() + " is not ColorChangeable as required", (a instanceof ColorChangeable));
  }
   /** test setColor method.
  * This size weke'ula can change color even can turn red.
  */
  @Test public void setColorMethodTest() {
    Weke_ula a = new Weke_ula();
      a.setColor("red", "red");
      String bodColor = a.getBodyColor();
      String finColor = a.getFinColor();
       Assert.assertEquals("Body color is not correct. It is " + bodColor 
            + " but should be red", 
            bodColor, "red");
      Assert.assertTrue("Fin color is not correct. It is " + finColor + " but should be red", 
            finColor.equalsIgnoreCase("red"));


  }
    
 } ///close test clas
