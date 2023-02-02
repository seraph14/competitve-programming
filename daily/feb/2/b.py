class Solution:
    def numberOfWays(self, s: str) -> int:
        count = defaultdict(int)
		
        for char in s:
            other = f"{1 - int(char)}"
            count[other+char] += count[other]
            count[char+other+char] += count[char+other]
            count[char] += 1
        
        return count["101"] + count["010"]
