package CloneGraph;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph {
    List<Integer> traversedNodes = new ArrayList<>();


    public void cloneGraph(Node oldNode, Node newNode){
        DeepCopyNodes(oldNode, newNode);
    }

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Node newNode = new Node(node.val);
        traversedNodes.add(node.val);
        DeepCopyNodes(node, newNode);
        return newNode;
    }

    private void DeepCopyNodes(Node oldNode, Node newNode) {
        for(Node oldNodeNeighbor : oldNode.neighbors) {

            // I was creating a new Node everytime
            // Bad


            Node newNeighbhorNode = new Node(oldNodeNeighbor.val);
            newNode.neighbors.add(newNeighbhorNode);
            if(!traversedNodes.contains(oldNodeNeighbor.val)){
                traversedNodes.add(oldNodeNeighbor.val);
                cloneGraph(oldNodeNeighbor, newNeighbhorNode);
            }
        }
    }
}
