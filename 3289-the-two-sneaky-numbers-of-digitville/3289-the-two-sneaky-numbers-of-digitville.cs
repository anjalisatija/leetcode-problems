/*
In the town of Digitville, there was a list of numbers called nums containing integers from 0 to n - 1. Each number was supposed to appear exactly once in the list, however, two mischievous numbers sneaked in an additional time, making the list longer than usual.

As the town detective, your task is to find these two sneaky numbers. Return an array of size two containing the two numbers (in any order), so peace can return to Digitville.

To solve the problem without the extra space, we need to think about how many times each number occurs in relation to the index.
*/
public class Solution {
    public int[] GetSneakyNumbers(int[] nums) {
        int[] arr = new int[2];
        int x=0;
        for(int i=0;i<nums.Length-1;i++)
        {
            for(int j=i+1;j<nums.Length;j++)
            {
                if(nums[i]==nums[j])
                {
                    arr[x]=nums[i];
                    x++;
                }

            }
        }
        return arr;
        
    }
}