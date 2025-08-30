class Solution {
public:
    vector<int>nextsmaller(vector<int>arr){
        stack<int>s;
        s.push(-1);
        vector<int>ans(arr.size());
        for (int i=arr.size()-1;i>=0;i--){
            while (s.top()!=-1 && arr[s.top()]>=arr[i]){s.pop();}
            ans[i]=s.top();
            s.push(i);
        }
        return ans;
    }
    vector<int>prevsmaller(vector<int>arr){
        stack<int>s;
        s.push(-1);
        vector<int>ans(arr.size());
        for (int i=0;i<ans.size();i++){
            while (s.top()!=-1 && arr[s.top()]>=arr[i]){s.pop();}
            ans[i]=s.top();
            s.push(i);
        }
        return ans;
    }
    int largestRectangleArea(vector<int>& heights) {
        int ans=0;
        vector<int>left=prevsmaller(heights);
        vector<int>righ=nextsmaller(heights);
        for (int i=0;i<heights.size();i++){
            if (righ[i]==-1){righ[i]=heights.size();}
            ans=max(ans,(righ[i]-left[i]-1)*heights[i]);
        }
        return ans;
    }
    int maximalRectangle(vector<vector<char>>& matrix) {
        vector<int>ans(matrix.size(),0);
        int answer=0;
        for (int i=0;i<matrix[0].size();i++){
            for (int j=0;j<matrix.size();j++){
                if (matrix[j][i]=='1'){ans[j]++;}
                else {ans[j]=0;}
            }
            answer=max(answer,largestRectangleArea(ans));
        }
        return answer;
    }
};