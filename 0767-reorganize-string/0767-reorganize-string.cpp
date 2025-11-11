class Solution {
public:
    class node {
        public:
        char data;
        int count;

        node(char d,int c) {
            data = d;
            count = c;

        }
    };
    class comp {
        public:
        bool operator()(node* a,node* b) {
            return a->count < b->count;
        }
    };
    string reorganizeString(string s) {
        int arr[26] ={0};

        for(int i = 0; i < s.length(); i++) {
            arr[s[i]-'a']++;
        }
        priority_queue<node*,vector<node*>,comp> maxHeap;

        for(int i = 0;i < 26; i++) {
            if(arr[i]!=0) {
                maxHeap.push(new node(i+'a',arr[i]));
            }
        }
        string ans = "";
        while(maxHeap.size() > 1) {
            auto first = maxHeap.top();
            maxHeap.pop();
            auto second = maxHeap.top();
            maxHeap.pop();
            
            ans += first->data;
            ans += second->data;
            first->count -= 1;
            second->count -= 1;

            if(first->count) {
                maxHeap.push(first);
            }
            if(second->count) {
                maxHeap.push(second);
            }
        } 
        if(maxHeap.size()==1) {
            if(maxHeap.top()->count>1)
            return "";
            else
            ans += maxHeap.top()->data;
        }
        return ans;
    }
};