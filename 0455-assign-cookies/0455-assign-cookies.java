class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int temp=0;
        int ans=0;
        for(int i=0;i<s.length;i++){
            if(temp>=g.length)break;
            if(s[i] >= g[temp]){ans++;temp++;}
             
        }
        return ans;
    }
}