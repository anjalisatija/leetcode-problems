class MapSum {
public:
    unordered_map<string,int>mpp;
    MapSum() {
        
    }
    
    void insert(string key, int val) {
        mpp[key]=val;
    }
    
    int sum(string prefix) {
        int sum=0;
        for(auto [key,val]:mpp){
            if(key.substr(0,prefix.size())==prefix) sum+=val;
        }
        return sum;
    }
};

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum* obj = new MapSum();
 * obj->insert(key,val);
 * int param_2 = obj->sum(prefix);
 */