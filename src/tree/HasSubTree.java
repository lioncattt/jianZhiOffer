package tree;

/**
 * @author cj
 * @date 2020/1/13
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 *
 * 分析
 * 从A树根结点开始遍历，如果结点与B树结点相等，则递归判断左子结点和右子结点的情况；
 * 若不等，则往下遍历A树左右结点各自与B树的情况。
         *    8                  8
         *  /  \                / \
         * 8    7              9   2
 *        / \
 *       9   2
 *      / \
 *     4   7
 *
 */
public class HasSubTree {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.leftNode = new BinaryTreeNode(9);
        root.rightNode = new BinaryTreeNode(2);
        BinaryTreeNode.printTree(root);
    }

    /**
     * 该函数功能：从root1出发判断当前tree1是否包含tree2，若返回不包含，则选择root1的左节点进行递归判断
     * 若root1左节点也不包含，则选择右节点进行递归判断
     * @param root1
     * @param root2
     * @return
     */
    public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;
        // 任一节点为null，返回false 两节点不为空才可递归
        if (root1 != null && root2 != null) {
            // 两节点相等，则判断子树是否相等
            if (root1.val == root2.val) {
                // 判断当前子树是否和root2相等
                result = doesTree1HasTree2(root1, root2);
            }
            // 如果不相等，重新选择根节点的左节点为根节点判断左节点的子树是否相等
            if (!result) {
                result = hasSubTree(root1.leftNode, root2);
            }
            if (!result) {
                // 若左节点的子数不相等，判断右节点的子树是否相等
                result = hasSubTree(root1.rightNode, root2);
            }
        }

        return result;
    }

    /**
     * 该函数功能：判断以当前传入的root1为根节点的子树tree1是否包含tree2
     * @param root1
     * @param root2
     * @return
     */
    private static boolean doesTree1HasTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        // 若root2递归结束，表示所有节点均相等则返回true
        if (root2 == null) {
            return true;
        }
        // root2尚未递归完，root1已递归完，返回true
        if (root1 == null) {
            return false;
        }
        // root1和root2均未递归完 root1 != NULL && root2 != null
        if (root1.val == root2.val) {
            // 满足当前节点的左节点子树和roo2的左节点子树相等并且右节点子树也相当
            return doesTree1HasTree2(root1.leftNode, root2.leftNode)
                    && doesTree1HasTree2(root1.rightNode, root2.rightNode);
        }
        return false;
    }
}
