package AverageLevelsBinaryTree;

import java.util.*;
public class AverageLevelOfBinaryTree2 {
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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        traverseTree(root, result);
        return result;
    }

    public List<Double> traverseTree(TreeNode root, List<Double> listOfDoubles) {
        if(root == null)  {
            return listOfDoubles;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int currentLevelSize = queue.size();
            int sum = 0 ;
            for(int i = 0 ; i < currentLevelSize; i++){
                TreeNode currenNode = queue.poll();
                if(currenNode.left != null){
                    queue.add(currenNode.left);
                }

                if(currenNode.right != null){
                    queue.add(currenNode.right);
                }

                sum += currenNode.val;
            }

            listOfDoubles.add((double)sum/currentLevelSize);
        }
        return  listOfDoubles;
    }




}
