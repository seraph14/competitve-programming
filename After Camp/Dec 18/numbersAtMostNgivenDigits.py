class Solution:
    def atMostNGivenDigitSet(self, digits: List[str], n: int) -> int:
        cache = [1]
        for i in range(1, len(str(n))):
            cache.append(len(digits) ** i)
        
        count = sum(cache) - 1
        
        def lessOrEqual(target, digits):
            less, equal = 0, 0
            for digit in digits:
                less += 1 if digit < target else 0
                equal += 1 if digit == target else 0
            return (less, equal)
        
        target = str(n)
        def helper(index):
            if index == len(target):
                return 1 
            
            less, equal = lessOrEqual(target[index], digits)
            return less * cache[-index-1] + (equal * helper(index+1))        
        
        return count + helper(0)
