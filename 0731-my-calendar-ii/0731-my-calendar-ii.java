   class MyCalendarTwo {
    private final List<int[]> bookings;         // List to store single bookings
    private final List<int[]> doubleBookings;   // List to store double bookings

    public MyCalendarTwo() {
        this.bookings = new ArrayList<>();      // Initialize the single bookings list
        this.doubleBookings = new ArrayList<>();// Initialize the double bookings list
    }
    public boolean book(final int start, final int end) {
        // Check for triple bookings
        for (final int[] booking : doubleBookings) {
            if (booking[0] < end && booking[1] > start) {
                return false;   // Triple booking would occur
            }
        }

        // Update double bookings
        for (final int[] booking : bookings) {
            if (booking[0] < end && booking[1] > start) {
                doubleBookings.add(new int[] {
                    Math.max(start, booking[0]),   // Start of the overlap
                    Math.min(end, booking[1])      // End of the overlap
                });
            }
        }

        bookings.add(new int[] { start, end }); // Add new event to single bookings
        return true;
    }
}