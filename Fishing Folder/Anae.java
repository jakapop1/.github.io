/**
* Anae object class.
* This is the final fish.
* @author Group 1.
* @since 10/11/22
*/
public class Anae extends Ama_ama {
   
   /** constant maximum length for this Ia. */
   private static final double anaeMaxLength = 27.0;
   
   /** constant minimum length for this Ia. */
   private static final double anaeMinLength = 12.0;
   
 
   /**
   * Constructor for making Anae with random length.
   * This is the fourth phase of the family fish.
   * @throws FishSizeException if length is less than minLength
   */
   public Anae() {
      super("'Anae", anaeMaxLength, anaeMinLength, 
         anaeMinLength, (anaeMinLength * 2), dietItems, "silver", "silver", "none");   
         
      this.initLength();
   }
   
   /**
   * Constructor for making Anae with a given length. 
   * This is the fourth phase of the family fish.
   * @param length of the fish.
   * @throws FishSizeException if length is less than minLength
   */
   public Anae(double length) {
      super("'Anae", anaeMaxLength, anaeMinLength, length, (length * 2), 
         dietItems, "silver", "silver", "none");  
   
   }
    
   /** returns the Anae.
   * @return this is the final fish, no levelUp.
   */
   public Anae levelUp() {
   
      return this;
   
   }
   
} //end of class
   
