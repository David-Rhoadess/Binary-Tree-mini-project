/**
 * A binary tree intended to store mappings from bits to values
 * @author: David Rhoades 
 */


public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The top node of the binary tree
   */
  TreeNode tree;

  /**
   * The max depth of the BitTree
   */
  int maxDepth;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Creates a new, empty BitTree of depth n + 1
   */
  BitTree(int n) {
    this.tree = new TreeNode(null, null);
    this.maxDepth = n + 1;
  } // BitTree(int n)

  /**
   * A recursive helper method for the BitTree constructor, I dont think I actaully need this
   
  TreeNode bitTreeHelper(int curLevel, int maxLevel) {
    if(curLevel == maxLevel) {
      return new Leaf();
    } // if
    else {
      return new TreeNode(bitTreeHelper(++curLevel, maxLevel), bitTreeHelper(curLevel, maxLevel));
    } // else
  } // bitTreeHelper
  */

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  void set(String bits, String value) throws Exception{
    if (bits.length() != this.maxDepth - 1) {
      throw new Exception("Incorret number of input bits");
    }

    TreeNode cur = this.tree;
    for (int i = 0; i < bits.length() - 2; i++) {
      cur = nextBit(bits.charAt(i), cur);
    } // for

    if(nextBit(bits.charAt(bits.length() - 1), cur.left) == cur) {
      cur.left = new Leaf(value);
    } else {
      cur.right = new Leaf(value);
    } // else
  } // set

  /**
   * Returns the next TreeNode to be used based on the bit ch (0 or 1), throws an excpetion for invalid input
   */
  TreeNode nextBit(char ch, TreeNode cur) throws Exception{
    if (ch == '0') {
      if (cur.left == null) {
        cur.left = new TreeNode();
      } // if
      cur = cur.left;
    } else if (ch == '1') {
      if (cur.right == null) {
        cur.right = new TreeNode();
      } // if
      cur = cur.right;
    }
    else {
      throw new Exception("Invalid input bit");
    } // else
    return cur;
  } // nextBit

  String get(String bits) {
    if (bits.length() != this.maxDepth - 1) {
      throw new Exception("Incorret number of input bits");
    }

    TreeNode cur = this.tree
    for(int i = 0; i < bits.length(); i++) {
      if() // START HERE, maybe make a call to nextbit?
    }
  }

} // BitTree




