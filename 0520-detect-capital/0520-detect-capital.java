class Solution {
    public boolean detectCapitalUse(String word) {

        String as = word.substring(0,1);
        String aas = word.substring(1);

        if(word.equals(word.toUpperCase()) || word.equals(word.toLowerCase())){
            return true;
        }
        else if( (as.equals(as.toUpperCase())) && (aas.equals(aas.toLowerCase())) ){
            return true;
        }
        else{
            return false;
        }
    }
}