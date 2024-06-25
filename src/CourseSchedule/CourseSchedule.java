package CourseSchedule;

import java.util.HashMap;
import java.util.Map;

public class CourseSchedule {
    Map<Integer, Integer> prerequisiteAndCourseMap = new HashMap<>();

    public boolean  checkIfLoopExists(Map<Integer, Integer> map, int prerequisite, int startNode){
        if(!map.containsKey(prerequisite)){
            return false;
        }else  if(map.get(prerequisite) == startNode){
            return true;
        }
        return checkIfLoopExists(map, map.get(prerequisite), startNode);
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int row = 0; row < prerequisites.length; row++) {
                prerequisiteAndCourseMap.put(prerequisites[row][1], prerequisites[row][0]);
        }
        // Check for loop
        for(Map.Entry<Integer, Integer> es : prerequisiteAndCourseMap.entrySet()){
            if(checkIfLoopExists(prerequisiteAndCourseMap, es.getValue(), es.getKey())){
                return false;
            }
        }
        System.out.println(prerequisiteAndCourseMap.toString());
        return true;
    }
}
