/**
 * A node in a BitTree that constains a String;
 * @author David Rhoades
 */


public class Leaf extends TreeNode{
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The String contained in this Leaf
   */
  String str;


  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Creates a new Leaf with the given String
   */
  Leaf(String str) {
    this.str = str;
  } // Leaf(String str)

  /**
   * Creates a new, empty Leaf with the given String
   */
  Leaf() {
  } // Leaf()

  
} // leaf