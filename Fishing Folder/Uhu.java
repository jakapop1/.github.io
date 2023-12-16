/**
* Uhu object class.
* This is the third phase and final phase of fish family.
* @author Group 1.
* @since 10/11/22
*/

public class Uhu extends Panuhunuhu {
   /** constant reproductive mode for this Ia. */
   private static final String reproductiveMode = "protogynous";
   
   /** constant array of what the fish eats. */
   private static final String[] dietItems = {"algae"};
   
   /** constant maximum length for this Ia. */
   private static final double uhuMaxLength = 30.0;
   
   /** constant minimum length for this Ia. */
   private static final double uhuMinLength = 12.0;

   /**
   * Constructor for making Panuhunuhu with random length.
   * randomly sets length within allowed values after calling constructor.
   * This is the second phase of the species.
   * @throws FishSizeException if length exceeds maxLength or is less than minLength
   */
   public Uhu() {
      super("Uhu", "Parrotfish", "Scaridae psittacus", uhuMaxLength, uhuMinLength, 
         uhuMinLength * 1.5, (uhuMinLength * 2), dietItems, "white with yellow stripe",
         "gray", sex); 
      //method is in superclass but will use max, min length set above
      this.initLength();  
   
   }
   
   /**
   * Constructor for making Panuhunuhu with a given length.
   * This is the second phase of the species.
   * @param length of the fish.
   * @throws FishSizeException if length exceeds maxLength or is less than minLength
   */
   public Uhu(double length) {
      super("Uhu", "Parrotfish", "Scaridae psittacus", uhuMaxLength, uhuMinLength, 
         length, (length * 2), dietItems, "white with yellow stripe", "gray", sex); 
   }
 
   /** returns itself.
   * Uhu don't level up, this is the terminal type.
   * @return a new I_a of the next level type, should replace caller
   */
   public Uhu levelUp() {
      return this;
   }
   
   //********* required by SexChangable interface *********
   
   /** 
   * changes Ohua's sex.
   */
   public void changeSex() {
      throw new UnsupportedOperationException("Uhu cannot change sex.");
   }
   
   /**
   * returns the reproductive mode of this sex changing fish.
   * @return reproductiveMode sex of the fish.
   */
   public String getReproductiveMode() {
      return reproductiveMode;
   }
 
   public void setColor(String bodyColor, String finColor)  {
   }
   
} //end of class