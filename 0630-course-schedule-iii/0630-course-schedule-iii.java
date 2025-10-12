class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int totalTime = 0;
        for (int[] course : courses) {
            int dur = course[0];
            int lastDay = course[1];
            totalTime += dur;
            maxHeap.offer(dur);
            if (totalTime > lastDay) {
                totalTime -= maxHeap.poll();
            }
        }
        return maxHeap.size();
    }
}