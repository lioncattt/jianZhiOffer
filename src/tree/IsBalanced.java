package tree;

/**
 * @author cj
 * @date 2020/2/22
 * 判断是否为平衡二叉树
 * 平衡二叉树左右子树高度差不超过 1。
 *             5
 *  *  *      / \
 *  *  *      3  7
 *  *  *     / \ / \
 *  *  *     2 4 6  8
 *  *       /
 *  *       9
 */
public class IsBalanced {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.leftNode = new BinaryTreeNode(3);
        root.rightNode = new BinaryTreeNode(7);
        root.leftNode.leftNode = new BinaryTreeNode(2);
        root.leftNode.rightNode = new BinaryTreeNode(4);
        root.rightNode.leftNode = new BinaryTreeNode(6);
        root.rightNode.rightNode = new BinaryTreeNode(8);

        root.rightNode.leftNode.leftNode = new BinaryTreeNode(9);

        System.out.println(isBalanced(root));
    }

    static boolean flag = true;

    public static boolean isBalanced(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
       treeDepth(root);
       return flag;

    }

    public static int treeDepth(BinaryTreeNode root) {
        if (root == null || !flag) { // 优化:加入!flag flag默认值设为true 表示只要flag = false，表示存在一颗子树长度之差>1无需继续递归
            return 0;
        }

        int left = treeDepth(root.leftNode);
        int right = treeDepth(root.rightNode);

        if (Math.abs(left - right) > 1) {
            flag =  false;
        } else {
            flag =  true;
        }
        return 1 + Math.max(left, right);
    }
}
