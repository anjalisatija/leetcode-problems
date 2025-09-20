class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
       if(target>(x+y)) return false;
       if(target==0) return true;
       return (target%(gcd(x,y))==0);
    }
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}