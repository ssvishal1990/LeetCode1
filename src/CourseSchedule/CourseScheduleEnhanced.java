package CourseSchedule;

import java.util.*;

public class CourseScheduleEnhanced {
    Map<Integer, List<Integer>> hm = new HashMap<>();
    Set<Integer> visiblitySet = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int course = 0 ; course < numCourses; course++){
            hm.put(course, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            hm.get(prerequisite[0]).add(prerequisite[1]);
        }
        for(int course = 0 ; course < numCourses; course++){
            if(!dfs(course)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int course){
        if(visiblitySet.contains(course)){
            return false;
        }

        if(hm.get(course).isEmpty()){
            return true;
        }

        visiblitySet.add(course);

        for(int preq : hm.get(course)){
            if(!dfs(preq)){
                return false;
            }
        }
        hm.put(course,  new ArrayList<>());
        visiblitySet.remove(course);
        return true;
    }

 public void fuckALlLogic(){

 }

}