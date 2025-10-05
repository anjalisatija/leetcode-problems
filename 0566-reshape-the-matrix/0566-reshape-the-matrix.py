class Solution:
    # O(mn) time | O(mn) space
    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        m = len(mat) 
        n = len(mat[0])

        if m * n != r * c:
            return mat
        
        flat_mat = []
        for row in mat:
            for val in row:
                flat_mat.append(val)
    
        reshaped = []
        for i in range(r):
            row = []
            for j in range(c):
                val = flat_mat[i*c + j]
                row.append(val)
            reshaped.append(row)
        
        return reshaped