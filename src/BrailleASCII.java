import java.io.PrintWriter;

/**
 * Allows for command line translation from braille bites to ASCII, ASCII to braille bits, or braille bits to Unicode braille symbols using BitTrees
 * @author: David Rhoades 
 */

public class BrailleASCII {
  public static void main(String[] args) throws Exception{
    PrintWriter pen = new PrintWriter(System.out, true);
    BrailleASCIITables tables = new BrailleASCIITables();
    if (args.length != 2) {
      pen.println("Improper number of input arguments, expected 2");
      return;
    }
    String ret = "";
    char[] chars = args[1].toCharArray();
    if (args[0].equals("braille")) {
      for (char ch : chars) {
        ret += tables.toBraille(ch);
      }
      pen.println(ret);
    } else if (args[0].equals("ascii")) {
      for (int i = 0; i < args[1].length(); i += 6) {
        ret += tables.toASCII(args[1].substring(i, i+6));
      }
      pen.println(ret);
    } else if (args[0].equals("unicode")) {
      for (char ch : chars) {
        int intRep = Integer.decode("0x" + tables.toUnicode(tables.toBraille(ch)));
        ret += (char)intRep;
      }
      pen.println(ret);
    } else {
      pen.println("Invalid command, please use braille, ascii, or unicode as the first argument");
    } // else
    return;
  } // main
} // BrailleASCII
