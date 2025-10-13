import java.util.HashMap;
class Solution {
    public List<String> removeAnagrams(String[] words) {
        ArrayList<String> unique = new ArrayList<>();

        boolean isAnagram = false;
        String temp = "";
        for(int i=0;i< words.length; i++){
            String current = words[i];
            char[] letterList = current.toCharArray();
            
            isAnagram = isAnagram(temp.toCharArray(), current.toCharArray());

            if(i==0 || !isAnagram){
                unique.add(current);
                temp = current;
            }
        }

        return unique;
    }
    
    public boolean isAnagram(char[] first,char[] second) {
        
        if(first.length!=second.length) {
            return false;
        }
        
        int[] count1=new int[256];
        
        int[] count2=new int[256];
        
        for(char c:first) {
            int v=(int)c;
            count1[v]++;
        }
        
        for(char c:second) {
            int v=(int)c;
            count2[v]++;
        }
        
        for(int i=0;i<256;i++) {
            if(count1[i]!=count2[i]) {
                return false;
            }
        }
        
        return true;
    }

    


}