class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // Calculate the area of the first rectangle
        int areaOfRectA = (ax2 - ax1) * (ay2 - ay1);
        
        // Calculate the area of the second rectangle
        int areaOfRectB = (bx2 - bx1) * (by2 - by1);
        
        // Find the coordinates of the overlapping region
        int overlapLeft = Math.max(ax1, bx1);
        int overlapRight = Math.min(ax2, bx2);
        int overlapBottom = Math.max(ay1, by1);
        int overlapTop = Math.min(ay2, by2);
        
        // Calculate the area of the overlapping region
        int overlapArea = 0;
        // Only if there is an actual overlap
        if (overlapRight > overlapLeft && overlapTop > overlapBottom) {
            overlapArea = (overlapRight - overlapLeft) * (overlapTop - overlapBottom);
        }
        
        // Total area is the sum of both rectangle areas minus the overlapping area
        return areaOfRectA + areaOfRectB - overlapArea;
    }
}