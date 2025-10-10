class Solution:
    def validSquare(self, p1: List[int], p2: List[int], p3: List[int], p4: List[int]) -> bool:
        def distance(p1, p2):
            return (p1[0] - p2[0])**2 + (p1[1] - p2[1])**2


        distances = [distance(p1, p2), distance(p1, p3), distance(p1, p4),
                    distance(p2, p3), distance(p2, p4), distance(p3, p4)]
        distances.sort()
        print(distances)
        if len(set(distances)) != 2:
            return False
        
        for i in range(4):
            if distances[i]!=distances[0]:
                return False
        for i in range(4,6):
            if distances[i]!=distances[5]:
                return False
        
        if distances[0] * 2 != distances[5]:
            return False
        
        return True