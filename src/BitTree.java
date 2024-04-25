import java.io.PrintWriter;
import java.io.InputStream;
import java.util.Scanner;

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

  /**
   * Maps the given binary String to value
   */
  void set(String bits, String value) throws Exception{
    if (bits.length() != this.maxDepth - 1) {
      throw new Exception("Incorret number of input bits");
    }

    TreeNode cur = this.tree;
    for (int i = 0; i < bits.length() - 1; i++) {
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


  /**
   * returns the value aassociated with the given bit String, if there is no such value, throws an Exception
   */
  String get(String bits) throws Exception{
    if (bits.length() != this.maxDepth - 1) {
      throw new Exception("Incorret number of input bits");
    }

    TreeNode cur = this.tree;
    for (int i = 0; i < bits.length(); i++) {
      if (cur == null) {
        throw new Exception("Invalid input path");
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
    if (cur instanceof Leaf) {
      return ((Leaf)cur).str; 
    } else {
      throw new Exception("No set value for this path");
    } // else
  } // get

  /**
   * Prints out the contents of the tree is CSV format
   */
  void dump(PrintWriter pen) {
    dumpHelper(this.tree, "", pen);
  }

  /**
   * Recursive helper for dump method
   */
  void dumpHelper(TreeNode cur, String curStr, PrintWriter pen) {
    if (cur == null) {
      return;
    } else if (cur instanceof Leaf) {
      pen.println(curStr + "," + ((Leaf)cur).str);
    } else {
      dumpHelper(cur.left, curStr + "0", pen);
      dumpHelper(cur.right, curStr + "1", pen);
    } // else
  } // dump

  void load(InputStream source) throws Exception{
    Scanner input = new Scanner(source);
    String[] inStrings;
    while(input.hasNext()) {
      inStrings = input.nextLine().split(",");
      if(inStrings.length != 2) {
        input.close();
        throw new Exception("invalid load input");
      }
      this.set(inStrings[0], inStrings[1]);
    }
    input.close();
  } // load

} // BitTree




