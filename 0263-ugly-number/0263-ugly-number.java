class Solution {
    public boolean isUgly(int n) {
       if(n<=0)
       {
        return false;
       }
       if(n== 1)
       {
        return true;
       }
       
        int result = 0;
       for(int i = 0 ; i <50 ;i++)
       {
        if(n%2 == 0)
        {
            result = n/2;
            n = result;
        }else if(n%3 == 0)
        {
           result = n/3;
           n = result;
        }else if(n%5 == 0)
        {
            result = n/5;
            n = result;
        }
       }

       if(n == 1)
       {
        return true;
       }else 
       {
        return false;
       }
    }
}