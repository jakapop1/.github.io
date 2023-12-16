import java.util.Random;
/**
* Oama object class.
* Smallest type of Oama fish
* Parent class to Weke'a
*
* @author Group 2
* @since 9/30/22
*/
public class Oama extends FishableI_a implements ColorChangeable {
   
   /** constant reproductive mode for this Ia. */
   protected static final String reproductiveMode = "serial";
   
   /** constant reproductive mode for this Ia. */   
   protected static final String[] dietItems = {"worms", "invertebrates", "mollusks"};
   
   /** constant max length for this Ia. */
   private static final double oamaMaxLength = 7.0;
   
   /** constant min length for this Ia. */
   private static final double oamaMinLength = 0.1;
   
    /**
   * Constructor for making Oama
   * utilized I_a superclass constructor
   * randomly sets length.
   * Juvenile of species.
   */
   public Oama() {
      super("'Oama", "Goatfish", "Mulloidichthys", oamaMaxLength, 
         oamaMinLength, 0.1, 2.0, dietItems, "white with yellow stripe", 
         "yellow", "none");
      this.initLength();
   }   
   /**
   * Constructor for making Oama with a specific length.
   * uses I_a superclass constructor
   * @throws FishSizeException if length is larger than maxLength 
   * Juvinile of species.
   * @param length of fish.
   */
   public Oama(double length) {
      super("'Oama", "Goatfish", "Mulloidichthys", 
         oamaMaxLength, oamaMinLength, length, (length * 2), dietItems, 
         "white with yellow stripe", "yellow", "none");
   
   }

   /*
   *Protected constructor for subclasses.
   *
   *@param name This fish type's Hawaiian name.
   *@param englishName The fish's English name.
   *@param scientificName The fish's Scientifc name.
   *@param maxLength The maximum length this name applies.
   *@param minLength The minimum length this name applies.
   *@param length This fish's size.
   *@param weight This fish's weight.
   *@param diet The diet preference of this fish type.
   *@param bodyColor The body color of this fish.
   *@param finColor The fin color.
   *@param sex The sex of this fish.
   *@throws FishSizeException if length exceeds maxLength or is less than minLength
   */
   protected Oama(String name, String englishName, String scientificName, 
         double maxLength, double minLength, double length, double weight, 
         String[] diet, String bodyColor, String finColor, String sex) {
       
      super(name, englishName, scientificName, maxLength, minLength, 
         length, weight, diet, bodyColor, finColor, sex);
     
      this.initSex();
   }
   
   /**
   * Sets the fish's initial length to between its max and min allowed values.
   */
   protected void initLength() {
      Random ran = new Random();
      this.length = this.minLength + (this.maxLength 
         - this.minLength) * ran.nextDouble();
      this.weight = this.length * 2;
   }

                                          
   /** Super Class Required **/
   
   /**
   * Sets the fish's length to newLength.
   * @param newLength of fish.
   * @throws FishSizeException if the new length is not within min-max
   */
   public void setLength(double newLength) throws FishSizeException {  
      if (newLength >= this.minLength && newLength < this.maxLength) {
         this.length = newLength;
      } else {
         throw new FishSizeException(this.name 
            + " must be within " + this.minLength 
               + " and " + this.maxLength + " inches long.");
      } 
   }
   
   /**
   * Sets weight to newWeight. 
   * @param newWeight Weight of fish.
   */
   public void setWeight(double newWeight) {  
      
      this.weight = newWeight;
   }
   
   /**
   * Calls grow to change size.
   * @param food String
   * @throws FishFoodException if the food is not the fish's diet
   */
   public void eat(String food) {
     
      boolean isEdible = false;
      //loop through what fish eats and determine if edible
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
   * Increases length of fish. 
   * @throws FishSizeException if the new length 
   */
   protected void grow() {
      Random ran = new Random();
      double lengthIncrease = ran.nextDouble() * growthRate;
   
      //calculate a new length by adding a random value between 0 and growthRate
      double newLen = this.length + lengthIncrease;
   
      //check to see if this fish needs to level up
      if (newLen > this.maxLength) {
         throw new 
            FishSizeException("This fish has outgrown its name, it must level up!");
      } else {
         this.length = newLen;
         this.weight = 2 * newLen; //rudimentary weight calc
      
      }
   }
   
    /** Returns new Weke_a or Weke_ula version of this fish.
   * When a 'Oama reaches maxLength, it should levelUp to a Weke'a or Weke'ula of min length.
   * Min size of next size is always max length of this one
   * @return a new Weke_a or Weke_ula 
   */
   public Oama levelUp() {
      Random randomGenerate = new Random();
      boolean number = randomGenerate.nextBoolean();
      
      if (number == false) {
         return new Weke_a(this.maxLength);
      
      } else {
         return new Weke_ula(this.maxLength);
      }
   }
   
   /** Required By Fishable **/
   /*  Always in season.
    *  @return true if this fish is in season.
    */
   public boolean isInSeason(String month) {
      return true;

   }


   /** 
   * determines if the fish is legal to keep due to length.
   * @return true If this fish is legal size to keep.
   */
   public boolean isLegalSize() {
      return true;
   }
   
   /**
   * determines if this fish can be used as a baitfish.
   * @return true if this fish type is used for bait for other fishing.
   */
   public boolean isBait() {
      return true;
   }
   
   /**
   * determines if this fish can be used to eat.
   * @return true if this fish is edible, and allowed to be eaten.
   */
   public boolean isGamefish() {
      return true;
   } 
   
   /**
   * Returns the methods of catching this fish.
   * @return an array of fishing methods.
   */
   public String[] getCatchMethods() {
      String[] catchMethods = {"net", "trap", "pole"};
      return catchMethods; 
   }
   
   
   /*********** Required By ColorChangeable Interface ***********
   
   /**
   * Sets fish's color. 
   * @param bodyColor Color of the fish's body.
   * @param finColor Of fish.
   * @returns String bodyColor.
   * @returns String finColor.
   */
   public void setColor(String bodyColor, String finColor) throws UnsupportedOperationException {
      this.bodyColor = bodyColor;
      this.finColor = finColor; 
      throw new UnsupportedOperationException();
      
   }   
   /**
    * Returns the limit on the number of Oama that can be caught. 
    * @return the limit on the number of Oama that can be caught.
    */
    public int getBagLimit() {
      return 50; 

    }
   
   //*********** Protected class method ***********
   
   /** initialize random fish sex
   * choose randomly male or female
   * used by some subclasses.
   */
   protected void initSex() {
      //randomize sex
      Random ran = new Random();
      int flip = ran.nextInt(2);
      
      if (flip == 0) {
         this.sex = "male";
      } else {
         this.sex = "female";
      }
   }

} //end class
   