class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        res = k
        for i in range(len(blocks) - k):
            res = min(res, blocks[i:i+k].count("W"))
        
        return res
