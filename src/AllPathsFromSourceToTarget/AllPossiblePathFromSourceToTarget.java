package AllPathsFromSourceToTarget;

import java.util.*;

//Accepted
public class AllPossiblePathFromSourceToTarget {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, new LinkedHashSet<>(), 0, graph.length - 1);
        return result;
    }

    public void dfs(int[][] graph, Set<Integer> visited, int src, int dsc){
        if(src == dsc){
            visited.add(dsc);
            result.add(visited.stream().toList());
            visited.remove(dsc);
            return;
        }

        if(visited.contains(src)){
            return;
        }
        visited.add(src);
        for(int j = 0 ; j < graph[src].length; j++){
            dfs(graph, visited, graph[src][j], dsc);
        }
        visited.remove(src);
    }

    public static void main(String[] args) {
        int[][] graph = {{2},{3},{1},{}};
        AllPossiblePathFromSourceToTarget allPossiblePathFromSourceToTarget = new AllPossiblePathFromSourceToTarget();
        System.out.println(allPossiblePathFromSourceToTarget.allPathsSourceTarget(graph));

    }
}
