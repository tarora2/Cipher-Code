import org.junit.Test;
import junit.framework.TestCase;

/**
 * Program to test Cipher
 *
 * @author Tushar Arora
 */
public class CipherTest extends TestCase {

    public static final String LINE1_DECODED = "Pop Quiz Today!";    
    public static final String LINE1_ENCODED = "PpQi oa!o uzTdy";

    public static final String LINE2_DECODED = "My age is: 23";
	public static final String LINE2_ENCODED = "M g s 3yaei:2";

	public static final String LINE3_DECODED = "@# %  &    *";
	public static final String LINE3_ENCODED = "@  &  #%   *";

	public static final String LINE4_DECODED = "Password:-Randon";
	public static final String LINE4_ENCODED = "P:a-sRsawnodrodn";

	public static final String LINE5_DECODED = "Equivalence + Classes";
	public static final String LINE5_ENCODED = "Euvlne+Cassqiaec  lse";

	public static final String LINE6_DECODED = "[ ] ( ) { }";
	public static final String LINE6_ENCODED = "[](){}";

	/**
	 * Testing EncodeLine method - normal line
	 */
    @Test
    public void testEncodeLine1() {
        String description = "Encode Line 1";
        String actual = Cipher.encodeLine(LINE1_DECODED);
        assertEquals(description, LINE1_ENCODED, actual);
    }

	/**
	 * Testing EncodeLine method - line with symbols
	 */
    @Test
    public void testEncodesymbols() {
        String description = "Encode Line with just symbols";
        String actual = Cipher.encodeLine(LINE3_DECODED);
        assertEquals(description, LINE3_ENCODED, actual);
    }

	/**
	 * Testing EncodeLine method - line with digits and numbers
	 */
    @Test
    public void testEncodeLinedigitsandletter() {
        String description = "Encode Line with digits and letters";
        String actual = Cipher.encodeLine(LINE2_DECODED);
        assertEquals(description, LINE2_ENCODED, actual);
    }

	/**
	 * Testing EncodeLine method - line with just letters
     * and spaces
	 */
    @Test
    public void testEncodeLinenospace() {
        String description = "Encode line with just letters and spaces";
        String actual = Cipher.encodeLine(LINE4_DECODED);
        assertEquals(description, LINE4_ENCODED, actual);
    }

	/**
	 * Testing EncodeLine method - line with just special characters
	 */
    @Test
    public void testEncodeLinewithsymbols() {
        String description = "Encode line with special character";
        String actual = Cipher.encodeLine(LINE5_DECODED);
        assertEquals(description, LINE5_ENCODED, actual);
    }

	/**
	 * Testing EncodeLine method - line with brackets
	 */
    @Test
    public void testEncodeLinewithdigits() {
        String description = "Encode brackets";
        String actual = Cipher.encodeLine(LINE6_DECODED);
        assertEquals(description, LINE6_ENCODED, actual);
    }

	/**
	 * Testing DecodeLine method - normal line
	 */
    @Test
    public void testDecodeLine1() {
        String description = "Decode Line 1";
        String actual = Cipher.decodeLine(LINE1_ENCODED);
        assertEquals(description, LINE1_DECODED, actual);
    }

	/**
	 * Testing DecodeLine method - line with digits and numbers
	 */
    @Test
    public void testDecodeLinedigitandletter() {
        String description = "Decode Line with digits and letter";
        String actual = Cipher.decodeLine(LINE2_ENCODED);
        assertEquals(description, LINE2_DECODED, actual);
    }

	/**
	 * Testing DecodeLine method - line with symbols
	 */
    @Test
    public void testDecodeLinesymbols() {
        String description = "Decode Line with just symbols and spaces";
        String actual = Cipher.decodeLine(LINE3_ENCODED);
        assertEquals(description, LINE3_DECODED, actual);
    }

	/**
	 * Testing DecodeLine method - line with just letters
     * and spaces
	 */
    @Test
    public void testDecodeLinenospace() {
        String description = "Decode line with just letters and spaces";
        String actual = Cipher.decodeLine(LINE4_ENCODED);
        assertEquals(description, LINE4_DECODED, actual);
    }

	/**
	 * Testing DecodeLine method - line with just special characters
	 */
    @Test
    public void testDecodeLinewithsymbols() {
        String description = "Decode line with special character";
        String actual = Cipher.decodeLine(LINE5_ENCODED);
        assertEquals(description, LINE5_DECODED, actual);
    }

	/**
	 * Testing DecodeLine method - line with brackets
	 */
    @Test
    public void testDecodeLinewithdigits() {
        String description = "Decode brackets";
        String actual = Cipher.decodeLine(LINE6_ENCODED);
        assertEquals(description, LINE6_DECODED, actual);
    }
    // TODO: Add 5 more test cases here for decodeLine method. Each test should be
    // in its own method
}
