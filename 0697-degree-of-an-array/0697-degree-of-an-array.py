class Solution:
    def findShortestSubArray(self, nums: List[int]) -> int:
        n =  len(nums)   
        liste = set(nums)      
        liste_ = [] 
        new = []
        for i in liste :   
            res = nums.count(i)    
            liste_.append((res))  
        degree = max(liste_)  
        for i in liste  :     
            res =  nums.count(i)   
            if res == degree  : 
                new.append((i))     
        result,liste_2  = [] ,[]
        for i in  new :  
            for j in range(n)  :   
                if  i  ==  nums[j] and len(result)  < degree :    
                    result.append(j)  
            liste_2.append(result)
            result = []  
        listes = []
        for i in range (len(liste_2))  :   
            res = liste_2[i][-1] - liste_2[i][0] +  1    
            listes.append(res)   
        return  min(listes)
        

        