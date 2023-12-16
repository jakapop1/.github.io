import java.util.Random;
/**
* Pua'ama fish object class.
* Smallest type version of fish
* @author Group 1
* @since 10/11/22
*/
public class Pua_ama extends FishableI_a {

   /** constant array of what the fish eats. */
   protected static final String[] dietItems = {"zooplankton", "algae", "detritus",
                                                "invertebrates"};
   /** constant maximum length for this Ia. */
   private static final double puaamaMaxLength = 4.0;
   
   /** constant minimum length for this Ia. */
   private static final double puaamaMinLength = 0.0;

   
   /**.
   * Constructor for making Pua'ama
   */
   public Pua_ama() {
      super("Pua'ama", "Striped Mullet", "Mugil Cephalus", puaamaMaxLength, 
         puaamaMinLength, 0.1, 2.0, dietItems, "silver", "silver", "none");   
      
      this.initLength();
   }
   
   /**.
   * Constructor for making Pua'ama with a specific length
   * @param length of the fish.
   * @throws FishSizeException if length is larger than maxLength or smaller than minLength.
   */
   public Pua_ama(double length) {
      super("Pua'ama", "Striped Mullet", "Mugil cephalus", puaamaMaxLength, puaamaMinLength,
         length, (length * 2), dietItems, "silver", "silver", "none");   
   }
   
   /** 
   * Protected constructor for subclasses.
   *
   *@param name This fish type's Hawaiian name.
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
   protected Pua_ama(String name, double maxLength, double minLength, 
         double length, double weight, String[] diet, String bodyColor,
                String finColor, String sex) {
       
      super(name, "Striped Mullet", "Mugil Cephalus", maxLength, minLength, 
         length, weight, diet, bodyColor, finColor, sex);
   }
   
   /**
   * Sets the fish's initial length to between its max and min allowed values.
   */
   protected void initLength() {
      Random ran = new Random();
      this.length = this.minLength + (this.maxLength - this.minLength) * ran.nextDouble();
      this.weight = this.length * 2;
   }
   
   //************* Superclass required implementations of abstract methods *************
   
   /**
   * Sets the fish's length to newLength.
   * @param newLength the new length of the fish.
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
   * @param newWeight The new weight of the fish.
   */
   public void setWeight(double newWeight) {  
      
      this.weight = newWeight;
   
   }
   
   /**
    * Returns boolean true if the fish is in season, false if not.
    * @param month A String with a month name
    */
   public boolean isInSeason(String month) {
      
      month = month.trim().toLowerCase();
      if (month.equals("april") || month.equals("may") || month.equals("june") 
            || month.equals("july") || month.equals("august") || month.equals("september") 
            || month.equals("october") || month.equals("november")) {
         return true;
      } else {
         return false;
      }
      
   } 
   
   /**
   * Models eating, should call grow to cause length increases.
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
   * Used by eat method to increase length of fish. 
   * Should determine a new length and call setLength
   * @throws FishSizeException if the new length is not within min-max length
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
   
   /** returns new Kahaha version of this fish.
   * When a Pua'ama reaches maxLength, it should levelUp to a Kahaha
   * @return a new Kahaha
   */
   public Kahaha levelUp() {
   
      return new Kahaha(this.maxLength);
   
   }
   
   //============= Required by Fishable ==================
   /** 
   * determines if the fish is legal to keep due to length.
   * @return this fish is a legal size to keep.
   */
   public boolean isLegalSize() { 
      //legal size is 11 inches and up
      if (this.length >= 11) {
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
   * @return fish is edible, and is allowed to be eaten.
   */
   public boolean isGamefish() {
      if (this.isLegalSize()) {
         return true;
      }
      return false;

   }

   /**
   * Returns the maximum number of this fish that can be kept in a bag.
   * @return the bag limit.
   */
   public int getBagLimit() {
      return Integer.MAX_VALUE;
   }
   
  /**
   * Returns the methods of catching this fish.
   * @return an array of fishing methods.
   */
   public String[] getCatchMethods() {
     
   return null;
      
   }
      
} //end of class