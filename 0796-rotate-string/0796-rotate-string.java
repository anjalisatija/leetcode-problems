class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        int index = -1;
        s = s+s;
        index = s.indexOf(goal);
        if(index != -1){
            return true;
        }else{
            return false;
        }
        
        
    }
}