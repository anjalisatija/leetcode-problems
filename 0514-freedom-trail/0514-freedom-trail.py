class Solution:
    def findRotateSteps(self, ring: str, key: str) -> int:
        ln_ring = len(ring)
        cumulative_lens = [[min(i, ln_ring - i) for i in range(ln_ring)]]
        cumulative_lens.extend([[float('inf')] * ln_ring for _ in range(len(key))])

        for key_num, key_ltr in enumerate(key):
            for new_ring_pos, ring_ltr in enumerate(ring):
                if key_ltr != ring_ltr:
                    continue

                min_sum_len = float('inf')

                for prev_ring_pos, prev_ltr_sum_len in enumerate(cumulative_lens[key_num]):
                    if prev_ltr_sum_len == float('inf'):
                        continue

                    clk_w_len = abs(prev_ring_pos - new_ring_pos)
                    a_clk_len = ln_ring - clk_w_len

                    new_sum_len = min(clk_w_len, a_clk_len) + prev_ltr_sum_len + 1
                    min_sum_len = min(min_sum_len, new_sum_len)

                cumulative_lens[key_num + 1][new_ring_pos] = min_sum_len

        return min(cumulative_lens[-1])