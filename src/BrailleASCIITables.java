import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Allows for translation from braille bites to ASCII, ASCII to braille bits, 
 * or braille bits to Unicode braille symbols using BitTrees
 * @author David Rhoades
 */

public class BrailleASCIITables {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * A BitTree for converting characters to Braille (as a string of bits)
   */
  BitTree charToBr;

  /**
   * A BitTree for converting Braille (as a string of bits) so ASCII characters
   */
  BitTree brToChar;

  /**
   * A BitTree for converting Braille (as a string of bits) so Unicode Braille characters
   */
  BitTree brToUni;


  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  BrailleASCIITables() throws FileNotFoundException, Exception {
    this.charToBr = new BitTree(8);
    this.charToBr.load(new FileInputStream(new File("src/ASCIItoBraille.txt")));

    this.brToChar = new BitTree(6);
    this.brToChar.load(new FileInputStream(new File("src/BrailletoASCII.txt")));

    this.brToUni = new BitTree(6);
    this.brToUni.load(new FileInputStream(new File("src/BrailletoUnicode.txt")));
  } // BrailleASCIITables

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Converts an ASCII character to a string of bits representing the corresponding braille character
   */
  String toBraille(char letter) throws Exception {
    return this.charToBr.get("0" + Integer.toBinaryString(letter)); // 0 added becasuse toBinaryString removes the leading 0
  } // toBraille

  /**
   * Converts a string of bits representing a braille character to the corresponding ASCII character
   */
  String toASCII(String bits) throws Exception {
    return this.brToChar.get(bits);
  } // toASCII

  /**
   * Converts a string of bits representing a braille character to the corresponding Unicode braille character for those bits. You need only support six-bit braille characters
   */
  String toUnicode(String bits) throws Exception {
    return this.brToUni.get(bits);
  } // toUnicode

} // BrailleASCIITables
