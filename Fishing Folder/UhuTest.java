import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
* JUnit test for Uhu I'a subclass.
* @author Lisa Miller
* @since 3/15/22
*/

public class UhuTest {
   /** constant reproductive mode for this Ia. */
   static final String REPRODUCTIVE_MODE = "protogynous";
   /** constant array of what the fish eats. */
   static final String[] DIET_ITEMS = {"algae"};
   /** constant maximum length for this Ia. */
   static final double MAX_LENGTH = 30.0;
   /** constant minimum length for this Ia. 
   */
   static final double MIN_LENGTH = 12.0;


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Constructor with random length test.*/
   @Test public void constructorAndGetterTest(){
      I_a i = new Uhu();
      String name = i.getName();
      String engName = i.getEnglishName();
      String sciName = i.getScientificName();
      double length = i.getLength();
      boolean dietOk = false;
      String bodColor = i.getBodyColor();
      String finColor = i.getFinColor();
      String sex = i.getSex();
      
      Assert.assertTrue("Name is not correct. It is " + name + " but should be Uhu",
             name.equalsIgnoreCase("Uhu"));
      Assert.assertTrue("English name is not correct. It is " + engName + " but should be Parrotfish",
             engName.equalsIgnoreCase("Parrotfish"));
      Assert.assertTrue("Scientific name is not correct. It is " + sciName + " but should be Scarus psittacus",
             sciName.equalsIgnoreCase("Scarus psittacus"));
      Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
            + " but should be between " + MIN_LENGTH + " and " + MAX_LENGTH, (length >= MIN_LENGTH && length < MAX_LENGTH));

     Assert.assertTrue("Body color is not correct. It is " + bodColor + " but should be gray or blue-green", 
            (bodColor.equalsIgnoreCase("gray") || bodColor.equalsIgnoreCase("blue-green")));
      Assert.assertTrue("Fin color is not correct. It is " + finColor + " but should be gray or reddish gray", 
            (finColor.equalsIgnoreCase("gray") || finColor.equalsIgnoreCase("reddish gray")|| finColor.equalsIgnoreCase("blue") ));
      Assert.assertTrue("Fish sex is not correct. It is " + sex + " but should be male or female or supermale", (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female") || sex.equalsIgnoreCase("supermale")));
   
   }
   
   
   /** Constructor with given length test.*/
   @Test public void constructorWLengthAndGetterTest(){
      I_a i = new Uhu(15.0);
      String name = i.getName();
      String engName = i.getEnglishName();
      String sciName = i.getScientificName();
      double length = i.getLength();
      boolean dietOk = false;
      String bodColor = i.getBodyColor();
      String finColor = i.getFinColor();
      String sex = i.getSex();
      
      Assert.assertTrue("Name is not correct. It is " + name + " but should be Uhu",
             name.equalsIgnoreCase("Uhu"));
      Assert.assertTrue("English name is not correct. It is " + engName + " but should be Parrotfish",
             engName.equalsIgnoreCase("Parrotfish"));
      Assert.assertTrue("Scientific name is not correct. It is " + sciName + " but should be Scarus psittacus",
             sciName.equalsIgnoreCase("Scarus psittacus"));
      Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
            + " but should be between " + MIN_LENGTH + " and " + MAX_LENGTH, (length >= MIN_LENGTH && length < MAX_LENGTH));

    Assert.assertTrue("Body color is not correct. It is " + bodColor + " but should be gray or blue-green", 
            (bodColor.equalsIgnoreCase("gray") || bodColor.equalsIgnoreCase("blue-green")));
      Assert.assertTrue("Fin color is not correct. It is " + finColor + " but should be gray or reddish gray", 
            (finColor.equalsIgnoreCase("gray") || finColor.equalsIgnoreCase("reddish gray")|| finColor.equalsIgnoreCase("blue") ));
      Assert.assertTrue("Fish sex is not correct. It is " + sex + " but should be male or female or supermale", (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female") || sex.equalsIgnoreCase("supermale")));
   }
   
     /** Constructor with length Exception test.*/
   @Test(expected=FishSizeException.class)
   public void constructorLengthTooLongTest(){
      I_a i = new Uhu(222.1);
   }

     /** Constructor with length Exception test.*/
   @Test(expected=FishSizeException.class)
   public void constructorLengthTooShortTest(){
      I_a i = new Uhu(-0.1);
   }

   /** setLength Exception test.*/
   @Test(expected=FishSizeException.class)
   public void setLengthTooLongTest(){
      I_a i = new Uhu();
      i.setLength(122.5);
   }

      /** setLength Exception test.*/
   @Test(expected=FishSizeException.class)
   public void setLengthTooShortTest(){
      I_a i = new Uhu();
      i.setLength(-0.1);
   }
   
   /**
      Checks fish eats all diet items with no Exception.
    */
   @Test public void eatingDietTest(){
      I_a a = new Uhu();
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
    I_a a = new Uhu();
    a.eat("raisins");
  }
  
  /**
  * Test grow and eat methods.
  */
  public void growthTest(){
   I_a a = new Uhu(8.0);
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
    I_a a = new Uhu(11.999);
    boolean tooBig = false;
    while(!tooBig) {
      a.eat("algae");
    }
  }
  
    /**
  * Test levelUp method.
  */

//   @Test public void levelUpTest() {
//     I_a a = new Uhu(29.999);
//     boolean tooBig = false;
//     while(!tooBig) {
//       try {
//          a.eat("algae");
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
//       double leveledUpMinLength = 12.0;
//       
//       Assert.assertTrue("Name is not correct. It is " + name + " but should be Uhu",
//              name.equalsIgnoreCase("uhu"));
//       Assert.assertTrue("English name is not correct. It is " + engName + " but should be Parrotfish",
//              engName.equalsIgnoreCase("Parrotfish"));
//       Assert.assertTrue("Scientific name is not correct. It is " + sciName + " but should be Scarus psittacus",
//              sciName.equalsIgnoreCase("Scarus psittacus"));
//       Assert.assertTrue("Length is outside allowed limits for this fish. It is " + length 
//             + " but should be between " + leveledUpMinLength + " and " + leveledUpMaxLength, (length >= leveledUpMinLength && length < leveledUpMaxLength));
// 
//       Assert.assertEquals("Body color is not correct. It is " + bodColor + " but should be gray", bodColor, "gray");
//       Assert.assertTrue("Body color is not correct. It is " + bodColor + " but should be gray or blue-green", 
//             (bodColor.equalsIgnoreCase("gray") || bodColor.equalsIgnoreCase("blue-green")));
//       Assert.assertTrue("Fin color is not correct. It is " + finColor + " but should be gray or reddish gray", 
//             (finColor.equalsIgnoreCase("gray") || finColor.equalsIgnoreCase("reddish gray")|| finColor.equalsIgnoreCase("blue") ));
//       Assert.assertTrue("Fish sex is not correct. It is " + sex + " but should be male or female or supermale", (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female") || sex.equalsIgnoreCase("supermale")));
//   } //end level up test
  
  /************* Fishable methods tests ****************************/
  //****************** Check for Fishable Implementation ***********/
  @Test public void isFishableTest() {
        Uhu a = new Uhu();
        Assert.assertTrue(a.getName() + " is not Fishable as required", (a instanceof Fishable));
  }
  //*********** Not yet completed ************
  /** test isLegalSize. */
  @Test public void isLegalSizeTest() {
      Uhu a = new Uhu();
      double len = a.getLength();
      if(len < 12) {
         Assert.assertEquals("isLegalSize is incorrect, fish is too small with length:  " + len
               + " it must be >= 12 to be legal.", a.isLegalSize(), false);
      } else {
         Assert.assertEquals("isLegalSize is incorrect, fish is legal size with length:  " + len
               + " it legal at 12 inches.", a.isLegalSize(), true);
      }
  }
  /** test isBait. */
    @Test public void isBaitTest() {
      Uhu a = new Uhu();
      Assert.assertEquals("This fish is never used for bait", a.isBait(), false);
  }
  
  /** test isGameFish method. */
      @Test public void isGamefishTest() {
      Uhu a = new Uhu();
      Assert.assertEquals("This fish is used for eating", true, a.isGamefish());
  }
  // test getCatchMethods
  /** test getCatchMethods method. */
      @Test public void getCatchMethodsTest() {
      Uhu a = new Uhu();
      String[] validCatchMeth = {"throw net", "spear", "pole"};
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
        Uhu a = new Uhu();
        Assert.assertTrue(a.getName() + " is not SexChangeable as required", (a instanceof SexChangeable));
  }
    /**
  * Test changeSex method.
  * Uhu female can change sex to supermale.
  */
  @Test
  public void changeSexMethodTest(){
    Uhu a = new Uhu(20.1);
    int counter = 0; //to prevent infinite loop if sex never female
    while((a.getSex().equals("male") || a.getSex().equals("supermale")) && counter < 50) {
      a = new Uhu(20.1);
      counter++;
    }
    //once get female, change sex to supermale.
    if(a.getSex().equals("female") && a.getLength() > 20) {
      System.out.println(a);
      a.changeSex();
       Assert.assertTrue("Uhu female cannot changeSex to supermale as required", a.getSex().equalsIgnoreCase("supermale"));

    }
    
  //  Assert.assertTrue("Uhu female cannot changeSex to supermale as required", a.getSex().equalsIgnoreCase("supermale"));
  }
  
  /** test getReproductiveMode method. */
      @Test public void getReproductiveModeTest() {
      SexChangeable a = new Uhu();
      Assert.assertTrue("This fish should have protogynous reproductive mode"
      , a.getReproductiveMode().equalsIgnoreCase("protogynous"));
  }
       //****************** Check for ColorChangeable Implementation ***********/
  @Test public void isColorChangeableTest() {
        Uhu a = new Uhu();
        Assert.assertTrue(a.getName() + " is not ColorChangeable as required", (a instanceof ColorChangeable));
  }
  /** test setColor method.
  * 
  */
  @Test
  public void setColorMethodTest(){
    Uhu a = new Uhu();
    if(a.getSex().equalsIgnoreCase("supermale")){
      a.setColor("blue-green", "blue");
      Assert.assertTrue("Uhu setColor method is not correct for supermale", 
      (a.getBodyColor().equalsIgnoreCase("blue-green") && a.getFinColor().equalsIgnoreCase("Blue")));
    }else if(a.getSex().equalsIgnoreCase("male")){
      a.setColor("blue-green", "blue");
      Assert.assertTrue("Uhu setColor method is not correct for male", 
      (a.getBodyColor().equalsIgnoreCase("gray") && (a.getFinColor().equalsIgnoreCase("gray") 
      || a.getFinColor().equalsIgnoreCase("reddish-gray"))));
    }else{
      a.setColor("blue-green", "blue");
      Assert.assertTrue("Uhu setColor method is not correct for female", 
      (a.getBodyColor().equalsIgnoreCase("gray") && (a.getFinColor().equalsIgnoreCase("gray") 
      || a.getFinColor().equalsIgnoreCase("reddish-gray"))));  
      
    }

  }
  
 } ///close test clas
