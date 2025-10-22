class Solution:
    def fallingSquares(self, positions: List[List[int]]) -> List[int]:
        coords = set()
        for left, size in positions:
            coords.add(left)
            coords.add(left + size)

        coord_map = {coord: idx for idx, coord in enumerate(sorted(coords))}

        heights = [0] * len(coord_map)
        
        result = []
        max_height_so_far = 0
        
        for left, size in positions:
            left_idx = coord_map[left]
            right_idx = coord_map[left + size]

            current_max_height = max(heights[left_idx:right_idx])

            new_height = current_max_height + size

            for i in range(left_idx, right_idx):
                heights[i] = new_height
            max_height_so_far = max(max_height_so_far, new_height)
            result.append(max_height_so_far)
        
        return result