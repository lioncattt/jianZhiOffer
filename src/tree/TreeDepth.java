package tree;

/**
 * @author cj
 * @date 2020/2/22
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）
 * 形成树的一条路径，最长路径的长度为树的深度。
 *  *       5
 *  *      / \
 *  *      3  7
 *  *     / \ / \
 *  *     2 4 6  8
 *       /
 *       9
 */
public class TreeDepth {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.leftNode = new BinaryTreeNode(3);
        root.rightNode = new BinaryTreeNode(7);
        root.leftNode.leftNode = new BinaryTreeNode(2);
        root.leftNode.rightNode = new BinaryTreeNode(4);
        root.rightNode.leftNode = new BinaryTreeNode(6);
        root.rightNode.rightNode = new BinaryTreeNode(8);

        root.leftNode.leftNode.leftNode = new BinaryTreeNode(9);
        System.out.println(treeDepth(root));
    }

    public static int treeDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        int leftDepth = 0;
        int rightDepth = 0;
        if (root.leftNode != null) {
            leftDepth = treeDepth(root.leftNode);
        }
        if (root.rightNode != null) {
            rightDepth = treeDepth(root.rightNode);
        }
        return depth + Math.max(leftDepth, rightDepth);
    }
}
