package CourseSchedule__2;

import java.util.*;

public class CourseSchedule__2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseAndPrerequisite = new HashMap<>();
        for(int course = 0 ; course < numCourses ; course++){
            courseAndPrerequisite.put(course, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            List<Integer> temp = courseAndPrerequisite.get(prerequisite[0]);
            temp.add(prerequisite[1]);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> sequenceToFinishAllCourses = new LinkedHashSet<>();
        for(int course = 0 ; course < numCourses ; course++){
            if(!dfs(courseAndPrerequisite, course,  visited, sequenceToFinishAllCourses)){
                return new int[]{};
            }
        }
        int[] result = new int[numCourses];
        result = Arrays.stream(sequenceToFinishAllCourses.toArray()).mapToInt(o -> (int)o).toArray();
        return result;
    }

    private boolean dfs(Map<Integer, List<Integer>> courseAndPrerequisite, int course, Set<Integer> visited, Set<Integer> sequenceToFinishAllCourses) {
        if(visited.contains(course)){
            return false;
        }

        if(courseAndPrerequisite.get(course).isEmpty()){
            sequenceToFinishAllCourses.add(course);
            return true;
        }

        visited.add(course);
        for(int prerequisite : courseAndPrerequisite.get(course)){
            if(!dfs(courseAndPrerequisite, prerequisite, visited, sequenceToFinishAllCourses)){
                return false;
            }
//            sequenceToFinishAllCourses.add(prerequisite);
        }
        visited.remove(course);

        sequenceToFinishAllCourses.add(course);
        courseAndPrerequisite.put(course, new ArrayList<>());

        return true;
    }

    public static  class Test{
        public static  void main(String[] args){
            CourseSchedule__2 courseSchedule__2 = new CourseSchedule__2();
            int[][] grid = {{0, 1}};
            int[] r = courseSchedule__2.findOrder(2, grid);
            for(int i : r){
                System.out.print(i + "   ");
            }
            LinkedHashSet<String> lhSet = new LinkedHashSet<String>();

            lhSet.add("Apple");
            lhSet.add("Banana");
            lhSet.add("Cherry");

            System.out.println("LinkedHashSet: " + lhSet); // Output will maintain insertion order
        }
    }
}
