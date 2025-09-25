class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[]result = new int[n];
        if(n == 0)return new int[0];
      //  if(n == 1)return new int[]{-1};
        int[][] originalArray = new int[n][2];
        for(int i = 0;i< n;i++){
            originalArray[i][0] = intervals[i][0];
            originalArray[i][1] = i;
        }
        Arrays.sort(originalArray, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        for(int i = 0;i < n;i++){
            int end_i = intervals[i][1];

            int left = 0;
            int right = n - 1;
            int found = -1;

            while(left <= right){
                int mid = left + (right - left)/2;
                if(originalArray[mid][0] >= end_i){
                    found = originalArray[mid][1];
                    right =mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            result[i] = found;
        }
        return result;
    }
}