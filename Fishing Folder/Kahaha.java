/**
*
* Kahaha object class.
* This is the second phase of fish family.
* @author Group 2.
* @since 10/11/22
*/
public class Kahaha extends Pua_ama {

   /** constant array of what the fish eats. */
   protected static final String[] dietItems = {"zooplankton", "algae", 
                                                "detritus", "invertebrates"};

   /** constant maximum length for this Ia. */
   private static final double kahahaMaxLength = 8.0;
   
   /** constant minimum length for this Ia. */
   private static final double kahahaMinLength = 4.0;  
 
   /**
   * Constructor for making Kahaha with random length. 
   * This is the second phase of the fish family
   * @throws FishSizeException if length exceeds maxLength or is less than minLength
   * Must send minLength through as a temp length or throws exception
   */
   public Kahaha() {
      super("Kahaha", kahahaMaxLength, kahahaMinLength, 
         kahahaMinLength, (kahahaMinLength * 2), dietItems, "silver", "silver", "female"); 
      
      this.initLength();
   }
   
   /**
   * Constructor for making Kahaha with a given length 
   * This is the second phase of the species.
   * @param length of the species.
   * @throws FishSizeException if length exceeds maxLength or is less than minLength
   */
   public Kahaha(double length) {
      super("Kahaha", kahahaMaxLength, kahahaMinLength, length, (length * 2), 
         dietItems, "silver", "silver", "female");   
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
   *@throws FishSizeException if length exceeds maxLength or is less than minLength.
   */
   protected Kahaha(String name, double maxLength, double minLength, 
         double length, double weight, String[] diet, String bodyColor,
                String finColor, String sex) {
       
      super(name, maxLength, minLength, 
         length, weight, diet, bodyColor, finColor, "female");
   }
   
    /** returns new 'Ama'ama version of this fish.
   * @return a new 'Ama'ama
   */
   public Ama_ama levelUp() {
   
      return new Ama_ama(this.maxLength);
   
   }


} //end of class
   
