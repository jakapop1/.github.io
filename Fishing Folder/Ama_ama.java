/**
* Ama'ama object class.
* This is the third phase of fish family.
* @author Group 1.
* @since 10/11/22
*/
public class Ama_ama extends Kahaha {
   
   /** constant array of what the fish eats. */
   protected static final String[] dietItems = {"zooplankton", "algae", 
                                                "detritus", "invertebrates"};
   /** constant maximum length for this Ia. */
   private static final double amaamaMaxLength = 12.0;
   
   /** constant minimum length for this Ia. */
   private static final double amaamaMinLength = 8.0;
 
   /**
   * Constructor for making Ama'ama with random length 
   * This is the third phase of the species.
   * @throws FishSizeException if length exceeds maxLength or is less than minLength
   * Must send minLength through as a temp length or throws exception
   */
   public Ama_ama() {
      super("'Ama'ama", amaamaMaxLength, amaamaMinLength,
         amaamaMinLength, (amaamaMinLength * 2), dietItems, "silver", "silver", "none");   
      
      this.initLength();
   }
   
   /**
   * Constructor for making Ama'ama with a given length.
   * This is the third phase of the species.
   * @param length of the species.
   * @throws FishSizeException if length exceeds maxLength or is less than minLength
   */
   public Ama_ama(double length) {
      super("'Ama'ama", amaamaMaxLength, amaamaMinLength, length, (length * 2), 
         dietItems, "silver", "silver", "none");   
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
   protected Ama_ama(String name, double maxLength, double minLength, 
         double length, double weight, String[] diet, String bodyColor,
         String finColor, String sex) {
       
      super(name, maxLength, minLength, 
         length, weight, diet, bodyColor, finColor, sex);
   }
   
   /** returns new version of this fish.
   * When a 'Ama'ama reaches maxLength, it should levelUp to a Anae
   * @return a new Anae
   */
   public Anae levelUp() {
   
      return new Anae(this.maxLength);
   
   }
   
   /**
   * Returns the methods of catching this fish.
   * Overridden because fish becomes legal size at this stage
   * @return an array of fishing methods.
   */
   public String[] getCatchMethods() {
     
         String[] methods = {"net", "pole"};
         return methods;

      }
      
   

} //end of class
   
