import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
* Tests for compareTo, equals.
*
* @author Lisa Miller
* @since 3/20/2022
*/

public class I_aTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

  /**
  * test compareTo method with equal I_a.
  */
   @Test public void compareMoiLiiToMoiLii() {
      I_a i1 = new MoiLi_i(2.0);
      I_a i2 = new MoiLi_i(2.0);
      int diff = i1.compareTo(i2);
      Assert.assertTrue("Moili'i with same length compareTo should return 0 but returned "
             + diff, diff == 0);
   }
   
    /**
  * test compareTo method with equal I_a.
  */
   @Test public void compareUhuToUhu() {
      I_a i1 = new Uhu(12.0);
      I_a i2 = new Uhu(12.0);
      int diff = i1.compareTo(i2);
      Assert.assertTrue("Uhu with same length compareTo should return 0 but returned "
             + diff, diff == 0);
   }
   
       /**
  * test compareTo method with equal I_a.
  */
   @Test public void compareWeke_aToWeke_a() {
      I_a i1 = new Weke_a(12.0);
      I_a i2 = new Weke_a(12.0);
      int diff = i1.compareTo(i2);
      Assert.assertTrue("Weke'a with same length compareTo should return 0 but returned "
             + diff, diff == 0);
   }


  /**
  * test equals method with equal I_a.
  */
   @Test public void equalityOfMoiLiiToMoiLii() {
      I_a i1 = new MoiLi_i(2.0);
      I_a i2 = new MoiLi_i(2.0);
      Assert.assertTrue("Moili'i with same weight should be equal but returned false",
             i1.equals(i2));
   }
   
   /**
   * Test compareTo Moi-Li'i and 'Oama.
   * Okina comes before all letters!
   * So this should indicate Moi-Li'i comes after 'Oama.
   */
   @Test public void compareMoiLiiToOama() {
      I_a i1 = new MoiLi_i(2.0);
      I_a i2 = new Oama(2.0);
      int diff = i1.compareTo(i2);
      Assert.assertTrue("Moili'i compareTo 'Oama with same length should return positive but was "
             + diff, diff > 0);
   }
   
      /**
   * Test compareTo Moi-Li'i and Moi.
   * So this should indicate smaller Moi-Li'i comes before longer Moi.
   */
   @Test public void compareMoiLiiToMoi() {
      I_a i1 = new MoiLi_i();
      I_a i2 = new Moi();
      int diff = i1.compareTo(i2);
   
      Assert.assertTrue("Smaller MoiLi'i compareTo longer Moi should return negative but was "
             + diff, diff < 0);
   }

   /**
   * Test compareTo 'Ohua and 'Oama of same weight.
   * Okina comes before all letters!
   * So this should indicate 'Ohua comes after 'Oama (comparison of h and a).
   */
   @Test public void compareOhuaToOama() {
      I_a i1 = new Ohua(2.0);
      I_a i2 = new Oama(2.0);
      int diff = i1.compareTo(i2);
      Assert.assertTrue("'Ohua with same length compareTo 'Oama should return positive but was "
             + diff, diff > 0);
   }
   
  /**
  * test compareTo method with Wekes.
  */
   @Test public void compareWeke_aToWeke_ula() {
      I_a i1 = new Weke_a(12.0);
      I_a i2 = new Weke_ula(12.0);
      int diff = i1.compareTo(i2);
      Assert.assertTrue("Weke'a with same length compareTo Weke'ula should return negative but was "
             + diff, diff < 0);
   }
   
   /**
   * Test compareTo 'Ohua and 'Oama with longer Oama
   * Okina comes before all letters!
   * So this should indicate 'Ohua comes before 'Oama because shorter.
   */
   @Test public void compareShorterOhuaToLongerOama() {
      I_a i1 = new Ohua(2.0);
      I_a i2 = new Oama(2.76);
      int diff = i1.compareTo(i2);
      Assert.assertTrue("'Ohua with shorter length compareTo 'Oama should return negative but was " 
            + diff, diff < 0);
   }
   
   /**
   * Test compareTo Pua'ama and Moi-Li'i of same length.
   * So this should indicate Pua'ama comes after Moi-Li'i (comparison of P and M).
   */
   @Test public void comparePua_amaToMoiLi_i() {
      I_a i1 = new Pua_ama(2.0);
      I_a i2 = new MoiLi_i(2.0);
      int diff = i1.compareTo(i2);
      Assert.assertTrue("Pua'ama compareTo Moi-Li'i of same length should return positive but was "
             + diff, diff > 0);
   }
   
   
   /**
   * Test compareTo Pua'ama and 'Ama'ama of random length.
   * So this should indicate Pua'ama before 'Ama'ama because it is smaller.
   */
   @Test public void comparePua_amaToAma_ama() {
      I_a i1 = new Pua_ama();
      I_a i2 = new Ama_ama();
      int diff = i1.compareTo(i2);
      Assert.assertTrue("Pua'ama compareTo Ama'ama should return negative but was "
             + diff, diff < 0);
   }
   
      /**
   * Test compare  Pua'ama and 'Ama'ama of random length for equality.
   * So this should always be false because Pua'ama is smaller than 'Ama'ama.
   */
   @Test public void equalsPua_amaToAma_ama() {
      I_a i1 = new Pua_ama();
      I_a i2 = new Ama_ama();
      Assert.assertTrue("Pua'ama should never be equal to Ama'ama but it returned true",
             !(i1.equals(i2)));
   }

}
