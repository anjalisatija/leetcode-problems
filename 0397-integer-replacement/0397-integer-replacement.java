class Solution {
    public int integerReplacement(int n) 
    {
        int counter=0;
        while(n>1)
        {
            if(n%2==0)
            {
                n=n/2;
            }
            else
            {
                if(n== Integer.MAX_VALUE)
                {
                    return 32;
                }
                if(n==3 || (n & 2 )== 0)
                {
                    n--;
                }
                
                else
                    n++;
            }
            counter++;
        }
        return counter;
    }
}