package CloneGraph;

import java.util.HashMap;
import java.util.Map;

public class CloneGraphDFS {
    Map<Node,Node> clone = new HashMap<>();
    public Node cloneGraph(Node oldNode) {
        if(oldNode == null) {
            return null;
        }

        Node newNode = new Node(oldNode.val);
        clone.put(oldNode, newNode);
        for(Node neighbor : oldNode.neighbors){
            if(!clone.containsKey(neighbor)){
                newNode.neighbors.add(cloneGraph(neighbor));
            }else{
                newNode.neighbors.add(clone.get(neighbor));
            }
        }
        return newNode;
    }
}
