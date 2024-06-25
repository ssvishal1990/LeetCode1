package AverageLevelsBinaryTree;


import java.util.*;

public class AverageLevelOfBinaryTree {

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

    //First Step create an array of the given tree
    public List<Double> averageOfLevels(TreeNode root) {
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        List<TreeNode> arrayOfTreeNodes = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode currentNode = queue.getFirst();
            queue.removeFirst();
            arrayOfTreeNodes.add(currentNode);
            if(currentNode != null){
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }

        for (TreeNode t : arrayOfTreeNodes) {
            int  x = t != null ? t.val : 0 ;
            System.out.print(x + "  ");
        }

        return null;
    }

    public List<Double> averageOfLevels2(TreeNode root) {
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        HashMap<Integer, List<TreeNode>> hm = new HashMap<>();
        int level = 0;
        int totalNumberOfNodesForCurrentLevel = (int)Math.pow(2, level);
        hm.put(level, new ArrayList<>());
        int totalNodesAdded = 1;
        while (!queue.isEmpty()){

            TreeNode currentNode = queue.getFirst();
            queue.removeFirst();

            if(totalNodesAdded == totalNumberOfNodesForCurrentLevel){
                level++;
                totalNumberOfNodesForCurrentLevel = (int)Math.pow(2, level);
                hm.put(level, new ArrayList<>());

                if(currentNode != null){
                    hm.get(level).add(currentNode);
                }
                totalNodesAdded = 1;
            }else if(totalNodesAdded < totalNumberOfNodesForCurrentLevel){
                if (currentNode != null) {
                    hm.get(level).add(currentNode);
                }
                totalNodesAdded++;
            }

            if(currentNode != null){
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }

        for(Map.Entry<Integer, List<TreeNode>> h : hm.entrySet()){
            System.out.print("Key : " + h.getKey() + " Values :: ");
            for(TreeNode t : h.getValue()){
                int  x = t != null ? t.val : 0 ;
                System.out.print(x + " ");
            }
            System.out.println();
        }

        return null;
    }



}
