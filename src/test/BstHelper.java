package test;

public class BstHelper {

	public static BinaryTree bintree2listUtil(BinaryTree node) 
    {
        // Base case
        if (node == null)
            return node;
  
        // Convert the left subtree and link to root
        if (node.left != null) 
        {
            // Convert the left subtree
            BinaryTree left = bintree2listUtil(node.left);
  
            // Find inorder predecessor. After this loop, left
            // will point to the inorder predecessor
            for (; left.right != null; left = left.right);
  
            // Make root as next of the predecessor
            left.right = node;
  
            // Make predecssor as previous of root
            node.left = left;
        }
  
        // Convert the right subtree and link to root
        if (node.right != null) 
        {
            // Convert the right subtree
            BinaryTree right = bintree2listUtil(node.right);
  
            // Find inorder successor. After this loop, right
            // will point to the inorder successor
            for (; right.left != null; right = right.left);
  
            // Make root as previous of successor
            right.left = node;
  
            // Make successor as next of root
            node.right = right;
        }
  
        return node;
    }
  
    // The main function that first calls bintree2listUtil(), then follows
    // step 3 of the above algorithm
      
    public static BinaryTree bintree2list(BinaryTree node) 
    {
        // Base case
        if (node == null)
            return node;
  
        // Convert to DLL using bintree2listUtil()
        node = bintree2listUtil(node);
  
        // bintree2listUtil() returns root node of the converted
        // DLL.  We need pointer to the leftmost node which is
        // head of the constructed DLL, so move to the leftmost node
        while (node.left != null)
            node = node.left;
  
        return node;
    }
}
