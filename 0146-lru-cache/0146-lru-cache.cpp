class LRUCache {
public:
    int capacity;
    int taken;
    unordered_map<int, int> hashTable;
    unordered_map<int, pair<int, int>>::iterator ft; //first (<first, last>)
    unordered_map<int, pair<int, int>>::iterator lt; //last (<first, last>)
    unordered_map<int, pair<int, int>> LRU;
    LRUCache(int cap) {
        capacity = cap;
        taken = 0;
        lt = LRU.end();
        ft = LRU.end();
    }
    
    int get(int key) {
        if (hashTable.find(key) == hashTable.end())
            return -1;
        if (ft->first == key && taken == 1)
            return hashTable[key];
        unordered_map<int, pair<int, int>>::iterator it = LRU.find(key);
        if (it != ft && it != lt) {
            LRU.find(it->second.first)->second.second = LRU.find(it->second.second)->first;
            LRU.find(it->second.second)->second.first = LRU.find(it->second.first)->first;
            ft->second.first = key;
            it->second.first = -1;
            it->second.second = ft->first;
            ft = it;
        } else if (it != ft && it == lt) {
            LRU.find(it->second.first)->second.second = -1;
            lt = LRU.find(it->second.first);
            ft->second.first = key;
            it->second.first = -1;
            it->second.second = ft->first;
            ft = it;
        }
        return hashTable[key];
    }
    
    void put(int key, int val) {
        if (hashTable.find(key) != hashTable.end()) {
            unordered_map<int, pair<int, int>>::iterator it = LRU.find(key);
            if (it != ft && it != lt) {
                LRU.find(it->second.first)->second.second = LRU.find(it->second.second)->first;
                LRU.find(it->second.second)->second.first = LRU.find(it->second.first)->first;
                ft->second.first = key;
                it->second.first = -1;
                it->second.second = ft->first;
                ft = it;
            } else if (it != ft && it == lt) {
                LRU.find(it->second.first)->second.second = -1;
                lt = LRU.find(it->second.first);
                ft->second.first = key;
                it->second.first = -1;
                it->second.second = ft->first;
                ft = it;
            }
            hashTable[key] = val;
        } else if (taken < capacity) {
            if (taken == 0) {
                LRU[key] = {-1, -1};
                ft = LRU.find(key);
                lt = LRU.find(key);
            } else {
                LRU[key] = {-1, ft->first};
                ft->second.first = key;
                ft = LRU.find(key);
            }
            ++taken;
            hashTable[key] = val;
        } else {
            hashTable.erase(lt->first);
            if (taken != 1) {
                int toDel = lt->first;
                LRU.find(lt->second.first)->second.second = -1;
                lt = LRU.find(lt->second.first);
                LRU.erase(toDel);
                LRU[key] = {-1, ft->first};
                ft->second.first = key;
                ft = LRU.find(key);
            } else {
                LRU.erase(ft->first);
                LRU[key] = {-1, -1};
                ft = LRU.find(key);
                lt = LRU.find(key);
            }
            hashTable[key] = val;
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */