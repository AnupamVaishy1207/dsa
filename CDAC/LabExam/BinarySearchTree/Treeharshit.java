public class Treeharshit {
    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int element) {
            this.data = element;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public Tree() 
        {
            this.root = null;
        }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(int value) {
        Node newnode = new Node();

        if (root == null) {
            root = newnode;
        } else {
            Node trav = root;
        }
        while (true) {
            if (value < trav.left) {
                if (trav.left == null) {
                    trav.left = newnode;
                    break;
                } else {
                    trav = trav.left;

                }
            } else {
                if (trav.right = null) {
                    trav.right = newnode;
                } else {
                    trav = trav.right;
                }
            }

        }

    }

    public void inOrder() {
        System.out.print("Tree Node :: {");
        inOrder(root);
        System.out.println(" }");
    }

    public void inOrder(Node traversal) {
        if (isEmpty()) {
            System.err.println("Tree is Empty");
        } else {
            if (traversal.left != null) {
                inOrder(traversal.left);
            }
            System.out.print(" " + traversal.data);
            if (traversal.right != null) {
                inOrder(traversal.right);
            }
        }
    }

    public void findHeight(int element) {
        Node node = Search(element);
        if (node != null)
            System.out.println("Height of node with element " + element + " : " + findHeight(node));
        else
            System.out.println("Element Not found");
    }

    public Node Search(int element) {
        if (isEmpty()) {
            return null;
        } else {
            Node traverse = root;
            while (traverse != null) {
                if (traverse.data == element) {
                    return traverse;
                } else if (traverse.data > element) {
                    traverse = traverse.left;
                } else {
                    traverse = traverse.right;
                }
            }
        }
        return null;
    }

    public int findHeight(Node traversal) {
        if (traversal == null)
            return -1;
        else {
            int lHeight = findHeight(traversal.left);
            int rHeight = findHeight(traversal.right);

            return Math.max(lHeight, rHeight) + 1;
        }
    }

    public void findHeighest() {
        if (isEmpty()) {
            return;
        } else {
            int highest = root.data;
            Node traverse = root.right;
            while (traverse != null) {
                if (traverse.data > highest) {
                    highest = traverse.data;
                }
                traverse = traverse.right;
            }
            System.out.println("Heighest value : " + highest);
        }
    }

    public void findSmallest() {
        if (isEmpty()) {
            return;
        } else {
            int smallest = root.data;
            Node traverse = root.left;
            while (traverse != null) {
                if (traverse.data < smallest) {
                    smallest = traverse.data;
                }
                traverse = traverse.left;
            }
            System.out.println("Smallest value : " + smallest);
        }
    }

    public void countSibling() {
        int count = countSibling(root);
        System.out.println("Sibling count : " + count);
    }

    public void countFullNodes() {
        int count = countSibling(root);
        System.out.println("Full Nodes count : " + count);
    }

    public int countSibling(Node traverse) {
        if (traverse == null)
            return 0;
        int count = 0;
        if (traverse.left != null && traverse.right != null) {
            count = count + 1;
        }
        count = count + countSibling(traverse.left);
        count = count + countSibling(traverse.right);
        return count;
    }

    public void findDepth(int element) {
        int counter123 = -1;
        if (isEmpty()) {
            return;
        } else {

            Node traverse = root;
            while (traverse != null) {
                if (traverse.data == element) {
                    System.out.print("Depth of Node elemet " + element + " :" + "");
                    System.out.println(counter123);
                    break;
                } else if (traverse.data > element) {
                    traverse = traverse.left;
                } else {
                    traverse = traverse.right;
                }
                counter123 = counter123 + 1;
            }
        }
    }

}
