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

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  void set(String bits, String value) throws Exception{
    if (bits.length() != this.maxDepth - 1) {
      throw new Exception("Incorret number of input bits");
    }

    TreeNode cur = this.tree;
    for (int i = 0; i < bits.length(); i++) {
      cur = nextBit(bits.charAt(i), cur);
    } // for

    if(nextBit(bits.charAt(bits.length() - 1), cur) == cur.left) {
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

  String get(String bits) throws Exception{
    if (bits.length() != this.maxDepth - 1) {
      throw new Exception("Incorret number of input bits");
    }

    TreeNode cur = this.tree;
    for (int i = 0; i < bits.length(); i++) {
      if (cur == null) {
        throw new Exception("Invalid input");
      }
      if (bits.charAt(i) == '0') {
        cur = cur.left;
      } else if (bits.charAt(i) == '1') {
        cur = cur.right;
      }
      else {
        throw new Exception("Invalid input bit");
      } // else
    } // for
    return ((Leaf)cur).str;
  } // get

} // BitTree




