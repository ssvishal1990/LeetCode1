package BinaryTreeLevelOrderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public class TreeNode {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();

        while (!queue.isEmpty()){
            int currentLevelSize = queue.size();
            List<Integer> currentLevelNodes = new ArrayList<>();

            for(int i = 0 ; i < currentLevelSize ; i++){
                TreeNode currentNode = queue.poll();

                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }

                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }

                currentLevelNodes.add(currentNode.val);
            }
            result.add(currentLevelNodes);
        }
        return result;
    }


    public void Traverse(TreeNode root, List<List<Integer>> levelOrderNodes){
        if(root == null){
            return ;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();

        while (!queue.isEmpty()){
            int currentLevelSize = queue.size();
            List<Integer> currentLevelNodes = new ArrayList<>();

            for(int i = 0 ; i < currentLevelSize ; i++){
                TreeNode currentNode = queue.poll();

                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }

                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }

                currentLevelNodes.add(currentNode.val);
            }
            levelOrderNodes.add(currentLevelNodes);
        }
        return;
    }

}
