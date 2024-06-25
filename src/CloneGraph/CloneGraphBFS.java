package CloneGraph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class CloneGraphBFS {
    public Node cloneGraph(Node oldNode) {
        if(oldNode == null){
            return null;
        }

        Map<Node, Node> clones = new HashMap<Node, Node>();
        Queue<Node> queue = new ArrayDeque<Node>();

        Node newNode = new Node(oldNode.val);
        clones.put(oldNode, newNode);
        queue.add(oldNode);

        while(!queue.isEmpty()){
            Node currentNode = queue.poll();

            for(Node neighbor : currentNode.neighbors){
                if(!clones.containsKey(neighbor)){
                    clones.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                clones.get(currentNode).neighbors.add(clones.get(neighbor));
            }
        }
        return clones.get(oldNode);
    }
}
