class Solution {
private:

    vector<vector<string>> res;
    string b;
    unordered_map <string,int> mpp;
public:
    void dfs(string word,vector<string>& seq){
        if(word==b){
            reverse(seq.begin(),seq.end());
            res.push_back(seq);
            reverse(seq.begin(),seq.end());
            return;
        }

        int steps = mpp[word];

        for(int i=0;i<word.size();i++){
            char temp = word[i];
            for(char ch='a';ch<='z';ch++){
                word[i]=ch;
                if(mpp.find(word)!=mpp.end()&&(mpp[word]+1 == steps)){
                    seq.push_back(word);
                    dfs(word,seq);
                    seq.pop_back();
                }
            }
            word[i] = temp;
        }
    }
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> wordset(wordList.begin(),wordList.end());
        if(!wordset.count(endWord)){
            return res;
        }
        b = beginWord;
        queue<string> q;
        q.push(beginWord);
        mpp[beginWord]=1;
        int size = beginWord.size();
        wordset.erase(beginWord);

        while(!q.empty()){
            string word = q.front();
            q.pop();
            int steps = mpp[word];

            if(word==endWord){
                break;
            }

            for(int i=0;i<size;i++){
                char temp = word[i];
                for(char ch='a';ch<='z';ch++){
                    word[i]=ch;
                    if(wordset.count(word)){
                        q.push(word);
                        wordset.erase(word);
                        mpp[word] = steps+1;
                    }
                }
                word[i] = temp;
            }
        }

        if(mpp.find(endWord)!= mpp.end()){
            vector<string> seq;
            seq.push_back(endWord);
            dfs(endWord, seq);
        }
        return res;
    }
};