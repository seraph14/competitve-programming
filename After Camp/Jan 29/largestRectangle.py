class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        max_area = 0
        heights.append(-inf)
        
        for i, height in enumerate(heights):            
            curr_idx = i
            while stack and stack[-1][0] > height:
                prev_height, idx = stack.pop()
                curr_idx = idx
                max_area = max(max_area, prev_height * (i - idx))
            
            stack.append((height, curr_idx))
        
        return max_area
