import java.util.Random;
/**
* Ohua fish object class.
* Smallest type version of Ohua fish
* Parent class to Panuhunuhu.
* @author Group 2
*
* @since 10/01/22
*/
public class Ohua extends FishableI_a implements  SexChangeable, ColorChangeable {

   /** constant reproductive mode for this Ia. */
   protected static final String reproductiveMode = "Protogynous";
   
   /** constant array of what the fish eats. */
   protected static final String[] dietItems = {"Crustaceans", "algae"};
   
   /** constant maximum length for this Ia. */
   private static final double ohuaMaxLength = 4.0;
   
   /** constant minimum length for this Ia. */
   private static final double ohuaMinLength = 0.1;

   /**
   * Constructor for making Ohua with random length.
   * This is the second phase of the species.
   * @throws FishSizeException if length exceeds maxLength or is less than minLength
   */
   public Ohua() {
      super("'Ohua", "Parrotfish", "Scaridae", ohuaMaxLength, ohuaMinLength, 0.1, 2.0, 
         dietItems, "Gray", "Gray", "none"); 
      
      this.initLength();  
   }
   
   /**
   * Constructor for making MoiMana with a given length 
   * Randomly sets length within allowed values after calling constructor.
   * This is the second phase of the species.
   * @param length of this fish.
   * @throws FishSizeException if length exceeds maxLength or is less than minLength
   */
   public Ohua(double length) {
      super("'Ohua", "Parrotfish", "Scaridae", ohuaMaxLength, ohuaMinLength, 
         length, (length * 2), dietItems, "Gray", "Gray", "none"); 
   
   }
   
   /**
   * Protected constructor for subclasses.
   *
   *@param name This fish type's Hawaiian name.
   *@param englishName The fish type's english name.
   *@param scientificName The fish type's scientific name.
   *@param maxLength The maximum length this name applies.
   *@param minLength The minimum length this name applies.
   *@param length This fish's size.
   *@param weight This fish's weight. 
   *@param diet The diet preference of this fish type.
   *@param bodyColor The body color of this fish.
   *@param finColor The fin color of this fish.
   *@param sex The sex of this fish.
   *@throws FishSizeException if length exceeds maxLength or is less than minLength
   */
   protected Ohua(String name, String englishName, String scientificName, double maxLength, 
         double minLength, double length, double weight, String[] diet, String bodyColor, 
         String finColor, String sex) {
       
      super(name, englishName, scientificName, maxLength, minLength, length, weight, 
            diet, bodyColor, finColor, sex);
      this.initSex();
   }
   
   /**
   * Sets the fish's initial length to between its max and min allowed values.
   */
   protected void initLength() {
      Random ran = new Random();
      this.length = this.minLength + (this.maxLength - this.minLength) * ran.nextDouble();
      this.weight = this.length * 2;
   }
   
   /**
   * Sets the fish's length to newLength.
   * @param newLength of the fish. 
   * @throws FishSizeException if the new length is not within min-max length for type
   */
   public void setLength(double newLength) throws FishSizeException {  
      if (newLength >= this.minLength && newLength < this.maxLength) {
         this.length = newLength;
      } else {
         throw new FishSizeException(this.name + " must be within " + this.minLength 
               + " and " + this.maxLength + " inches long.");
      } 
   }
   
   /**
   * Sets the fish's weight to newWeight.
   * @param newWeight of fish. 
   */
   public void setWeight(double newWeight) {
      this.weight = newWeight;
   }
   
   /**
   * Models eating, should call grow under certain conditions.
   * @param food A String with a food name
   * @throws FishFoodException if the food is not the fish's diet
   */
   public void eat(String food) {
      boolean isEdible = false;
      
      for (int i = 0; i < dietItems.length; i++) {
         if (food.equals(dietItems[i])) {
            isEdible = true;
         }
      }
      if (isEdible) {
         this.grow();
      } else {
         throw new FishFoodException(this.name + " does not eat " + food);
      }
   }

   /**
   * Should be used by eat method to increase length of fish. 
   * Should determine a new length and internally call setLength.
   * @throws FishSizeException if the new length is not within min-max length for type
   */
   protected void grow() {
      Random ran = new Random();
      double lengthIncrease = ran.nextDouble() * growthRate;
   
      double newLen = this.length + lengthIncrease;
      
      if (newLen > this.maxLength) {
         throw new FishSizeException("This fish has outgrown its name, it must level up!");
      } else {
         this.length = newLen;
         this.weight = 2 * newLen; 
      }
   }
   
   /** returns new I_a of next level.
   * When a fish reaches maxSize, it should transform to panuhunuhu.
   * @return a new I_a of the next level type
   */
   public Panuhunuhu levelUp() {
   
      return new Panuhunuhu(this.maxLength);
   
   }
   
   //********* Protected class method *********
   /** 
   * determines if the fish is legal to keep due to length.
   * @return true If this fish is legal size to keep.
   */
   public boolean isLegalSize() {
      if (this.length >= 12) { //12" is the legal size for 'Ohua
         return true;
      } else {
         return false;
      } 
   }
   
   /**
   * determines if this fish can be used as a baitfish.
   * @return true if this fish type is used for bait for other fishing.
   */
   public boolean isBait() {
      return false;
   }
   
   /**
   * determines if this fish can be used to eat.
   * @return true if this fish is edible, and allowed to be eaten.
   */
   public boolean isGamefish() {
      if (isLegalSize() == true) {
         return true;
      } else {
         return false;
      }
   }

   /* Determines if the fish is in season.
    * @returns the methods of catching this fish.
    */
   public boolean isInSeason(String month){
      return true;
   }
   
   /**
   * Returns the methods of catching this fish.
   * @return an array of fishing methods.
   */
   public String[] getCatchMethods() {
      if (isGamefish() == true) {
      String[] methods = {"throw net", "spear", "pole"};
      return methods;
      } else {
      return null;
      }
   }
   
   //********* required by SexChangable interface *********
   
   /** 
   * changes Ohua's sex.
   */
   public void changeSex() {
      throw new UnsupportedOperationException("Ohua cannot change sex.");
   }
   
   /**
   * returns the reproductive mode of this sex changing fish.
   * @return reproductiveMode sex of the fish.
   */
   public String getReproductiveMode() {
      return reproductiveMode;
   }
  
   //********* Protected class method *********
   
   /** initialize random fish sex.
   * choose randomly male or female.
   * used by some subclasses.
   */
   protected void initSex() {
   
      Random ran = new Random();
      int flip = ran.nextInt(2);
      
      if (flip == 0) {
         this.sex = "male";
      } else {
         this.sex = "female";
      }
   }
   
   /**
   * Returns the bag limit of this fish.
   * @return the bag limit of this fish.
    */
   public int getBagLimit() {
      
      return Integer.MAX_VALUE;
   }

   /** Required By ColorChangeable Interface **/
   
   /**
   * Sets fish's color. 
   * @param bodyColor Color of the fish's body.
   * @param finColor Of fish.
   * @returns String bodyColor.
   * @returns String finColor.
   */

   public void setColor(String bodyColor, String finColor)  {
      throw new UnsupportedOperationException("Ohua cannot change colors.");
   }
   
} //end of class

