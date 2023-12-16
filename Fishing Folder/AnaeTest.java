import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
* JUnit test for Anae I'a subclass.
* @author Lisa Miller
* @since 3/15/22
*/

public class AnaeTest {
   /** constant reproductive mode for this Ia. */
   static final String REPRODUCTIVE_MODE = "serial";
   /** constant array of what the fish eats. */
   static final String[] DIET_ITEMS = {"zooplankton", "algae", "detritus",  "invertebrates"};
   /** constant maximum length for this Ia. */
   static final double MAX_LENGTH = 27.0;
   /** constant minimum length for this Ia. 
   */
   static final double MIN_LENGTH = 12.0;


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Constructor with random length test.*/
   @Test public void constructorAndGetterTest(){
      I_a i = new Anae();
      String name = i.getName();
      String engName = i.getEnglishName();
      String sciName = i.getScientificName();
      double length = i.getLength();
      boolean dietOk = false;
      String bodColor = i.getBodyColor();
      String finColor = i.getFinColor();
      String sex = i.getSex();
      
      Assert.assertTrue("Name is not correct. It is " + name + " but should be 'Anae",
             name.equalsIgnoreCase("'Anae"));
      Assert.assertTrue("English name is not correct. It is " + engName + " but should be Striped mullet",
             engName.equalsIgnoreCase("Striped mullet"));
      Assert.assertTrue("Scientific name is not correct. It is " + sciName + " but should be Mugil Cephalus",
             sciName.equalsIgnoreCase("Mugil Cephalus"));
      Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
            + " but should be between " + MIN_LENGTH + " and " + MAX_LENGTH, (length >= MIN_LENGTH && length < MAX_LENGTH));

      Assert.assertEquals("Body color is not correct. It is " + bodColor + " but should be silver", bodColor, "silver");
      Assert.assertEquals("Fin color is not correct. It is " + finColor + " but should be silver", 
            finColor, "silver");
     Assert.assertTrue("Fish sex is not correct. It is " + sex + " but should be male or female", (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female")));
   
   }
   
   
   /** Constructor with given length test.*/
   @Test public void constructorWLengthAndGetterTest(){
      I_a i = new Anae(12.0);
      String name = i.getName();
      String engName = i.getEnglishName();
      String sciName = i.getScientificName();
      double length = i.getLength();
      boolean dietOk = false;
      String bodColor = i.getBodyColor();
      String finColor = i.getFinColor();
      String sex = i.getSex();
      
      Assert.assertTrue("Name is not correct. It is " + name + " but should be 'Anae",
             name.equalsIgnoreCase("'Anae"));
      Assert.assertTrue("English name is not correct. It is " + engName + " but should be Striped mullet",
             engName.equalsIgnoreCase("Striped mullet"));
      Assert.assertTrue("Scientific name is not correct. It is " + sciName + " but should be Mugil Cephalus",
             sciName.equalsIgnoreCase("Mugil Cephalus"));
      Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
            + " but should be between " + MIN_LENGTH + " and " + MAX_LENGTH, (length >= MIN_LENGTH && length < MAX_LENGTH));

      Assert.assertEquals("Body color is not correct. It is " + bodColor + " but should be silver", bodColor, "silver");
      Assert.assertEquals("Fin color is not correct. It is " + finColor + " but should be silver", 
            finColor, "silver");
      Assert.assertTrue("Fish sex is not correct. It is " + sex + " but should be male or female", (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female")));
   
   }
   
     /** Constructor with length Exception test.*/
   @Test(expected=FishSizeException.class)
   public void constructorLengthTooLongTest(){
      I_a i = new Anae(54.1);
   }

     /** Constructor with length Exception test.*/
   @Test(expected=FishSizeException.class)
   public void constructorLengthTooShortTest(){
      I_a i = new Anae(-0.1);
   }

   /** setLength Exception test.*/
   @Test(expected=FishSizeException.class)
   public void setLengthTooLongTest(){
      I_a i = new Anae();
      i.setLength(45.5);
   }

      /** setLength Exception test.*/
   @Test(expected=FishSizeException.class)
   public void setLengthTooShortTest(){
      I_a i = new Anae();
      i.setLength(-0.1);
   }
   
   /**
      Checks fish eats all diet items with no Exception.
    */
   @Test public void eatingDietTest(){
      I_a a = new Anae();
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
    I_a a = new Anae();
    a.eat("raisins");
  }
  
  /**
  * Test grow and eat methods.
  */
  @Test public void growthTest(){
   I_a a = new Anae(12.0);
      double newLen = 0;
      double oldLen = a.getLength();
      a.eat("algae");
      newLen = a.getLength();
      Assert.assertTrue("Fish does not grow bigger when eating. Start length: " + oldLen
            + ", End length: " + newLen, newLen > oldLen);
  }
  
  /**
  * Test need to levelUp from eat method.
  */
  @Test(expected=FishSizeException.class)
  public void growthSizeExceptionTest()throws FishSizeException {
    I_a a = new Anae(7.999);
    boolean tooBig = false;
    while(!tooBig) {
      a.eat("algae");
    }
  }
  
    /**
  * Test levelUp method.
  * This size shouldn't be able to levelUp.
  * @throws UnsupportedOperationException
  */
//   @Test(expected=UnsupportedOperationException.class)
//   public void levelUpTest()throws UnsupportedOperationException {
//     I_a a = new Anae(25.999);
//     boolean tooBig = false;
//     while(!tooBig) {
//       try {
//          a.eat("algae");
//       } catch (FishSizeException fse) {
//          tooBig = true;
//       }
//     }
//     I_a i = a.levelUp();
//   }
  
  /************* Fishable methods tests ****************************/
      //****************** Check for Fishable Implementation ***********/
  @Test public void isFishableTest() {
        Anae a = new Anae();
        Assert.assertTrue(a.getName() + " is not Fishable as required.", (a instanceof Fishable));
  }
  /** test isLegalSize. */
  @Test public void isLegalSizeTest() {
      Anae a = new Anae();
      Assert.assertEquals("This fish is always legal size >= 11", true, a.isLegalSize());
  }
  /** test isBait. */
    @Test public void isBaitTest() {
      Anae a = new Anae();
      Assert.assertEquals("This fish is never used for bait", false, a.isBait());
  }
  
  /** test isGameFish method. */
      @Test public void isGamefishTest() {
     Anae a = new Anae();
     System.out.println(a);
      Assert.assertEquals("This fish is used for eating", true, a.isGamefish());
  }
  // test getCatchMethods
  /** test getCatchMethods method. */
      @Test public void getCatchMethodsTest() {
      Anae a = new Anae();
      String[] validCatchMeth = {"net", "pole"};
      String[] fishCatchMeth = a.getCatchMethods();
      boolean match = false;
      for(int i = 0; i < validCatchMeth.length; i++){
         for(int j= 0; j < fishCatchMeth.length; j++){
            if(validCatchMeth[i].equalsIgnoreCase(fishCatchMeth[j])){
               match = true;
            }
         
         }
         Assert.assertTrue(a.getName() + "is missing "+ validCatchMeth[i] + "as a catch method", match);
         match = false;
      }
      
  }
    
 } ///close test clas
