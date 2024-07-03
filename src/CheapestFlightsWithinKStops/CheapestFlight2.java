package CheapestFlightsWithinKStops;


import java.util.*;

//Cleaner but TLE
public class CheapestFlight2  {
    public  record Node(int current, int cost, int stop) {}


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<List<Integer>>> adjList = getAdjListMap(n, flights);
        System.out.println(adjList);
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.cost, o2.cost);
            }
        });

//        Queue<Node> q = new ArrayDeque<>();

        Node n2 = new Node(src, 0, 0);
        queue.add(n2);
//        System.out.println(queue);
        while (!queue.isEmpty()){
            Node currentNode = queue.poll();

            if(currentNode.current == dst && currentNode.stop <= k + 1){
                return currentNode.cost;
            }
            if(currentNode.stop > k+1){
                continue;
            }
            for(List<Integer> neighbors : adjList.get(currentNode.current)){
                Node node = new Node(neighbors.get(0),
                        currentNode.cost + neighbors.get(1),
                        currentNode.stop + 1);
                queue.add(node);
            }
//            System.out.println(queue);
        }
        return -1;
    }

    private Map<Integer, List<List<Integer>>> getAdjListMap(int n, int[][] flights) {
        Map<Integer, List<List<Integer>>> adjList = new HashMap<>();
        for(int i = 0; i < n; i++){
            adjList.putIfAbsent(i, new ArrayList<>());
        }
        for(int[] f : flights){
            List<Integer> destinationAndCost = new ArrayList<>();
            destinationAndCost.add(f[1]);
            destinationAndCost.add(f[2]);
            adjList.get(f[0]).add(destinationAndCost);
        }
        return adjList;
    }

    public static void main(String[] args) {
        //Convert given data to adjacency List
        Map<Integer, List<List<Integer>>> adjList = new HashMap<>();
        int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        int source = 0, cost = 0, stops = 0, dst = 3;
        CheapestFlight2 cheapestFlight2 = new CheapestFlight2();
        System.out.println(cheapestFlight2.findCheapestPrice(4, flights, source, dst, 1));

    }
}
