package CarFleet;

import java.util.*;

public class CarFleet {

    public record CarPositionSpeed(int position, int speed){}
    public int carFleet(int target, int[] position, int[] speed) {
        List<CarPositionSpeed> carPositionSpeedList = new ArrayList<>();
        for(int i = 0; i < position.length; i++){
            CarPositionSpeed carPositionSpeed = new CarPositionSpeed(position[i], speed[i]);
            carPositionSpeedList.add(carPositionSpeed);
        }
        carPositionSpeedList.sort(Comparator.comparingInt(o -> o.position));
        List<Integer> timeList = new ArrayList<>();
        carPositionSpeedList.forEach(o -> timeList.add((target - o.position)/o.speed));
        Stack<Integer> fleetTimes = new Stack<>();
        for(int i = position.length -1; i >= 0 ; i--){
            int time = timeList.get(i);
            if (!fleetTimes.isEmpty() && time <= fleetTimes.peek()){
                continue;
            }

            fleetTimes.push(time);
        }

        return fleetTimes.size();
    }

    public static void main(String[] args) {
        int[] position = new int[]{10,8,0,5,3};
        int[] speed = new int[]{2,4,1,1,3};
        int target = 12;
        CarFleet cf = new CarFleet();
        cf.carFleet(target, position, speed);
    }
}
