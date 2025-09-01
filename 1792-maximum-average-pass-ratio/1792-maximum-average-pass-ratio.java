class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(
                        (double) (b[0] + 1) / (b[1] + 1) - (double) b[0] / b[1],
                        (double) (a[0] + 1) / (a[1] + 1) - (double) a[0] / a[1]
                )
        );

        for (int[] c : classes) {
            pq.offer(c);
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] topClass = pq.poll();
            topClass[0]++;
            topClass[1]++;
            pq.offer(topClass); 
        }

        double totalRatio = 0;
        for (int[] c : classes) {
            totalRatio += (double) c[0] / c[1];
        }

        return totalRatio / classes.length;
    }
}