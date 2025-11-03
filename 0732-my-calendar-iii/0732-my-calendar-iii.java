class MyCalendarThree {
    TreeMap<Integer, Integer> timeCount;

    public MyCalendarThree() {
        timeCount = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        timeCount.put(startTime, timeCount.getOrDefault(startTime, 0) + 1);
        timeCount.put(endTime, timeCount.getOrDefault(endTime, 0) - 1);
        
        int maxBooking = 0;
        int ongoing = 0;
        
        for (int count : timeCount.values()) {
            ongoing += count;
            maxBooking = Math.max(maxBooking, ongoing);
        }

        return maxBooking;
    }
}


/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */