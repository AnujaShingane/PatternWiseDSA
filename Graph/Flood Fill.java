public void floodFill(int[][] image, int sr, int sc, int color) {
    int orig = image[sr][sc];
    if (orig == color) return;

    dfsFill(image, sr, sc, orig, color);
}

private void dfsFill(int[][] img, int r, int c, int orig, int color) {
    if (r<0 || c<0 || r>=img.length || c>=img[0].length || img[r][c]!=orig) return;

    img[r][c] = color;

    dfsFill(img, r+1, c, orig, color);
    dfsFill(img, r-1, c, orig, color);
    dfsFill(img, r, c+1, orig, color);
    dfsFill(img, r, c-1, orig, color);
}
