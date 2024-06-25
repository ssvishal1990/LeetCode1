package IslandPerimeter;

public class IslandPerimeterEnhanced {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols =  grid[0].length;
        int perimeter = 0;
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(grid[i][j] == 1){
                    if (i - 1 >= 0) {
                        if (grid[i-1][j] == 0) perimeter++;
                    } else {
                        perimeter++;
                    }

                    if(i + 1 < rows){
                        if(grid[i+1][j] == 0){
                            perimeter++;
                        }
                    }else{
                        perimeter++;
                    }

                    if(j -1 >= 0){
                        if(grid[i][j-1] == 0){
                            perimeter++;
                        }
                    }else{
                        perimeter++;
                    }

                    if(j + 1 < cols){
                        if(grid[i][j + 1] == 0){
                            perimeter++;
                        }
                    }else{
                        perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }
}
