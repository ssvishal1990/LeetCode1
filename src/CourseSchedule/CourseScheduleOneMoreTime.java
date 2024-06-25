package CourseSchedule;

import java.util.*;

public class CourseScheduleOneMoreTime {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseAndPrerequisite = new HashMap<>();
        for(int course = 0 ; course < numCourses ; course++){
            courseAndPrerequisite.put(course, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            List<Integer> temp = courseAndPrerequisite.get(prerequisite[0]);
            temp.add(prerequisite[1]);
        }
        Set<Integer> visited = new HashSet<>();
        for(int course = 0 ; course < numCourses ; course++){
            if(!dfs(courseAndPrerequisite, course,  visited)){
                return false;
            }
        }
        return true;

    }

    private boolean dfs(Map<Integer, List<Integer>> courseAndPrerequisite, int course, Set<Integer> visited) {
        if(visited.contains(course)){
            return false;
        }

        if(courseAndPrerequisite.get(course).isEmpty()){
            return true;
        }

        visited.add(course);
        for(int prerequisite : courseAndPrerequisite.get(course)){
            if(!dfs(courseAndPrerequisite, prerequisite, visited)){
                return false;
            }
        }
        visited.remove(course);
        courseAndPrerequisite.put(course, new ArrayList<>());
        return true;
    }

}
