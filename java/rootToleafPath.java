class PrintRootToLeafPath
{
  static class Node {

      int data;
      Node left, right;

      Node(int item) {
          data = item;
          left = right = null;
      }
  }

  public static void main(String[] args) {
    Node tree = new Node(10);
    tree.left = new Node(8);
    tree.right = new Node(2);
    tree.left.left = new Node(3);
    tree.left.right = new Node(5);
    tree.right.left = new Node(2);
    printPaths(tree);
  }
  static void printPaths(Node node) {
        int path[] = new int[1000];
        printPathsRecur(node, path, 0);
    }
  static  void printPathsRecur(Node node, int path[], int pathLen) {
           if (node == null) {
               return;
           }

           /* append this node to the path array */
           path[pathLen] = node.data;
           pathLen++;

           /* it's a leaf, so print the path that led to here  */
           if (node.left == null && node.right == null) {
               printArray(path, pathLen);
           } else {

               /* otherwise try both subtrees */
               printPathsRecur(node.left, path, pathLen);
               printPathsRecur(node.right, path, pathLen);
           }
       }

  /* Utility function that prints out an array on a line. */
    static void printArray(int ints[], int len) {
        int i;
        for (i = 0; i < len; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println("");
    }
}
