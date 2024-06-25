package NumberOfProvinces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfProvinces {
    List<Set<Integer>> listOfInterconnectedCities = new ArrayList<>();
    public List<Set<Integer>> findCircleNum(int[][] isConnected) {
        int numberOfCities = isConnected.length;

        boolean[] visited = new boolean[isConnected.length];
        for(int i = 0;  i < numberOfCities; i++){
            if(!visited[i]){
                Set<Integer> innterConnectedCities = new HashSet<>();
                innterConnectedCities.add(i);
                DFS(isConnected, i, visited, innterConnectedCities);
                listOfInterconnectedCities.add(innterConnectedCities);
            }

        }

        return listOfInterconnectedCities;
    }

    private void DFS(int[][] isConnected, int city, boolean[] visited, Set<Integer> innterConnectedCities) {
        if(visited[city]){
            return;
        }

        visited[city] = true;
        for(int neighbour = 0 ; neighbour < isConnected[city].length ; neighbour++){
            if(neighbour != city && !visited[neighbour] && isConnected[city][neighbour] == 1) {
                innterConnectedCities.add(neighbour);
                DFS(isConnected, neighbour, visited, innterConnectedCities);
            }
        }
    }

}
