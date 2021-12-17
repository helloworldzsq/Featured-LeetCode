package bfs;

import java.util.LinkedList;
import java.util.Queue;

//给定一个二叉树，找出其最小深度。
//
//最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
//说明：叶子节点是指没有子节点的节点。
public class 二叉树的最小深度 {
    public  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public int minDepth(TreeNode root) {
            if (root==null)
                return 0;
            //创建一个队列
            Queue<TreeNode> list = new LinkedList<>();
            list.add(root);
            //初始化为1
            int depth=1;
            while (!list.isEmpty()){
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = list.poll();
                    if (node.left==null && node.right==null)
                        return depth;
                    if (node.left!=null)
                        list.add(node.left);
                    if (node.right!=null)
                        list.add(node.right);
                }
                depth++;
            }
            return depth;
    }
}
