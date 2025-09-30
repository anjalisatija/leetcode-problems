class Solution {
public:
    vector<int> constructRectangle(int area) {
         int a[2] = {}; 
        int w = floor(sqrt(area)), l = 0;
        while (area % w != 0)   
        {
            w--;
        }
    
        l = area / w;  
    
        a[0] = l;
        a[1] = w;
    
        return {a[0], a[1]};
    }
};