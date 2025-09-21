class Solution {
    public int lastRemaining(int n) {
        int start = 1, gap = 1,step = 1;
        while(n > 1){
            if(step % 2 != 0 ||( n % 2 != 0 && step % 2 == 0)){
                start = start + gap;
            }
            step++;
            n = n / 2;
            gap = gap * 2;
        }
        return start;
    }
}