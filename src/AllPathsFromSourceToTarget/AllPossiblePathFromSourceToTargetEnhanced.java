package AllPathsFromSourceToTarget;

import java.util.ArrayList;
import java.util.List;

public class AllPossiblePathFromSourceToTargetEnhanced {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> visited = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        visited.add(0);

        dfs(graph, visited, ans, 0, graph.length - 1);
        return ans;
    }

    public void dfs(int[][] graph, List<Integer> visited, List<List<Integer>> ans, int source, int destination){
        if(source == destination){
            ans.add(new ArrayList<>(visited));
            return;
        }
        for(int j = 0; j < graph[source].length; j++){
            visited.add(graph[source][j]);
            dfs(graph, visited, ans, graph[source][j], destination);
            visited.removeLast();
        }
    }
}
