package tree;

/**
 * @author cj
 * @date 2020/1/14
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class MirrorTree {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.leftNode = new BinaryTreeNode(6);
        root.rightNode = new BinaryTreeNode(10);
        root.leftNode.leftNode = new BinaryTreeNode(5);
        root.leftNode.rightNode = new BinaryTreeNode(7);
        root.rightNode.leftNode = new BinaryTreeNode(9);
        root.rightNode.rightNode = new BinaryTreeNode(11);
        BinaryTreeNode.printTree(root);
        System.out.println("========");
        mirror(root);
        BinaryTreeNode.printTree(root);
    }

    public static void mirror(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        if (root.leftNode == null && root.rightNode == null) { //只有一个根节点
            return;
        }
        if (root.leftNode != null) {
             mirror(root.leftNode);
        }
        if (root.rightNode != null) {
            mirror(root.rightNode);
        }
        BinaryTreeNode temp = root.leftNode;
        root.leftNode = root.rightNode;
        root.rightNode = temp;
    }
}
