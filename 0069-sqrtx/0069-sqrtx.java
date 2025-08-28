class Solution {
    public int mySqrt(int x) {
        if(x<=1) return x;
        long i=0;
        long count=1;
        long num=(long)x ;
        while(count<=num)
        {
            i++;
            count=i*i;
        }
        return (int)i-1;
    }
}