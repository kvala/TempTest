//package test;
//
//public class fb {
//
//}
//
//
//
//Welcome to Facebook!
//
//This is just a simple shared plaintext pad, with no execution capabilities.
//
//When you know what language you'd like to use for your interview,
//simply choose it from the dropdown in the top bar.
//
//Enjoy your interview!
//
//# q1
//
//You are given a binary tree where each node value is either 0 or 1. The parent node value is the bitwise AND of the two child values.
//Given a leaf node, toggle the value and update the tree accordingly. There is a pointer from child to parent.
//
//Example:
//
//For tree: Given the second leaf node counting from the left
//
//          0
//        /   \
//       0     1
//      / \   /  \
//     1   0  1   1
//         ^
//         ^
//
//The expected result is:
//
//          1
//        /   \
//       1     1
//      / \   /  \
//     1   1  1   1
//  
//
//  
//     
//public void bitWistNodes(Node leaf) {
//  if(leaf == null) {
//    return;
//  }
//  
//  Node parent = null;
//  leaf.val = ~leaf.val;
//  while(leaf.getParent()) {
//   parent = leaf.getParent();
//   int bit = parent.left.val & parent.right.val;
//   if(parent.val != bit) {
//    parent.val = bit;
//    leaf = parent;
//    continue;
//   }
//   else {
//    return;
//   }
//  }
//  
//}
//
//
//q2:
//
//linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
//                                 ^
//int k = 2
//
//
//// 1 -> 2 -> null
//k = 1
//
//public Node deleteKNode(Node head, int k) {
//  Node current = head;
//
//  
//  for(int i =0; i<k;i++) {
//    if(current.next != null){
//      current = current.next;
//    }
//    else {
//      return head;
//    }
//  }
//  
//  Node pre = head;
//  
// 
//  while(current.next != null) {
//    current = current.next;
//    pre = pre.next;
//  }
//  
//  pre.next = pre.next.next;
//  if(head == pre){
//    head = pre;
//  }
//  
//  return head;
//}
//
