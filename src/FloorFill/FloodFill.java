package FloorFill;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] directions = new int[][]{
                {1,0},
                {-1,0},
                {0,1},
                {0,1}};
        int initialColor = image[sr][sc];
        for(int[] dir : directions){
            int r = sr + dir[0];
            int c = sc + dir[1];
            if( r < 0 || r > image.length -1
                    || c < 0 || c > image[0].length -1
                    || image[r][c] != initialColor ){
                //Question got solved with easier approach hence ditching thus
            }
        }
        dfs(image, sr, sc, color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color) {
        if(sr < 0 || sr > image.length -1
                || sc < 0 || sc > image[0].length - 1
                || image[sr][sc] == color){
            return ;
        }
        image[sr][sc] = color;
        dfs(image, sr + 1, sc, color);
        dfs(image, sr - 1, sc, color);
        dfs(image, sr, sc + 1, color);
        dfs(image, sr, sc - 1, color);
    }
}
