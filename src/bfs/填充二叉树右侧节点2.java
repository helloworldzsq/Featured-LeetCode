package bfs;

import java.util.Deque;
import java.util.LinkedList;

public class 填充二叉树右侧节点2 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
// 这道题希望我们把二叉树各个层的点组织成链表，一个非常直观的思路是层序遍历。
    public Node connect(Node root) {
        if(root == null)
            return root;
        // Deque 相当于一个栈
        Deque<Node> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node pre = null;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node node = queue.remove();
                if(pre != null){
                    pre.next = node;
                }
                pre = node;
                //next
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
        }
        return root;
    }
}
