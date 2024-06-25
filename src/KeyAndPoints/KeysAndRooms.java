package KeyAndPoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int numberOfRooms = rooms.size();
        boolean[] keyCollected = new boolean[numberOfRooms];
        boolean[] visited = new boolean[numberOfRooms];
        boolean[] helper = new boolean[numberOfRooms];

        keyCollected[0] = true;
        for(int i = 0 ; i < numberOfRooms; i++){
            DFS(rooms, i, visited, helper, keyCollected);
        }
        for (boolean b : keyCollected) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void DFS(List<List<Integer>> rooms, int currentRoom, boolean[] visited, boolean[] helper, boolean[] keyCollected) {
        if(visited[currentRoom]) return ;
        if(rooms.get(currentRoom).isEmpty()) return ;

        visited[currentRoom] = true;
        helper[currentRoom] = true;
        List<Integer> keysForRooms = rooms.get(currentRoom);
        for(int keyForRoom : keysForRooms){
            if(helper[keyForRoom] || visited[keyForRoom] || keyForRoom == currentRoom) continue;

            keyCollected[keyForRoom] = true;
            DFS(rooms, keyForRoom, visited, helper, keyCollected);

        }

        helper[currentRoom] = false;
    }

    public static  class Test{
        public static void main(String[] args){
            List<Integer> arr1 = new ArrayList<>();
            List<Integer> arr2 = new ArrayList<>();
            List<Integer> arr3 = new ArrayList<>();
            List<Integer> arr4 = new ArrayList<>();

            arr1.add(1);
            arr2.add(2);
            arr3.add(3);
            List<List<Integer>> test = new ArrayList<>();
            test.add(arr1);
            test.add(arr2);
            test.add(arr3);
            test.add(arr4);

            System.out.println(test);

            KeysAndRooms keysAndRooms = new KeysAndRooms();
            System.out.println(keysAndRooms.canVisitAllRooms(test));

        }
    }

}
