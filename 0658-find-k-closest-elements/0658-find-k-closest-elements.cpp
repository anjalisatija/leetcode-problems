class Solution {
public:
    vector<int>findClosestElements(vector<int>&arr,int k,int x){
         int n=arr.size();
    vector<pair<int,int>>diff;
    for(int i=0;i<n;i++){
        diff.push_back({abs(arr[i]-x),arr[i]});
    }
    sort(diff.begin(),diff.end());
    vector<int>result;
    for(int i=0;i<k;i++){
        result.push_back(diff[i].second);
    }
    sort(result.begin(),result.end());
    return result;
}
    
};