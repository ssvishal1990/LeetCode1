package CheapestFlightsWithinKStops;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

// Not accepted SOme errors and Better approaches found
public class CheapestFlight {
    public int findCheapestFlightWithinKStops(int n, int[][] flights, int src, int dst, int k) {
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(i == src) continue;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        int steps = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < n ; i++){
            int minV = minDistance(distance, visited);
            visited[minV] = true;
            steps++;
//            System.out.println("Min V = " + minV);
            for(int j = 0 ; j < n ; j++){
                if(flights[minV][j] != 0 && !visited[j] && distance[minV] != Integer.MAX_VALUE){
                    int newDist = distance[minV] + flights[minV][j];
                    if(newDist < distance[j]){
                        distance[j] = newDist;
                    }

                    if(j == dst){
                        hashMap.put(steps, distance[dst]);
                    }
                }
            }
        }
        System.out.println(hashMap);
        int minPrice = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> kv : hashMap.entrySet()){
            if(kv.getKey() <= k  && kv.getValue() <= minPrice){
                minPrice = kv.getValue();
            }
        }

        if(minPrice == Integer.MAX_VALUE){
            return -1;
        }

        return minPrice;

    }

    private int minDistance(int[] distance, boolean[] visited) {
        int minV = -1;
        for(int i = 0 ; i < distance.length; i++){
            if(!visited[i] && (minV == -1 || distance[minV] > distance[i]) ){
                minV = i;
            }
        }
        return minV;
    }

    public static void main(String[] args) {
        int n  = 4;
        int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        int[][] adxMatrix = new int[n][n];
        for (int[] flight : flights) {
            adxMatrix[flight[0]][flight[1]] = flight[2];
        }
        for(int i = 0 ; i < adxMatrix.length; i++){
            for(int j = 0 ; j < adxMatrix[0].length; j++){
                System.out.print(adxMatrix[i][j] + "   ");
            }
            System.out.println("\n");
        }
        int src = 0;
        int dsc = 3;
        int stops =1;
        CheapestFlight cheapestFlight = new CheapestFlight();
        System.out.println("\n Cheapest Flights " + cheapestFlight.findCheapestFlightWithinKStops(n, adxMatrix, src, dsc, stops));
    }
}
