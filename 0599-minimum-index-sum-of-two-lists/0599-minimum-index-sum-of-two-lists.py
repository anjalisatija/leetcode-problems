class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        dict1={}
        dict2={}
        for i in list1:
            dict1[i]=list1.index(i)
        for j in list2:
            dict2[j]=list2.index(j)  
        merged= {key: dict1.get(key, 0) + dict2.get(key, 0) for key in set(dict1) if key in dict2}
        min_value = min(merged.values())
        mini = [key for key, value in merged.items() if value == min_value]
        return mini   
              




                
        