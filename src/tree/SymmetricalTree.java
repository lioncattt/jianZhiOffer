package tree;

/**
 * @author cj
 * @date 2020/1/14
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *               8
 *  *     	   /  \
 *  *     	  6    6
 *  *     	 / \  / \
 *  *     	5  7 7  5
 *  思路：考虑前序遍历[8,6,5,7,6,7,5] 构造对称遍历(根右左)[8,6,5,7,6,7,5]
 *  两者遍历结果相同则对称
 *                   8
 *  *  *     	   /  \
 *  *  *     	  6    9
 *  *  *     	 / \  / \
 *  *  *     	5  7 7  5
 *  前序遍历[8,6,5,7,9,7,5] 对称遍历[8,9,5,7,6,7,5]不对称
 *  特殊情况
 *                       8
 *  *  *  *     	   /  \
 *  *  *  *     	  8    8
 *  *  *  *     	 / \  /
 *  *  *  *     	8  8 8
 *  [8,8,8,8,8,8,null]   [8,8,null,8,8,8,8] 不对称
 */
public class SymmetricalTree {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.leftNode = new BinaryTreeNode(6);
        root.rightNode = new BinaryTreeNode(6);
        root.leftNode.leftNode = new BinaryTreeNode(5);
        root.leftNode.rightNode = new BinaryTreeNode(7);
        root.rightNode.leftNode = new BinaryTreeNode(7);
        root.rightNode.rightNode = new BinaryTreeNode(5);
        BinaryTreeNode.printTree(root);
        System.out.println(isSymmetrical(root));


    }

    public static boolean isSymmetrical(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetrical(root.leftNode, root.rightNode);
    }

    private static boolean isSymmetrical(BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
        if (leftNode == null && rightNode == null) { //
            return true;
        }
        // 有一个节点为空另一个节点不为空
        if (leftNode == null || rightNode == null) {
            return false;
        }
        if (leftNode.val == rightNode.val) {
            // 第一个参数对应前序遍历中下一个值 第二个参数对应对称遍历中下一个值
            return isSymmetrical(leftNode.leftNode, rightNode.rightNode)
                    && isSymmetrical(leftNode.rightNode, rightNode.leftNode);
        }
        return false;
    }
}
