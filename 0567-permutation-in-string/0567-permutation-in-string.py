class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        sizeS1 = len(s1)
        sizeS2 = len(s2)

        if sizeS1 > sizeS2:
            return False
        
        mapS1 = {}
        windowMap = {}
        for i in range(sizeS1):
            mapS1[s1[i]] = mapS1.get(s1[i], 0) + 1
            windowMap[s2[i]] = windowMap.get(s2[i], 0) + 1
        
        for i in range(sizeS1, sizeS2):
            if windowMap == mapS1:
                return True
            
            windowMap[s2[i - sizeS1]] -= 1
            if windowMap[s2[i - sizeS1]] == 0:
                del windowMap[s2[i - sizeS1]]

            windowMap[s2[i]] = windowMap.get(s2[i], 0) + 1

        

        # print(mapS1)
        # print(windowMap)
        
        return windowMap == mapS1