package CheapestFlightsWithinKStops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Accepted
public class CheapestFlight3 {
    public record Flight(int toCity, int price) {}
    public record Tuple(int city, int cost, int stops) {}

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Flight>> adjacencyList = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adjacencyList.add(new ArrayList<>());
        }

        for(int[] flight : flights){
            int fromFlight = flight[0];
            int toFlight = flight[1];
            int costOfFlight = flight[2];

            adjacencyList.get(fromFlight).add(new Flight(toFlight, costOfFlight));
        }

        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;


        Tuple t = new Tuple(src, 0, 0);

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(t);

        while (!queue.isEmpty()){
            Tuple currentCity = queue.poll();
            int stops = currentCity.stops;
            int cost = currentCity.cost;
            int city = currentCity.city;

            if(stops > k){
                continue;
            }

            for(Flight flight : adjacencyList.get(city)){
                int adjCity = flight.toCity;
                int adjCityCost = flight.price;

                if(cost + adjCityCost < costs[adjCity] && stops <= k){
                    costs[adjCity] = cost + adjCityCost;
                    queue.add(new Tuple(adjCity, costs[adjCity], stops + 1));
                }
            }
        }

        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }

    public static void main(String[] args) {
        int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        int source = 0, cost = 0, stops = 0, dst = 3;
        CheapestFlight3 cheapestFlight3 = new CheapestFlight3();
        System.out.println(cheapestFlight3.findCheapestPrice(4, flights, 0, 3, 1));
    }
}
