class Solution {
    //2 2 4 6 8 10
    //0 1 2 3 4 5
    //dp[i][j] where i is the first index of the subsequence and j is the second index of the subsequcne and the state represents the number of subsequences that can be made from these two subsequences
    //i < j, nums[j] - nums[i] = delta 
    //dp[i][j] = dp[j][k] + dp[j][k+1] + ...
    //O(n^2) ~ O(n^3) Min(dp,algo)
    //O(nlogn + n^2) 
    //First sort nums, then do memoization to build the dp!
    //Had to create fancy binsearch methods to be able to SUBSTANTIALLY speed up the dp!
    //Actually wait... I kinda want to try the tabulation approach, just for the sake of being able to do it!
    //Plus, I would have to do an O(n^2) forloop at the beginning of the dp anyways, so I think the tabulation approach would just be strictly better (it usually is)!
    //Alright, time to give it my real shot!
    //OMG I'M SOOO STUPID!!! OF COURSE I CAN'T SORT NUMS!!! THAT DEFEATS THE ENTIRE POINT :'(
    //ALL MY WORK WAS FOR NAUGHT :(
    //Alright, after removing the sort (I don't even know why I thought that it would be acceptable), the algo seems to work!
    //Not only does it seem to work, buts it's only a few lines of code AND is super elegant!
    //Only concern is that it is technically O(n^3)... but I hope that is ok...
    //If not, I might have to change some things (such as preprocessing the array or creating a HashMap of the indexes of each element)
    //Actually, the last idea isn't that bad, I might go for it if the algo inevitably TLEs!
    //WAIT ACTUALLY?!? NO TLE?
    //Well that's awfully generous XD
    //Well I'm still going to do that optimization as it will save a RIDICULOUS amount of time while only adding O(n) space and will reduce the complexity to O(n^2) (except for cases likes example 2, but because the solutions accepts, a couple bad runs won't make much of a difference and the time save will still be noticable!)
    //I also forgot to get rid of my println -_- but now with the optimization PLUS getting rid of the println, my code should run lickety-split!
    //And if not? Simply try my previous 'elegant' code again, but without the println!
    //Now THAT'S what I'm talking about!
    public int numberOfArithmeticSlices(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        Map<Long,List<Integer>> indexes = new HashMap<>();
        //Populate the HashMap with the indexes of each number!
        for(int i = 0; i < nums.length; i++){
            indexes.putIfAbsent((long)nums[i],new ArrayList<>());
            indexes.get((long)nums[i]).add(i);
        }
        int sum = 0;
        //All subsequences where j = nums.length-1 are 0, so I should start at j = nums.length - 2!
        //Additionally, j has to be greater than 0 (or else there will be no indexes for i)
        //Since i must always be less than j, I can start it at i = j
        for(int j = nums.length-2; j >= 1; j--){
            for(int i = j-1; i >= 0; i--){
                //Because I'm stupid and didn't realize I can't just use a binsearch, I will now have to traverse from j to nums.length-1 MANUALLY
                //This is really bad because now my algo might still end up as O(n^3), which might be too slow...
                //Actually no it won't! Not with the power of the HashMap "indexes"!
                //With that, I can get the list of important indexes in O(1) time!
                //However, some cases, like example 2, will still be quite slow, and could even be WORSE than before... 
                //But the "worse" cases are still the same complexity as before and the best cases are a whole complexity better!

                long target = 2 *(long)nums[j] -nums[i];
                if(!indexes.containsKey(target)){continue;}
                for(Integer k: indexes.get(target)){
                    if(k > j){
                        dp[i][j] += dp[j][k]+1;
                    }
                }
                sum+= dp[i][j];
                //Now my code is not only simpler... BUT ALSO BETTER!
            }
        }
        //Now that I have sucessfully constructed the dp, the question remains, HOW IN THE WORLD DO I EXTRACT MY NECASSARY INFO!
        //Actually wait, it might not be that bad! I think it might be possible to just sum up all the entries in the dp?
        //If that's the case than my code will be able to be super simple and elegant (AND I can do the summing INSIDE the forloop)!!!
        return sum;
    }

/*
//All this work was for naught because I'm stupid and forgot I am not allowed to sort the array :(

Arrays.sort(nums);
//Now what I do is first call bin search!
    //This will give me a range of values that are equal to 2 * nums[j]-nums[i] (lets call each index k)
    //From this, I will then sum up all the subsequences dp[j][k] (adding 1 for each valid subsequence)
    //This will be saved as dp[i][j] and the process will continue!
    //However, this all relies on the binSearch working as intended and even if it does work as intended, this can introduce the possibility of an O(n^3) case (like if all the numbers are the same as in example 2)
    //Hopefully it doesn't come to that though and that the solution is still an improvement on my last one!
    //I must convert  2 * nums[j]-nums[i] to a long as it could easily be out of bounds!
    long target = 2 *(long)nums[j] -nums[i]
    int low = binSearch(nums,j,target,true);
    //if nums[low] != 2 * nums[j]-nums[i], I might be able to skip calculating low (I should be able to), but I will still do it in order to catch any bugs resulting from the binSearch
    int high = binSearch(nums,j,target,false);
    if(nums[low] != target && nums[high] != target){
        continue;
    }else if(nums[low] == target && nums[high] == target){
        //Now traverse over the range from low to high, and sum up all the relevant dps!
        while(low < high){

        }
    }else{
        System.out.println("WTF")
    }


    private int binSearch(int[] nums, int i, long n, boolean low){
        int f = i+1;
        int l = nums.length-1;
        int m = (f+l)/2;
        while(f<l){
            if(getCase(nums[m],n,low)){
                f = low? m+1:m;
            }else{
                l = low? m: m-1;
            }
            m = (f+l)/2;
        }
        return m;
    }

    private boolean getCase(int val, long n, boolean low){
        if(low){
            return val < n;
        }else{
            return val <= n;
        }
    }
*/
}