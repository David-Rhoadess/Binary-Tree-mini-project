import java.io.PrintWriter;
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
    this.charToBr.load(new FileInputStream(new File("src\\ASCIItoBraille.txt")));

    this.brToChar = new BitTree(6);
    this.brToChar.load(new FileInputStream(new File("src\\BrailletoASCII.txt")));

    this.brToUni = new BitTree(6);
    this.brToUni.load(new FileInputStream(new File("src\\BrailletoUnicode.txt")));
  }

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+
} // BrailleASCIITables
