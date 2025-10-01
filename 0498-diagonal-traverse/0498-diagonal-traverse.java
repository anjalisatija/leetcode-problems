import java.util.Arrays;

class Solution {
    private int forward(int i, int[] ans, int x, int y, int[][] mat) {
        int r = mat.length, c = mat[0].length;
        while (x >= 0 && y < c) {
            ans[i++] = mat[x][y];
            x--;
            y++;
        }
        return i;
    }

    private int backward(int i, int[] ans, int x, int y, int[][] mat) {
        int r = mat.length, c = mat[0].length;
        while (x < r && y >= 0) {
            ans[i++] = mat[x][y];
            x++;
            y--;
        }
        return i;
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int[] ans = new int[r * c];

        int i = 0;
        boolean up = true;

        for (int sum = 0; sum <= r + c - 2; sum++) {
            if (up) {
                int x, y;
                if (sum < r) {
                    x = sum;
                    y = 0;
                } else {
                    x = r - 1;
                    y = sum - (r - 1);
                }
                i = forward(i, ans, x, y, mat);
            } else {
                int x, y;
                if (sum < c) {
                    x = 0;
                    y = sum;
                } else {
                    x = sum - (c - 1);
                    y = c - 1; 
                }
                i = backward(i, ans, x, y, mat);
            }
            up = !up;
        }

        return ans;
    }
}

public class Cp {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] nums = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Arrays.toString(sol.findDiagonalOrder(nums)));
    }
}