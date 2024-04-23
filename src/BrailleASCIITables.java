import java.io.PrintWriter;

/**
 * Allows for translation from braille bites to ASCII, ASCII to braille bits, or braille bits to Unicode braille symbols
 * @author David Rhoades
 */



public class BrailleASCIITables {
  public static void main(String[] args) throws Exception{
    PrintWriter pen = new PrintWriter(System.out);
    BitTree tree = new BitTree(3);
    tree.set("101", "a");
    pen.println(tree.get("101"));
  } // main

} // BrailleASCIITables
