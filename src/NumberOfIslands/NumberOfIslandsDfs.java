package NumberOfIslands;

public class NumberOfIslandsDfs {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0 ;
        for(int row = 0 ; row < grid.length; row++){
            for(int col = 0 ; col < grid[0].length; col++){
                if(grid[row][col] == '1'){
                    numOfIslands++;
                    dfs(grid, row, col);
                }
            }
        }
        return numOfIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }

    public static class tMain {
        public static void main(String[] args){
            NumberOfIslandsDfs numberOfIslands = new NumberOfIslandsDfs();
            char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
            System.out.println(numberOfIslands.numIslands(grid));
        }
    }
}
