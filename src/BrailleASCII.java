import java.io.PrintWriter;

/**
 * Allows for command line translation from braille bites to ASCII, ASCII to braille bits, or braille bits to Unicode braille symbols using BitTrees
 * @author: David Rhoades 
 */

public class BrailleASCII {
  public static void main(String[] args) throws Exception{
    PrintWriter pen = new PrintWriter(System.out, true);
    BrailleASCIITables test = new BrailleASCIITables();
    test.brToUni.dump(pen);
    pen.println("here");
  } // main
}
