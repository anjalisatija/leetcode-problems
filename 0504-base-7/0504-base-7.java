class Solution {
    public String convertToBase7(int num) {
        return Integer.toString(num,7);
        /*String s ="";
        int temp = (num);
        num = Math.abs(num);
        int r;
        if(num == 0){
            return "0";
        }
        while(num>0){
            r = (int) (num%7);
            s = r + s;
            num /= 7;
        }
        if (temp < 0){
            return "-"+s;
        }
        return s;*/
    }
}