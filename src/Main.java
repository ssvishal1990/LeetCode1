import PacificIslandWaterFlow.PacificAtlantic;
import PacificIslandWaterFlow.PacificAtlanticWaterFlow;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        CircularGame cg = new CircularGame();
//        System.out.println(cg.findTheWinner(5, 2));
//        DecodeString ds = new DecodeString();
//        System.out.println(ds.solution("abc3[cd]xyz"));
//        System.out.println("Hello world!");
//
//
//        //SetZeroes.SetZeroes
//        SetZeroes sz = new SetZeroes();
//        int[][] inp = {{1, 1, 1}, {1, 0, 1} , {1, 1, 1}};
//        System.out.println("Zero Matrix will look like :: \n ");
//        int[][] zeroMatrix = sz.setZeroes(inp);
//
//        for(int i = 0 ; i < zeroMatrix.length; i++){
//            for(int j = 0 ; j < zeroMatrix[0].length; j++){
//                System.out.print(zeroMatrix[i][j] + "  ");
//            }
//            System.out.println("\n");
//        }
//
//        SpiralMatrix sm = new SpiralMatrix();
//        int[][] inp2 = {{1, 2, 3}, {4, 5, 6} , {7, 8, 9}};
//        List<Integer> spiraledNumbers = sm.spiralOrder(inp2);
//
//        System.out.println("Big Decimal Zero Representation :: " + BigDecimal.ZERO);
//        for (int[] ints : inp2) {
//            for (int j = 0; j < inp2[0].length; j++) {
//                System.out.print(ints[j] + "  ");
//            }
//            System.out.println("\n");
//        }
//        System.out.println(spiraledNumbers);

        System.out.println(" PACIFIC ATLANTIC ");
//        PacificAtlanticWaterFloww pacificAtlanticWaterFloww = new PacificAtlanticWaterFloww();
//        pacificAtlanticWaterFloww.pacificAtlantic();

        PacificAtlantic pacificAtlanticWaterFlow = new PacificAtlantic();
        PacificAtlanticWaterFlow pacificAtlanticWaterFlow2 = new PacificAtlanticWaterFlow();
        int[][] arr = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        int[][] arr2 = {{1}};
        int[][] arr3 = {{1,2,3},{8,9,4},{7,6,5}};
        List<List<Integer>> coordinates = pacificAtlanticWaterFlow2.pacificAtlantic(arr);
        for(List<Integer> currentCoordinate : coordinates){
            System.out.println(currentCoordinate);
        }
    }
}