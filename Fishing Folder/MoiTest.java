import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
*
* JUnit test for Moi I'a subclass.
* @author Lisa Miller
* @since 3/11/22
*/

public class MoiTest {
   /** constant reproductive mode for this Ia. */
   static final String REPRODUCTIVE_MODE = "protoandrous";
   /** constant array of what the fish eats. */
   static final String[] DIET_ITEMS = {"crustaceans"};
   /** constant maximum length for this Ia. */
   static final double MAX_LENGTH = 30.0;
   /** constant minimum length for this Ia. 
   */
   static final double MIN_LENGTH = 16.0;


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Constructor with random length test.*/
   @Test public void constructorAndGetterTest(){
      I_a i = new Moi();
      String name = i.getName();
      String engName = i.getEnglishName();
      String sciName = i.getScientificName();
      double length = i.getLength();
      boolean dietOk = false;
      String bodColor = i.getBodyColor();
      String finColor = i.getFinColor();
      String sex = i.getSex();
      
      Assert.assertEquals("Name is not correct. It is " + name + " but should be Moi",
             name, "Moi");
      Assert.assertEquals("English name is not correct. It is " + engName + " but should be Six-fingered threadfin",
             engName, "Six-fingered threadfin");
      Assert.assertEquals("Scientific name is not correct. It is " + sciName + " but should be Polydactylus sexfilis",
             sciName, "Polydactylus sexfilis");
      Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
            + " but should be between " + MIN_LENGTH + " and " + MAX_LENGTH, (length >= MIN_LENGTH && length < MAX_LENGTH));

      Assert.assertEquals("Body color is not correct. It is " + bodColor + " but should be silver", bodColor, "silver");
      Assert.assertEquals("Fin color is not correct. It is " + finColor + " but should be silver with black tips", 
            finColor, "silver with black tips");
      Assert.assertEquals("Fish sex is not correct. It is " + sex + " but should be female", sex, "female");
   
   }
   
   
   /** Constructor with given length test.*/
   @Test public void constructorWLengthAndGetterTest(){
      I_a i = new Moi(16.0);
      String name = i.getName();
      String engName = i.getEnglishName();
      String sciName = i.getScientificName();
      double length = i.getLength();
      boolean dietOk = false;
      String bodColor = i.getBodyColor();
      String finColor = i.getFinColor();
      String sex = i.getSex();
      
      Assert.assertEquals("Name is not correct. It is " + name + " but should be Moi",
             name, "Moi");
      Assert.assertEquals("English name is not correct. It is " + engName + " but should be Six-fingered threadfin",
             engName, "Six-fingered threadfin");
      Assert.assertEquals("Scientific name is not correct. It is " + sciName + " but should be Polydactylus sexfilis",
             sciName, "Polydactylus sexfilis");
      Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
            + " but should be between " + MIN_LENGTH + " and " + MAX_LENGTH, (length >= MIN_LENGTH && length < MAX_LENGTH));

      Assert.assertEquals("Body color is not correct. It is " + bodColor + " but should be silver", bodColor, "silver");
      Assert.assertEquals("Fin color is not correct. It is " + finColor + " but should be silver with black tips", 
            finColor, "silver with black tips");
      Assert.assertEquals("Fish sex is not correct. It is " + sex + " but should be female", sex, "female");
   
   }
   
     /** Constructor with length Exception test.*/
   @Test(expected=FishSizeException.class)
   public void constructorLengthTooLongTest(){
      I_a i = new Moi(41.1);
   }

     /** Constructor with length Exception test.*/
   @Test(expected=FishSizeException.class)
   public void constructorLengthTooShortTest(){
      I_a i = new Moi(7.1);
   }

   /** setLength Exception test.*/
   @Test(expected=FishSizeException.class)
   public void setLengthTooLongTest(){
      I_a i = new Moi();
      i.setLength(41.5);
   }

      /** setLength Exception test.*/
   @Test(expected=FishSizeException.class)
   public void setLengthTooShortTest(){
      I_a i = new Moi();
      i.setLength(6.1);
   }
   
   /**
      Checks fish eats all diet items with no Exception.
    */
   @Test public void eatingDietTest(){
      I_a a = new Moi();
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
    I_a a = new Moi();
    a.eat("raisins");
  }
  
  /**
  * Test grow and eat methods.
  */
  public void growthTest(){
   I_a a = new Moi(1.0);
   double newLen = 0;
   a.eat("crustaceans");
   newLen = a.getLength();
   Assert.assertTrue("Fish does not grow bigger when eating. Start length: 1.0, End length: "
    + newLen, newLen > 1.0);
  }
  
  /**
  * Test need to levelUp from eat method.
  */
  @Test(expected=FishSizeException.class)
  public void growthSizeExceptionTest()throws FishSizeException {
    I_a a = new Moi(11.999);
    boolean tooBig = false;
    while(!tooBig) {
      a.eat("crustaceans");
    }
  }
  
    /**
  * Test levelUp method.
  */

 //  @Test public void levelUpTest() {
//     I_a a = new Moi(29.999);
//     boolean tooBig = false;
//     while(!tooBig) {
//       try {
//          a.eat("crustaceans");
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
//       double leveledUpMinLength = 16.0;
//       
//       Assert.assertEquals("LeveledUp name is not correct. It is " + name + " but should be Moi",
//              name, "Moi");
//       Assert.assertEquals("LeveledUp English name is not correct. It is " + engName + " but should be Six-fingered threadfin",
//              engName, "Six-fingered threadfin");
//       Assert.assertEquals("LeveledUp scientific name is not correct. It is " + sciName + " but should be Polydactylus sexfilis",
//              sciName, "Polydactylus sexfilis");
//       Assert.assertTrue("LeveledUp length is outside allowed limits for this fish. It is " + length 
//             + " but should be between " + leveledUpMinLength + " and " + leveledUpMaxLength, (length >= leveledUpMinLength && length < leveledUpMaxLength));
// 
//       Assert.assertEquals("Body color is not correct. It is " + bodColor + " but should be silver", bodColor, "silver");
//       Assert.assertEquals("Fin color is not correct. It is " + finColor + " but should be silver with black tips", 
//             finColor, "silver with black tips");
//       Assert.assertEquals("Fish sex is not correct. It is " + sex + " but should be female", sex, "female");
//   } //end level up test
  
  /************* Fishable methods tests ****************************/
  //****************** Check for Fishable Implementation ***********/
  @Test public void isFishableTest() {
        Moi a = new Moi();
        Assert.assertTrue(a.getName() + " is not Fishable as required", (a instanceof Fishable));
  }
  //*********** Not yet completed ************
  /** test isLegalSize. */
  @Test public void isLegalSizeTest() {
      Moi a = new Moi();
      double len = a.getLength();
      if(len < 11) {
         Assert.assertEquals("LegalSize is incorrect, fish is too small with length:  " + len
               + " it must be >= 11 to be legal.", false, a.isLegalSize());
      } else {
         Assert.assertEquals("LegalSize is incorrect, fish is legal size with length:  " + len
               + " it legal at 11 inches.", true, a.isLegalSize());
      }
  }
  /** test isBait. */
    @Test public void isBaitTest() {
      Moi a = new Moi();
      Assert.assertEquals("This fish is never used for bait", false, a.isBait());
  }
  
    /** test isGameFish method. */
      @Test public void isGamefishTest() {
      Moi a = new Moi();
      Assert.assertEquals("This fish is used for eating", true, a.isGamefish());
  }
  // test getCatchMethods
  /** test getCatchMethods method. */
      @Test public void getCatchMethodsTest() {
      Moi a = new Moi();
      String[] validCatchMeth = {"net", "pole"};
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
  
  //******************** SexChangeable methods tests **********************************/
    //****************** Check for SexChangeable Implementation ***********/
  @Test public void isSexChangeableTest() {
        Moi a = new Moi();
        Assert.assertTrue(a.getName() + " is not SexChangeable as required", (a instanceof SexChangeable));
  }
    /**
  * Test changeSex method.
  * This size moi can't change sex always throws exception.
  */
  @Test(expected=UnsupportedOperationException.class)
  public void changeSexMethodTest()throws UnsupportedOperationException {
    SexChangeable a = new Moi();
      a.changeSex();
  }
  
  /** test getReproductiveMode method. */
      @Test public void getReproductiveModeTest() {
      SexChangeable a = new Moi();
      Assert.assertEquals("This fish has protoandrous reproductive mode", a.getReproductiveMode(), "protoandrous");
  }
  
 } ///close test clas
