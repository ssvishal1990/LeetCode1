package FloorFill;

public class FloodFillExp {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int initialColor) {
        if(sr < 0 || sr > image.length -1
                || sc < 0 || sc > image[0].length - 1
                || image[sr][sc] != initialColor
                || image[sr][sc] == color){
            return ;
        }
        image[sr][sc] = color;

        dfs(image, sr + 1, sc, color, initialColor);
        dfs(image, sr - 1, sc, color, initialColor);
        dfs(image, sr, sc + 1, color, initialColor);
        dfs(image, sr, sc - 1, color, initialColor);
    }
}
