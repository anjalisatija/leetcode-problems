class MyHashMap:
    MAP = 10 **6 +5

    def __init__(self):
        self.lookup = [None] * self.MAP
        

    def put(self, key: int, value: int) -> None:
        self.lookup[key] = value
        

    def get(self, key: int) -> int:
        if self.lookup[key] is None:
            return -1
        return self.lookup[key]

    def remove(self, key: int) -> None:
        self.lookup[key] = None
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)