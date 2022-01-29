class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        max_area, n = 0, len(heights)
        
        for i in range(n + 1): 
            height = heights[i] if i < n else -inf
            next_idx = i
            while stack and stack[-1][0] > height:
                prev_height, prev_idx = stack.pop()
                curr_idx = prev_idx
                max_area = max(max_area, 
                               prev_height * (i - prev_idx)
                              )
            
            stack.append((height, next_idx))
        
        return max_area
