package tree;

/**
 * @author cj
 * @date 2020/2/22
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 *       5
 *      / \
 *      3  7
 *     / \ / \
 *     2 4 6  8
 *
 * 例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 * 思路：利用中序遍历二叉搜索树 得出递增序列，第k小 = 中序遍历的递归顺序
 *
 *
 */
public class KthNode {

    static int i = 0;

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.leftNode = new BinaryTreeNode(3);
        root.rightNode = new BinaryTreeNode(7);
        root.leftNode.leftNode = new BinaryTreeNode(2);
        root.leftNode.rightNode = new BinaryTreeNode(4);
        root.rightNode.leftNode = new BinaryTreeNode(6);
        root.rightNode.rightNode = new BinaryTreeNode(8);

        System.out.println(kthNode(root, 1).val);
    }

    public static BinaryTreeNode kthNode(BinaryTreeNode root, int k) {
        if (root == null || k <= 0) {
            return null;
        }
        return  kthNodeCore(root, k);
    }

    /**
     * 返回第k小的节点
     * @param root
     * @param k
     * @return
     */
    public static BinaryTreeNode kthNodeCore(BinaryTreeNode root, int k) {
        BinaryTreeNode kthNode = null; // 指向第k小的节点

        if (root.leftNode != null) {
            kthNode =  kthNodeCore(root.leftNode, k); //向左子树找
        }

        i++; // 计数器 记录每次递归的节点

        // 判断当前节点是否为第k小节点
        if (kthNode == null) { // 未找到
            // k = i 当前节点即为第k小节点
            if (k == i) {
                kthNode = root;
            }
        }

        // 左子树未找到，往右边找
        if (kthNode == null && root.rightNode != null) {
            kthNode =  kthNodeCore(root.rightNode, k);
        }
        return kthNode;
    }


}
