class Solution {
    public int rotatedDigits(int n) {
        int count =0;
        for(int i =0;i<=n;i++){
            int k =i;
            boolean valid = false;
            boolean isGoodNumber = true;
            while(k>0){
                int num= k%10;
                if(num==2 || num==5 || num==6 ||num==9 ){
                    valid = true;
                }
                if(num==3 ||num==4 || num==7){
                    isGoodNumber= false;
                    break;
                }
                k/=10;
            }
            if(isGoodNumber && valid){
                count++;
            }
        }
        return count;
    }
}