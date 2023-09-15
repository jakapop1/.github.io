import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
* JUnit test for Pua_ama I'a subclass.
* @author Lisa Miller
* @since 3/15/22
*/

public class Pua_amaTest {
   /** constant reproductive mode for this Ia. */
   static final String REPRODUCTIVE_MODE = "protoandrous";
   /** constant array of what the fish eats. */
   static final String[] DIET_ITEMS = {"zooplankton", "algae", "detritus",  "invertebrates"};
   /** constant maximum length for this Ia. */
   static final double MAX_LENGTH = 4.0;
   /** constant minimum length for this Ia. 
   */
   static final double MIN_LENGTH = 0.0;


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Constructor with random length test.*/
   @Test public void constructorAndGetterTest(){
      I_a i = new Pua_ama();
      String name = i.getName();
      String engName = i.getEnglishName();
      String sciName = i.getScientificName();
      double length = i.getLength();
      boolean dietOk = false;
      String bodColor = i.getBodyColor();
      String finColor = i.getFinColor();
      String sex = i.getSex();
      
      Assert.assertTrue("Name is not correct. It is " + name + " but should be Pua'ama",
             name.equalsIgnoreCase("Pua'ama"));
      Assert.assertTrue("English name is not correct. It is " + engName + " but should be Striped mullet",
             engName.equalsIgnoreCase("Striped mullet"));
      Assert.assertTrue("Scientific name is not correct. It is " + sciName + " but should be Mugil Cephalus",
             sciName.equalsIgnoreCase("Mugil Cephalus"));
      Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
            + " but should be between " + MIN_LENGTH + " and " + MAX_LENGTH, (length >= MIN_LENGTH && length < MAX_LENGTH));

      Assert.assertEquals("Body color is not correct. It is " + bodColor + " but should be silver", bodColor, "silver");
      Assert.assertEquals("Fin color is not correct. It is " + finColor + " but should be silver", 
            finColor, "silver");
      Assert.assertEquals("Fish sex is not correct. It is " + sex + " but should be none", sex, "none");
   
   }
   
   
   /** Constructor with given length test.*/
   @Test public void constructorWLengthAndGetterTest(){
      I_a i = new Pua_ama(2.0);
      String name = i.getName();
      String engName = i.getEnglishName();
      String sciName = i.getScientificName();
      double length = i.getLength();
      boolean dietOk = false;
      String bodColor = i.getBodyColor();
      String finColor = i.getFinColor();
      String sex = i.getSex();
      
      Assert.assertTrue("Name is not correct. It is " + name + " but should be Pua'ama",
             name.equalsIgnoreCase("Pua'ama"));
      Assert.assertTrue("English name is not correct. It is " + engName + " but should be Striped mullet",
             engName.equalsIgnoreCase("Striped mullet"));
      Assert.assertTrue("Scientific name is not correct. It is " + sciName + " but should be Mugil Cephalus",
             sciName.equalsIgnoreCase("Mugil Cephalus"));
      Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
            + " but should be between " + MIN_LENGTH + " and " + MAX_LENGTH, (length >= MIN_LENGTH && length < MAX_LENGTH));

      Assert.assertEquals("Body color is not correct. It is " + bodColor + " but should be silver", bodColor, "silver");
      Assert.assertEquals("Fin color is not correct. It is " + finColor + " but should be silver", 
            finColor, "silver");
      Assert.assertEquals("Fish sex is not correct. It is " + sex + " but should be none", sex, "none");
   
   }
   
     /** Constructor with length Exception test.*/
   @Test(expected=FishSizeException.class)
   public void constructorLengthTooLongTest(){
      I_a i = new Pua_ama(8.1);
   }

     /** Constructor with length Exception test.*/
   @Test(expected=FishSizeException.class)
   public void constructorLengthTooShortTest(){
      I_a i = new Pua_ama(-0.1);
   }

   /** setLength Exception test.*/
   @Test(expected=FishSizeException.class)
   public void setLengthTooLongTest(){
      I_a i = new Pua_ama();
      i.setLength(9.5);
   }

      /** setLength Exception test.*/
   @Test(expected=FishSizeException.class)
   public void setLengthTooShortTest(){
      I_a i = new Pua_ama();
      i.setLength(-0.1);
   }
   
   /**
      Checks fish eats all diet items with no Exception.
    */
   @Test public void eatingDietTest(){
      I_a a = new Pua_ama();
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
    I_a a = new Pua_ama();
    a.eat("raisins");
  }
  
  /**
  * Test grow and eat methods.
  */
  @Test public void growthTest(){
   I_a a = new Pua_ama(1.0);
   double newLen = 0;
   a.eat("algae");
   newLen = a.getLength();
   Assert.assertTrue("Fish does not grow bigger when eating. Start length: 1.0, End length: "
    + newLen, newLen > 1.0);
  }
  
  /**
  * Test need to levelUp from eat method.
  */
  @Test(expected=FishSizeException.class)
  public void growthSizeExceptionTest()throws FishSizeException {
    I_a a = new Pua_ama(7.999);
    boolean tooBig = false;
    while(!tooBig) {
      a.eat("algae");
    }
  }
  
    /**
  * Test levelUp method.
  */

  @Test public void levelUpTest() {
    I_a a = new Pua_ama(3.999);
    boolean tooBig = false;
    while(!tooBig) {
      try {
         a.eat("algae");
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
      double leveledUpMaxLength = 8.0;
      double leveledUpMinLength = 4.0;
      
      Assert.assertTrue("Name is not correct. It is " + name + " but should be Kahaha",
             name.equalsIgnoreCase("Kahaha"));
      Assert.assertTrue("English name is not correct. It is " + engName + " but should be Striped mullet",
             engName.equalsIgnoreCase("Striped mullet"));
      Assert.assertTrue("Scientific name is not correct. It is " + sciName + " but should be Mugil Cephalus",
             sciName.equalsIgnoreCase("Mugil Cephalus"));
      Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
            + " but should be between " + leveledUpMinLength + " and " + leveledUpMaxLength, (length >= leveledUpMinLength && length < leveledUpMaxLength));

      Assert.assertEquals("Body color is not correct. It is " + bodColor + " but should be silver", bodColor, "silver");
      Assert.assertEquals("Fin color is not correct. It is " + finColor + " but should be silver", 
            finColor, "silver");
      Assert.assertTrue("Fish sex is not correct. It is " + sex + " but should be male or female", (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female")));
  } //end level up test
  
  /************* Fishable methods tests ****************************/
  
  //****************** Check for Fishable Implementation ***********/
  @Test public void isFishableTest() {
        Pua_ama a = new Pua_ama();
        Assert.assertTrue("Pua'ama is not Fishable", (a instanceof Fishable));
  }
  //*********** Not yet completed ************
  /** test isLegalSize. */
  @Test public void isLegalSizeTest() {
      Pua_ama a = new Pua_ama();
      Assert.assertEquals("This fish is never legal size", a.isLegalSize(), false);
  }
  /** test isBait. */
    @Test public void isBaitTest() {
      Pua_ama a = new Pua_ama();
      Assert.assertEquals("This fish is never used for bait", a.isBait(), false);
  }
  
  /** test isGameFish method. */
      @Test public void isGamefishTest() {
      Pua_ama a = new Pua_ama();
      Assert.assertEquals("This fish is never used for eating", a.isGamefish(), false);
  }
  // test getCatchMethods
  /** test getCatchMethods method. */
      @Test public void getCatchMethodsTest() {
      Pua_ama a = new Pua_ama();
      Assert.assertEquals("This fish has no catch methods", a.getCatchMethods(), null);
  }
    
 } ///close test clas
