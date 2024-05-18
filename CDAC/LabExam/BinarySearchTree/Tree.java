public class Tree {
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

    public Tree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(int element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            root = newNode;
        } else {
            Node traversal = root;
            while (true) {
                if (traversal.data > element) {
                    if (traversal.left == null) {
                        traversal.left = newNode;
                        break;
                    } else {
                        traversal = traversal.left;
                    }
                } else {
                    if (traversal.right == null) {
                        traversal.right = newNode;
                        break;
                    } else {
                        traversal = traversal.right;
                    }
                }
            }
        }
    }

    public void inOrder() {
        System.out.print("Tree Nodes Inorder: {");
        inOrder(root);
        System.out.println(" }");
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(" " + node.data);
            inOrder(node.right);
        }
    }

    public int findHeight(int element) {
        Node node = search(element);
        if (node != null) {
            return findHeight(node);
        } else {
            return -1; // Element not found
        }
    }

    private int findHeight(Node node) {
        if (node == null) {
            return -1;
        } else {
            int leftHeight = findHeight(node.left);
            int rightHeight = findHeight(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public Node search(int element) {
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
        return null;
    }

    public int findDepth(int element) {
        int depth = 0;
        Node traverse = root;
        while (traverse != null) {
            if (traverse.data == element) {
                return depth;
            } else if (traverse.data > element) {
                traverse = traverse.left;
            } else {
                traverse = traverse.right;
            }
            depth++;
        }
        return -1; // Element not found
    }

    public int countSiblings() {
        return countSiblings(root);
    }

    private int countSiblings(Node node) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.left != null && node.right != null) {
            count = 1;
        }
        count += countSiblings(node.left);
        count += countSiblings(node.right);
        return count;
    }

    public int countFullNodes() {
        return countFullNodes(root);
    }

    private int countFullNodes(Node node) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.left != null && node.right != null) {
            count = 1;
        }
        count += countFullNodes(node.left);
        count += countFullNodes(node.right);
        return count;
    }

    public boolean isAncestor(int ancestor, int descendant) {
        Node ancestorNode = search(ancestor);
        return isAncestor(ancestorNode, descendant);
    }

    private boolean isAncestor(Node node, int descendant) {
        if (node == null) {
            return false;
        }
        if (node.data == descendant) {
            return true;
        }
        return isAncestor(node.left, descendant) || isAncestor(node.right, descendant);
    }

    public int findSmallest() {
        if (isEmpty()) {
            return -1;
        }
        Node traverse = root;
        while (traverse.left != null) {
            traverse = traverse.left;
        }
        return traverse.data;
    }

    public int findHighest() {
        if (isEmpty()) {
            return -1;
        }
        Node traverse = root;
        while (traverse.right != null) {
            traverse = traverse.right;
        }
        return traverse.data;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] elements = {33, 31, 34, 35, 39, 32, 36, 38, 37, 30};
        for (int element : elements) {
            tree.add(element);
        }

        // Print inorder traversal
        tree.inOrder();

        // Find height and depth of a given node
        int elementToFind = 35;
        System.out.println("Height of node " + elementToFind + ": " + tree.findHeight(elementToFind));
        System.out.println("Depth of node " + elementToFind + ": " + tree.findDepth(elementToFind));

        // Count siblings
        System.out.println("Count of sibling pairs: " + tree.countSiblings());

        // Count full nodes
        System.out.println("Count of full nodes: " + tree.countFullNodes());

        // Check ancestor relationship
        int ancestor = 34;
        int descendant = 39;
        System.out.println("Is " + ancestor + " an ancestor of " + descendant + "? " + tree.isAncestor(ancestor, descendant));

        // Find smallest and highest elements
        System.out.println("Smallest element: " + tree.findSmallest());
        System.out.println("Highest element: " + tree.findHighest());
    }
}

    

