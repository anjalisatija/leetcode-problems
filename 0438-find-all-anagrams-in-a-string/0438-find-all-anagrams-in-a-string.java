
import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character , Integer> hms = new HashMap<>();
        HashMap<Character , Integer> hmp = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int left =0;
        for(int i=0 ; i< p.length() ; i++){
            char ch = p.charAt(i);
            hmp.put(ch , hmp.getOrDefault(ch  ,0)+1);
        } 
        for(int right =0 ; right < s.length(); right++){
            char ch = s.charAt(right);
            hms.put(ch ,hms.getOrDefault(ch , 0)+1);

            if(right -left+1 > p.length()){
                char leftCh = s.charAt(left);
                hms.put(leftCh , hms.get(leftCh)-1);
                if(hms.get(leftCh) ==0){
                    hms.remove(leftCh);
                }
                left++;
            }

            if(right -left +1 ==p.length()){
                boolean result = fun(hms, hmp);
                if(result){
                    list.add(left);
                } 
            }
        }

        return list;
    }

    public boolean fun(HashMap<Character, Integer> hms , HashMap<Character, Integer> hmp){
        if(hms.size() != hmp.size()){
            return false;
        }
        for(char key :hms.keySet()){
            if(!hmp.containsKey(key)){
                return false;
            }
        

        int a = hms.get(key);
        int b = hmp.get(key);
        if(a!=b){
            return false;
        }
        }
        return true;
    }
}