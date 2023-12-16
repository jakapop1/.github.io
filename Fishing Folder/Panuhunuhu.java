/**
* Panuhunuhu object class.
* This is the second phase of life.
* @author Group 1.
* @since 10/11/22
*/

public class Panuhunuhu extends Ohua {

   /** constant maximum length for this Ia. */
   private static final double panuhunuhuMaxLength = 12.0;
   
   /** constant minimum length for this Ia. */
   private static final double panuhunuhuMinLength = 4.0;
   
   /** constant sex for this Ia. */
   protected static String sex;
   
   /**
   * Constructor for making Panuhunuhu with random length.
   * randomly sets length within allowed values after calling constructor.
   * This is the second phase of the species.
   * @throws FishSizeException if length exceeds maxLength or is less than minLength
   */
   public Panuhunuhu() {
      super("Panuhunuhu", "Parrotfish", "Scaridae", panuhunuhuMaxLength, panuhunuhuMinLength, 
            panuhunuhuMinLength, panuhunuhuMinLength, dietItems, "gray", "gray", sex); 
      
      this.initLength();  
   }
   
   /**
   * Constructor for making Panuhunuhu with a given length.
   * This is the second phase of the species.
   * @param length of the fish.
   * @throws FishSizeException if length exceeds maxLength or is less than minLength
   */
   public Panuhunuhu(double length) {
   
      super("Panuhunuhu", "Parrotfish", "Scaridae", panuhunuhuMaxLength, panuhunuhuMinLength, 
            length, length * 2, dietItems,  "gray", "gray", sex); 
     
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
   protected Panuhunuhu(String name, String englishName, String scientificName, double maxLength,
                        double minLength, double length, double weight, String[] diet, 
                        String bodyColor, String finColor, String sex) {
       
      super("Uhu", "Parrotfish", "Scarus psittacus", maxLength, minLength, 
         length - 2, weight, diet, "gray", finColor, sex);
   }
     
   /** returns new I_a of next level.
   * When a fish reaches maxLength, it should transform to Uhu.
   * @return a new I_a of the next level type
   */
   public Uhu levelUp() {
   
      return new Uhu(this.maxLength * 1.5);
   }

} //end class