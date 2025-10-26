# Approach


# Insights 
# implement the following functions for hash
# - add(key) - inserts the value key into the HashSet
# - contains(key) - returns whether the value key exists in the HashSet or not 
# - remove(key) removes the value key in the HashSet. If key does not exist in the HashSet, do nothing. 

# use python dict -> {1: True, 2: True, etc.}

# add => 
# if key exists - don't add 
# if key does not exist - 

# contains => return key in hashset

# remove => del hashset[key]

# Edge Cases
# adding a value more than once 
# should anything be stored in the value


# Summarized approach


class MyHashSet:

    def __init__(self):
        self.hashset = {}

    def add(self, key: int) -> None:
        if not self.contains(key):
            self.hashset[key] = True
        
    def remove(self, key: int) -> None:
        if self.contains(key):
            del self.hashset[key]

    def contains(self, key: int) -> bool:
        return key in self.hashset


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)