import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
* JUnit test for Oama I'a subclass.
* @author Lisa Miller
* @since 3/15/22
*/

public class OamaTest {
   /** constant reproductive mode for this Ia. */
   static final String REPRODUCTIVE_MODE = "serial";
   /** constant array of what the fish eats. */
   static final String[] DIET_ITEMS = {"worms", "mollusks", "invertebrates"};
   /** constant maximum length for this Ia. */
   static final double MAX_LENGTH = 7.0;
   /** constant minimum length for this Ia. 
   */
   static final double MIN_LENGTH = 0.01;


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Constructor with random length test.*/
   @Test public void constructorAndGetterTest(){
      I_a i = new Oama();
      String name = i.getName();
      String engName = i.getEnglishName();
      String sciName = i.getScientificName();
      double length = i.getLength();
      boolean dietOk = false;
      String bodColor = i.getBodyColor();
      String finColor = i.getFinColor();
      String sex = i.getSex();
      
      Assert.assertTrue("Name is not correct. It is " + name + " but should be 'Oama",
             name.equalsIgnoreCase("'Oama"));
      Assert.assertTrue("English name is not correct. It is " + engName + " but should be Goatfish",
             engName.equalsIgnoreCase("Goatfish"));
      Assert.assertTrue("Scientific name is not correct. It is " + sciName + " but should be Mulloidichthys",
             sciName.equalsIgnoreCase("Mulloidichthys"));
      Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
            + " but should be between " + MIN_LENGTH + " and " + MAX_LENGTH, (length >= MIN_LENGTH && length < MAX_LENGTH));

      Assert.assertTrue("Body color is not correct. It is " + bodColor + " but should be white with yellow stripe", bodColor.equalsIgnoreCase("white with yellow stripe"));
      Assert.assertTrue("Fin color is not correct. It is " + finColor + " but should be yellow or white", 
            (finColor.equalsIgnoreCase("white") || finColor.equalsIgnoreCase("yellow")
            || finColor.equalsIgnoreCase("yellow or white") ));

     Assert.assertTrue("Fish sex is not correct. It is " + sex + " but should be none", (sex.equalsIgnoreCase("none") || sex.equalsIgnoreCase("n/a")));
   
   }
   
   
   /** Constructor with given length test.*/
   @Test public void constructorWLengthAndGetterTest(){
      I_a i = new Oama(2.0);
      String name = i.getName();
      String engName = i.getEnglishName();
      String sciName = i.getScientificName();
      double length = i.getLength();
      boolean dietOk = false;
      String bodColor = i.getBodyColor();
      String finColor = i.getFinColor();
      String sex = i.getSex();
      
      Assert.assertTrue("Name is not correct. It is " + name + " but should be 'Oama",
             name.equalsIgnoreCase("'Oama"));
      Assert.assertTrue("English name is not correct. It is " + engName + " but should be Goatfish",
             engName.equalsIgnoreCase("Goatfish"));
      Assert.assertTrue("Scientific name is not correct. It is " + sciName + " but should be Mulloidichthys",
             sciName.equalsIgnoreCase("Mulloidichthys"));
      Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
            + " but should be between " + MIN_LENGTH + " and " + MAX_LENGTH, (length >= MIN_LENGTH && length < MAX_LENGTH));

      Assert.assertTrue("Body color is not correct. It is " + bodColor + " but should be white with yellow stripe", bodColor.equalsIgnoreCase("white with yellow stripe"));
      Assert.assertTrue("Fin color is not correct. It is " + finColor + " but should be yellow or white", 
            (finColor.equalsIgnoreCase("white") || finColor.equalsIgnoreCase("yellow")
            || finColor.equalsIgnoreCase("yellow or white") ));

     Assert.assertTrue("Fish sex is not correct. It is " + sex + " but should be none", sex.equalsIgnoreCase("none"));
   
   }
   
     /** Constructor with length Exception test.*/
   @Test(expected=FishSizeException.class)
   public void constructorLengthTooLongTest(){
      I_a i = new Oama(8.1);
   }

     /** Constructor with length Exception test.*/
   @Test(expected=FishSizeException.class)
   public void constructorLengthTooShortTest(){
      I_a i = new Oama(-0.1);
   }

   /** setLength Exception test.*/
   @Test(expected=FishSizeException.class)
   public void setLengthTooLongTest(){
      I_a i = new Oama();
      i.setLength(9.5);
   }

      /** setLength Exception test.*/
   @Test(expected=FishSizeException.class)
   public void setLengthTooShortTest(){
      I_a i = new Oama();
      i.setLength(-0.1);
   }
   
   /**
      Checks fish eats all diet items with no Exception.
    */
   @Test public void eatingDietTest(){
      I_a a = new Oama();
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
    I_a a = new Oama();
    a.eat("raisins");
  }
  
  /**
  * Test grow and eat methods.
  */
  @Test public void growthTest(){
   I_a a = new Oama(1.0);
      double newLen = 0;
      double oldLen = a.getLength();
      a.eat("worms");
      newLen = a.getLength();
      Assert.assertTrue("Fish does not grow bigger when eating. Start length: " + oldLen
            + ", End length: " + newLen, newLen > oldLen);
  }
  
  /**
  * Test need to levelUp from eat method.
  */
  @Test(expected=FishSizeException.class)
  public void growthSizeExceptionTest()throws FishSizeException {
    I_a a = new Oama(6.999);
    boolean tooBig = false;
    while(!tooBig) {
      a.eat("worms");
    }
  }
  
    /**
  * Test levelUp method.
  */

  @Test public void levelUpTest() {
    I_a a = new Oama(3.999);
    boolean tooBig = false;
    while(!tooBig) {
      try {
         a.eat("worms");
      } catch (FishSizeException fse) {
         tooBig = true;
      }
    }
    I_a i = a.levelUp();
    //check that i is next level fish
      String name = i.getName();
      String engName = i.getEnglishName();
      String sciName = i.getScientificName();
      double length = i.getLength();
      boolean dietOk = false;
      String bodColor = i.getBodyColor();
      String finColor = i.getFinColor();
      String sex = i.getSex();
      double leveledUpMaxLength = 30.0;
      double leveledUpMinLength = 7.0;
      
      Assert.assertTrue("Name is not correct. It is " + name + " but should be Weke'ula or Weke'a",
             (name.equalsIgnoreCase("Weke'ula") || name.equalsIgnoreCase("Weke'a")));
      Assert.assertTrue("English name is not correct. It is " + engName 
            + " but should be Square-spot Goatfish or Yellowfin Goatfish",
             (engName.equalsIgnoreCase("Square-spot Goatfish") || engName.equalsIgnoreCase("Yellowfin Goatfish")));
      Assert.assertTrue("Scientific name is not correct. It is " + sciName 
            + " but should be Mulloidichthys flavolineatus or Mulloidichthys Vanicolensis",
             (sciName.equalsIgnoreCase("Mulloidichthys flavolineatus") 
             || sciName.equalsIgnoreCase("Mulloidichthys Vanicolensis")));
      Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
            + " but should be between " + leveledUpMinLength + " and " + leveledUpMaxLength, (length >= leveledUpMinLength && length < leveledUpMaxLength));

      Assert.assertTrue("Body color is not correct. It is " + bodColor 
            + " but should be white with yellow stripe and black spot or white with yellow stripe", 
            (bodColor.equalsIgnoreCase("white with yellow stripe") 
            || bodColor.equalsIgnoreCase("white with yellow stripe and black spot") ));
      Assert.assertTrue("Fin color is not correct. It is " + finColor + " but should be yellow or white", 
            (finColor.equalsIgnoreCase("white") || finColor.equalsIgnoreCase("yellow")
            || finColor.equalsIgnoreCase("yellow or white") ));

      Assert.assertTrue("Fish sex is not correct. It is " + sex + " but should be male or female", (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female")));
  } //end level up test
  
  /************* Fishable methods tests ****************************/
  //****************** Check for Fishable Implementation ***********/
  @Test public void isFishableTest() {
        Oama a = new Oama();
        Assert.assertTrue(a.getName() + " is not Fishable as required", (a instanceof Fishable));
  }
  //*********** Not yet completed ************
  /** test isLegalSize. */
  @Test public void isLegalSizeTest() {
      Oama a = new Oama();
      Assert.assertEquals("This fish has no minimum size", true, a.isLegalSize());
  }
  /** test isBait. */
    @Test public void isBaitTest() {
      Oama a = new Oama();
      Assert.assertEquals("This fish is used for bait", true, a.isBait());
  }
  
  /** test isGameFish method. */
      @Test public void isGamefishTest() {
      Oama a = new Oama();
  }
  // test getCatchMethods
 /** test getCatchMethods method. */
      @Test public void getCatchMethodsTest() {
      Oama a = new Oama();
      String[] validCatchMeth = {"pole", "net"};
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
        Oama a = new Oama();
        Assert.assertTrue(a.getName() + " is not ColorChangeable as required", (a instanceof ColorChangeable));
  }
   /** test setColor method.
  * This size weke can't change color always throws exception.
  */
  @Test(expected=UnsupportedOperationException.class)
  public void setColorMethodTest()throws UnsupportedOperationException {
    Oama a = new Oama();
      a.setColor("purple", "green");
  }
    
 } ///close test clas
