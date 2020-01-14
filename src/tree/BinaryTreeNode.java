package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    public static void printTree(BinaryTreeNode root) {
        ArrayList<ArrayList<Integer>> result = Print(root);
        result.forEach((list)->{
            System.out.println(list);
        });
    }

    static ArrayList<ArrayList<Integer> > Print(BinaryTreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return result;
        }
        Queue<BinaryTreeNode> layer = new LinkedList<BinaryTreeNode>();
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        layer.add(pRoot);
        int start = 0, end = 1;
        while(!layer.isEmpty()){
            BinaryTreeNode cur = layer.remove();
            layerList.add(cur.val);
            start++;
            if(cur.leftNode!=null){
                layer.add(cur.leftNode);
            }
            if(cur.rightNode!=null){
                layer.add(cur.rightNode);
            }
            if(start == end){
                end = layer.size();
                start = 0;
                result.add(layerList);
                layerList = new ArrayList<Integer>();
            }
        }
        return result;
    }
}
