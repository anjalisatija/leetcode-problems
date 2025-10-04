class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        result = []
        reverse_ = True

        for i in range(0, len(s), k):
            if reverse_:
                insert_ = s[i : i + k][::-1]
                reverse_ = False
            else:
                insert_ = s[i : i + k]
                reverse_ = True

            result.extend(insert_)

        return "".join(result)