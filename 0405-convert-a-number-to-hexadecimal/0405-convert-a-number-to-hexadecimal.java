class Solution {
    public String toHex(int num) {
        if(num==0) return "0";
        StringBuilder str = new StringBuilder();
        int mask = 15;
        while(num!=0){
            int x = mask & num;
            num>>>=4;
            if(x<=9) str.insert(0,x);
            else str.insert(0,(char)('a'+(x-10)));
        }

        return str.toString();
    }
}