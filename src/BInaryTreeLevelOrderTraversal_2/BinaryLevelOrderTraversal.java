package BInaryTreeLevelOrderTraversal_2;

import java.util.*;

public class BinaryLevelOrderTraversal {
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        Map<Integer, List<Integer>> levelAndNodesAtThatLevel = new HashMap<>();
        List<List<Integer>> levelAndNodesAtThatLevel2 = new ArrayList<>();
        while (!queue.isEmpty()){
            int noOfNodesAtCurrentLevel = queue.size();
            List<Integer> nodesValueAtCurrentLevel = new ArrayList<>();
            for(int i = 0 ; i < noOfNodesAtCurrentLevel; i++){
                TreeNode currentElement = queue.poll();
                nodesValueAtCurrentLevel.add(currentElement.val);
                if(currentElement.left != null){
                    queue.add(currentElement.left);
                }

                if(currentElement.right != null){
                    queue.add(currentElement.right);
                }
            }

//            levelAndNodesAtThatLevel.put(level++, nodesValueAtCurrentLevel);
            levelAndNodesAtThatLevel2.add(nodesValueAtCurrentLevel);
        }

        return levelAndNodesAtThatLevel2.reversed();
    }
}
