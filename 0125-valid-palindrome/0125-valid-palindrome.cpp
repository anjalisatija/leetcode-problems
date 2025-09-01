class Solution {
public:
    bool isPalindrome(string s) {
        string temp = "";
        for (char c : s) {
            if (isalnum(c)) { 
                temp += tolower(c);
            }
        }
        s = temp;
        int sizee=s.size();
        int q=0;
        for(int i=0,k=1;i<sizee;i++,k++){
            if(s[i]==s[sizee-k]){
                q++;
            }
            else{
                q--;
            }
        }
        if(q==sizee){

        return true;
        }
        else{
            return false;
        }
    }
};