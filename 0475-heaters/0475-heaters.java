class Solution {
    // O(N Log N + M Log N);
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int minStandardRadius = 0;
        for(int house: houses){
            minStandardRadius = Math.max(minStandardRadius, findMinimumAbsDiff(house, heaters));
        }
        return minStandardRadius;
    }
    
    private int findMinimumAbsDiff(int num, int[] arr){
        int start=0, end=arr.length-1;
        int minimumDiff = Integer.MAX_VALUE;
        
        while(start<=end){
            int mid = start + (end-start) / 2;
            
            int curDiff = Math.abs(num-arr[mid]);
            minimumDiff = Math.min(minimumDiff, curDiff);
            if(curDiff == 0){
                return 0;
            }
            else if(num > arr[mid]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return minimumDiff;
    }
}