import java.util.*;

class Solution {
    private int[][] rects;
    private int[] cumulativeAreas;
    private Random random;
    public Solution(int[][] rects) {
        this.rects = rects;
        this.cumulativeAreas = new int[rects.length];
        this.random = new Random();
        int areaSum = 0;
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            int area = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            areaSum += area;
            cumulativeAreas[i] = areaSum;
        }
    }
    public int[] pick() {
        int target = random.nextInt(cumulativeAreas[cumulativeAreas.length - 1]) + 1;
        int rectIndex = binarySearch(target);
        int[] rect = rects[rectIndex];
        int x = rect[0] + random.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + random.nextInt(rect[3] - rect[1] + 1);

        return new int[]{x, y};
    }
    private int binarySearch(int target) {
        int left = 0, right = cumulativeAreas.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (cumulativeAreas[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

