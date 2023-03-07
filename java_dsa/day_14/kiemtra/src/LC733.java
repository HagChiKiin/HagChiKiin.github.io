public class LC733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor)    // neu mau color chua phai mau moi thi goi ham de quy dfs de to mau cac pixcel lien ke
            dfs(image, sr, sc, color, newColor);
        return image;
    }
    private boolean inNotValid(int[][] image, int r, int c, int color) {
        return r < 0 || c<0 || r>=image.length || c>= image[0].length || image[r][c] !=color;
    }
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (inNotValid(image, r,c,color)) return;

        image[r][c] = newColor;
        // lan luot lan toa 4 huong
        dfs(image, r-1, c, color, newColor);
        dfs(image, r, c-1, color, newColor);
        dfs(image, r+1, c, color, newColor);
        dfs(image, r, c+1, color, newColor);
    }
}
