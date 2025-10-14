class Solution {
    public int numDecodings(String s) {
        int mod=1000000007;
        s=" "+s;
        long ans[]=new long[s.length()];
        ans[0]=1;
        ans[1]= s.charAt(1)=='*' ? 9 : s.charAt(1)=='0' ? 0 : 1;
        for(int i=2;i<ans.length;i++)
        {
            char a=s.charAt(i-1), b=s.charAt(i);
            if(b=='0')
            {
                ans[i]=((pairs_possible(a,b)%mod) * (ans[i-2]%mod))%mod;
                continue;
            }
            ans[i]= (((b=='*' ? 9 : 1)*ans[i-1]) % mod + (pairs_possible(a,b) * ans[i-2] % mod) % mod)% mod ;
        }
        return (int)ans[ans.length-1]%mod;
    }
    public int pairs_possible(char a, char b)
    {
        if(Character.isDigit(a) && Character.isDigit(b))
        {
            int k=(a-48)*10+(b-48);
            return k>=10 && k<=26 ? 1 : 0;
        }
        if(Character.isDigit(a) && b=='*')
        {
            if(a=='1')
                return 9;
            else if(a=='2')
                return 6;
            else
                return 0;
        }
        if(Character.isDigit(b) && a=='*')
        {
            if(b<='6')
                return 2;
            else 
                return 1;
        }
        return 15;
    }
}