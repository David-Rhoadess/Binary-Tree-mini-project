import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;

/**
 * Allows for translation from braille bites to ASCII, ASCII to braille bits, or braille bits to Unicode braille symbols
 * @author David Rhoades
 */



public class BrailleASCIITables {
  public static void main(String[] args) throws Exception{
    PrintWriter pen = new PrintWriter(System.out, true);

    
    BitTree tree = new BitTree(8);
    File file = new File("src/ASCIItoBraille.txt");
    tree.load(new FileInputStream(file));
    tree.dump(pen);



  } // main

} // BrailleASCIITables
