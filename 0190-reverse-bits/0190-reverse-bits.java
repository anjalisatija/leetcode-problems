class Solution {
    public int reverseBits(int n) {
        int rev=0;
        for(int i=0;i<32;i++)
        {
            if((n&(1<<i))!=0)
            rev|=(1<<31-i);
        }
        return rev;
    }
}