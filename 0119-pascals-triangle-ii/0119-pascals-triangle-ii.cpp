class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<vector<int>> v;
        for(int i=0;i<rowIndex+1;i++){
            vector<int> row;
            for(int j=0;j<i+1;j++){
                if(j==0||j==i){
                    row.push_back(1);
                }
                else{
                    row.push_back(v[i-1][j-1]+v[i-1][j]);
                }
            }
            v.push_back(row);
            
        }
    return v[rowIndex] ;
    }
};