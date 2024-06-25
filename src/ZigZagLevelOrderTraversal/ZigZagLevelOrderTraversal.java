package ZigZagLevelOrderTraversal;

import java.util.*;

public class ZigZagLevelOrderTraversal {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean leftToRight = false;
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        int currentLevel = 0;

        while (!queue.isEmpty()){
            int numberOfNodesInCurrentLevel = queue.size();
            List<Integer> currentLevelNodes = new ArrayList<>();
            for(int i = 0 ; i < numberOfNodesInCurrentLevel; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelNodes.add(currentNode.val);
                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            hm.put(currentLevel++, currentLevelNodes);
        }

        leftToRight = true;
        for(Map.Entry<Integer, List<Integer>> em : hm.entrySet()){
            System.out.println("Level :: " + em.getKey() + "  value  " + em.getValue());
            if(leftToRight){
                result.add(em.getValue());
            }else{
                result.add(em.getValue().reversed());
            }
            leftToRight = !leftToRight;
        }
        return result;
    }


}
