package tree;

/**
 * @author cj
 * @date 2019/12/23
 */
public class BinaryTreeNode {
    public int val;
    public BinaryTreeNode leftNode = null;
    public BinaryTreeNode rightNode = null;

    public BinaryTreeNode(int val) {
        this.val = val;
    }

    public void putLeftTreeNode(BinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void putRightTreeNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public void printTree(BinaryTreeNode root) {

    }
}
