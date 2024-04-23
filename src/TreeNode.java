/**
 * A node in a bit tree with a left and a right subtree (containts no value itself, see Leaf)
 * @author David
 */


public class TreeNode {
    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+

    /**
     * The subtree to the left of this node
     */
    TreeNode left;

    /**
     * The subtree to the left of this node
     */
    TreeNode right;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Creates a new TreeNode with the given subtrees
   */
  TreeNode(TreeNode left, TreeNode right) {
    this.left = left;
    this.right = right;
  } // TreeNode(TreeNode left, TreeNode right)

  /**
   * Creates a new empty TreeNode
   */
  TreeNode() {
  } // TreeNode()
  
  
    
} // TreeNode