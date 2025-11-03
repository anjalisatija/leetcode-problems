class Solution {
    public static boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;

        int n = image.length;
        int m = image[0].length;
        int old = image[sr][sc];
        int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];
            image[x][y] = color;

            for (int[] d : dir) {
                int newX = x + d[0], newY = y + d[1];
                if (isValid(newX, newY, n, m) && image[newX][newY] == old) {
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return image;
    }
}