import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
* JUnit test for Panuhunuhu I'a subclass.
* @author Lisa Miller
* @since 3/15/22
*/

public class PanuhunuhuTest {
   /** constant reproductive mode for this Ia. */
   static final String REPRODUCTIVE_MODE = "protogynous";
   /** constant array of what the fish eats. */
   static final String[] DIET_ITEMS = {"Algae"};
   /** constant maximum length for this Ia. */
   static final double MAX_LENGTH = 12.0;
   /** constant minimum length for this Ia. 
   */
   static final double MIN_LENGTH = 4.0;


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Constructor with random length test.*/
   @Test public void constructorAndGetterTest(){
      I_a i = new Panuhunuhu();
      String name = i.getName();
      String engName = i.getEnglishName();
      String sciName = i.getScientificName();
      double length = i.getLength();
      boolean dietOk = false;
      String bodColor = i.getBodyColor();
      String finColor = i.getFinColor();
      String sex = i.getSex();
      
      Assert.assertTrue("Name is not correct. It is " + name + " but should be Panuhunuhu",
             name.equalsIgnoreCase("Panuhunuhu"));
      Assert.assertTrue("English name is not correct. It is " + engName + " but should be Parrotfish",
             engName.equalsIgnoreCase("Parrotfish"));
      Assert.assertTrue("Scientific name is not correct. It is " + sciName + " but should be Scaridae",
             sciName.equalsIgnoreCase("Scaridae"));
      Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
            + " but should be between " + MIN_LENGTH + " and " + MAX_LENGTH, (length >= MIN_LENGTH && length < MAX_LENGTH));

      Assert.assertEquals("Body color is not correct. It is " + bodColor + " but should be gray", bodColor, "gray");
      Assert.assertTrue("Fin color is not correct. It is " + finColor + " but should be gray or reddish gray", 
            (finColor.equalsIgnoreCase("gray") || (finColor.equalsIgnoreCase("reddish gray") )));

    Assert.assertTrue("Fish sex is not correct. It is " + sex + " but should be male or female", (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female")));
   
   }
   
   
   /** Constructor with given length test.*/
   @Test public void constructorWLengthAndGetterTest(){
      I_a i = new Panuhunuhu(6.0);
      String name = i.getName();
      String engName = i.getEnglishName();
      String sciName = i.getScientificName();
      double length = i.getLength();
      boolean dietOk = false;
      String bodColor = i.getBodyColor();
      String finColor = i.getFinColor();
      String sex = i.getSex();
      
      Assert.assertTrue("Name is not correct. It is " + name + " but should be Panuhunuhu",
             name.equalsIgnoreCase("Panuhunuhu"));
      Assert.assertTrue("English name is not correct. It is " + engName + " but should be Parrotfish",
             engName.equalsIgnoreCase("Parrotfish"));
      Assert.assertTrue("Scientific name is not correct. It is " + sciName + " but should be Scaridae",
             sciName.equalsIgnoreCase("Scaridae"));
      Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
            + " but should be between " + MIN_LENGTH + " and " + MAX_LENGTH, (length >= MIN_LENGTH && length < MAX_LENGTH));

      Assert.assertEquals("Body color is not correct. It is " + bodColor + " but should be gray", "gray", bodColor);
      Assert.assertTrue("Fin color is not correct. It is " + finColor + " but should be gray or reddish gray", 
            (finColor.equalsIgnoreCase("gray") || (finColor.equalsIgnoreCase("reddish gray") )));
      Assert.assertTrue("Fish sex is not correct. It is " + sex + " but should be male or female", (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female")));
   
   }
   
     /** Constructor with length Exception test.*/
   @Test(expected=FishSizeException.class)
   public void constructorLengthTooLongTest(){
      I_a i = new Panuhunuhu(12.1);
   }

     /** Constructor with length Exception test.*/
   @Test(expected=FishSizeException.class)
   public void constructorLengthTooShortTest(){
      I_a i = new Panuhunuhu(-0.1);
   }

   /** setLength Exception test.*/
   @Test(expected=FishSizeException.class)
   public void setLengthTooLongTest(){
      I_a i = new Panuhunuhu();
      i.setLength(12.5);
   }

      /** setLength Exception test.*/
   @Test(expected=FishSizeException.class)
   public void setLengthTooShortTest(){
      I_a i = new Panuhunuhu();
      i.setLength(-0.1);
   }
   
   /**
      Checks fish eats all diet items with no Exception.
    */
   @Test public void eatingDietTest(){
      I_a a = new Panuhunuhu();
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
    I_a a = new Panuhunuhu();
    a.eat("raisins");
  }
  
  /**
  * Test grow and eat methods.
  */
  @Test public void growthTest(){
   I_a a = new Panuhunuhu(8.0);
      double newLen = 0;
      double oldLen = a.getLength();
      a.eat("Algae");
      newLen = a.getLength();
      Assert.assertTrue("Fish does not grow bigger when eating. Start length: " + oldLen
            + ", End length: " + newLen, newLen > oldLen);
   }
  
  /**
  * Test need to levelUp from eat method.
  */
  @Test(expected=FishSizeException.class)
  public void growthSizeExceptionTest()throws FishSizeException {
    I_a a = new Panuhunuhu(11.999);
    boolean tooBig = false;
    while(!tooBig) {
      a.eat("Algae");
    }
  }
  
    /**
  * Test levelUp method.
  */

  @Test public void levelUpTest() {
    I_a a = new Panuhunuhu(11.999);
    boolean tooBig = false;
    while(!tooBig) {
      try {
         a.eat("Algae");
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
      double leveledUpMinLength = 12.0;
      
      Assert.assertTrue("Name is not correct. It is " + name + " but should be Uhu",
             name.equalsIgnoreCase("uhu"));
      Assert.assertTrue("English name is not correct. It is " + engName + " but should be Parrotfish",
             engName.equalsIgnoreCase("Parrotfish"));
      Assert.assertTrue("Scientific name is not correct. It is " + sciName + " but should be Scarus psittacus",
             sciName.equalsIgnoreCase("Scarus psittacus"));
      Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
            + " but should be between " + leveledUpMinLength + " and " + leveledUpMaxLength, (length >= leveledUpMinLength && length < leveledUpMaxLength));
      Assert.assertTrue("Body color is not correct. It is " + bodColor + " but should be gray or blue-green", 
            (bodColor.equalsIgnoreCase("gray") || bodColor.equalsIgnoreCase("blue-green")));
      Assert.assertTrue("Fin color is not correct. It is " + finColor + " but should be gray or reddish gray", 
            (finColor.equalsIgnoreCase("gray") || finColor.equalsIgnoreCase("reddish gray")|| finColor.equalsIgnoreCase("blue") ));
      Assert.assertTrue("Fish sex is not correct. It is " + sex + " but should be male or female or supermale", (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female") || sex.equalsIgnoreCase("supermale")));
  } //end level up test
  
  /************* Fishable methods tests ****************************/
  //****************** Check for Fishable Implementation ***********/
  @Test public void isFishableTest() {
        Panuhunuhu a = new Panuhunuhu();
        Assert.assertTrue(a.getName() + " is not Fishable as required", (a instanceof Fishable));
  }
  //*********** Not yet completed ************
  /** test isLegalSize. */
  @Test public void isLegalSizeTest() {
      Panuhunuhu a = new Panuhunuhu();
      Assert.assertEquals("This fish is never legal size", a.isLegalSize(), false);
  }
  /** test isBait. */
    @Test public void isBaitTest() {
      Panuhunuhu a = new Panuhunuhu();
      Assert.assertEquals("This fish is never used for bait", false, a.isBait());
  }
  
  /** test isGameFish method. */
      @Test public void isGamefishTest() {
      Panuhunuhu a = new Panuhunuhu();
      Assert.assertEquals("This fish is never used for eating", false, a.isGamefish());
  }
  // test getCatchMethods
  /** test getCatchMethods method. */
      @Test public void getCatchMethodsTest() {
      Panuhunuhu a = new Panuhunuhu();
      Assert.assertEquals("This fish has no catch methods", null, a.getCatchMethods());
  }
    
    //******************** SexChangeable methods tests **********************************/
      //****************** Check for SexChangeable Implementation ***********/
  @Test public void isSexChangeableTest() {
        Panuhunuhu a = new Panuhunuhu();
        Assert.assertTrue(a.getName() + " is not SexChangeable as required", (a instanceof SexChangeable));
  }
    /**
  * Test changeSex method.
  * This size can't change sex always throws exception.
  */
  @Test(expected=UnsupportedOperationException.class)
  public void changeSexMethodTest()throws UnsupportedOperationException {
    SexChangeable a = new Panuhunuhu();
      a.changeSex();
  }
  
  /** test getReproductiveMode method. */
      @Test public void getReproductiveModeTest() {
      SexChangeable a = new Panuhunuhu();
      Assert.assertTrue("This fish should have protogynous reproductive mode"
            , a.getReproductiveMode().equalsIgnoreCase("protogynous"));
  }
     //****************** Check for ColorChangeable Implementation ***********/
  @Test public void isColorChangeableTest() {
        Panuhunuhu a = new Panuhunuhu();
        Assert.assertTrue(a.getName() + " is not ColorChangeable as required", (a instanceof ColorChangeable));
  }
     /** test setColor method.
  * This size  can't change color always throws exception.
  */
  @Test(expected=UnsupportedOperationException.class)
  public void setColorMethodTest()throws UnsupportedOperationException {
    Panuhunuhu a = new Panuhunuhu();
      a.setColor("purple", "green");
  }
  
 } ///close test clas
