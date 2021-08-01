package trainingTask4.p4;

public class BinTree {
    private Node root;

    private void appendNode(int val) {
        if ( root == null )
            root = new Node(val);
        else {
            Node currentNode = root;
            while (true) {
                if (val == currentNode.getValue()) {
                    return;
                }
                if (val < currentNode.getValue()) {
                    if (currentNode.getLeftChild() == null) {
                        currentNode.setLeftChild(new Node(val));
                        return;
                    } else {
                        currentNode = currentNode.getLeftChild();
                    }
                } else {
                    if (currentNode.getRightChild() == null) {
                        currentNode.setRightChild(new Node(val));
                        return;
                    } else {
                        currentNode = currentNode.getRightChild();
                    }
                }
            }
        }
    }

    public void preorder(Node currentNode) {
        if (currentNode == null) {
            return;
        }
        System.out.print(currentNode.getValue() + " ");
        preorder(currentNode.getLeftChild());
        preorder(currentNode.getRightChild());
    }


    public void postorder(Node currentNode) {
        if (currentNode == null) {
            return;
        }
        postorder(currentNode.getLeftChild());
        postorder(currentNode.getRightChild());
        System.out.print(currentNode.getValue() + " ");
    }

    public void inorder(Node currentNode) {
        if (currentNode == null) {
            return;
        }
        inorder(currentNode.getLeftChild());
        System.out.print(currentNode.getValue() + " ");
        inorder(currentNode.getRightChild());
    }

    public int findLength(Node currentNode) {
        if (currentNode == null) {
            return 0;
        }
        int llength = findLength(currentNode.getLeftChild())+1;
        int rlength = findLength(currentNode.getRightChild())+1;
        return Math.max(llength,rlength);
    }

    public Node getRoot(){
        return this.root;
    }

    public static void main(String[] args){
        BinTree tree = new BinTree();
        tree.appendNode(14);
        tree.appendNode(8);
        tree.appendNode(19);
        tree.appendNode(3);
        tree.appendNode(10);
        tree.appendNode(1);
        tree.appendNode(4);
        tree.appendNode(9);
        tree.appendNode(11);
        tree.appendNode(17);
        tree.appendNode(25);
        tree.appendNode(16);
        tree.appendNode(18);
        tree.appendNode(23);
        tree.appendNode(27);

        tree.preorder(tree.getRoot());
        System.out.println();
        tree.postorder(tree.getRoot());
        System.out.println();
        tree.inorder(tree.getRoot());
        System.out.println();
        System.out.println(tree.findLength(tree.getRoot()));
    }
}

class Node{
    private int value;
    private Node leftChild;
    private Node rightChild;

    public Node(int value) {
        this.value = value;
        leftChild = null;
        rightChild = null;
    }

    public Node(){}
    public int getValue() {
        return this.value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(final Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(final Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
