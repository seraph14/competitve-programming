class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        answer = []
        remaining = set(range(1, n + 1))
        
        kth = k
        for i in range(1, n+1):
            remaining_perm = factorial(n - i)
            curr_k = remaining_perm
            
            nums = sorted(list(remaining))
            j = 0
            while curr_k < kth:
                curr_k += remaining_perm 
                j += 1
                
            kth -= curr_k - remaining_perm
            remaining.discard(nums[j])            
            answer.append(str(nums[j]))
            
        return "".join(answer)
