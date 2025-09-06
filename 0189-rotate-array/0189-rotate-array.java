class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;

        k=k%n;   //To handle cases where k>n

        reverse(nums,0,n-1);  // reverse entire array
        reverse(nums,0,k-1); //reverse first k elements
        reverse(nums,k,n-1);  // reverse the remaining elements
    }

    private void reverse(int[] nums, int i, int j){
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;

            i++;
            j--;
        }
    }
}