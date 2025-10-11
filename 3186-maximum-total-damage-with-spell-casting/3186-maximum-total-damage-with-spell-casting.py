from collections import Counter
from typing import List

class Solution:
    def maximumTotalDamage(self, power: List[int]) -> int:
        damage_counts = Counter(power)
        sorted_damages = sorted(damage_counts.keys())
        
        if not sorted_damages:
            return 0
        
        M = len(sorted_damages)
        dp = [0] * M
        
        first_damage = sorted_damages[0]
        dp[0] = first_damage * damage_counts[first_damage]
        
        for i in range(1, M):
            current_damage = sorted_damages[i]
            count = damage_counts[current_damage]
            
            # Case 1: Don't take current_damage
            damage_not_taken = dp[i-1]
            
            # Case 2: Take current_damage
            max_prev_damage = 0
            safe_damage_upper_bound = current_damage - 3
            
            safe_prev_index = -1
            for j in range(i - 1, -1, -1):
                prev_damage = sorted_damages[j]
                if prev_damage <= safe_damage_upper_bound:
                    safe_prev_index = j
                    break
            
            if safe_prev_index != -1:
                max_prev_damage = dp[safe_prev_index]
            
            damage_taken = count * current_damage + max_prev_damage
            
            dp[i] = max(damage_not_taken, damage_taken)
            
        return dp[M-1]