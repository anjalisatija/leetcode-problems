class Solution {
    public int maximumProduct(int[] nums) {
        int product = 1;
        int[] arr = new int[nums.length];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            arr[i] = nums[nums.length - 1- i];
        }
        int product1 = arr[0]*arr[1]*arr[2];
        int product2 = arr[0]*arr[nums.length-1]*arr[nums.length-2];
        product = Math.max(product1,product2);
        return product;
    }
}