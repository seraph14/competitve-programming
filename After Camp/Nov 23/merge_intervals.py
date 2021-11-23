class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda interval: interval[0])
        
        res = []
        res.append(intervals[0])
        
        def is_overlap(a, b):
            return a[0] <= b[1] and b[0] <= a[1]
        
        for i in range(1, len(intervals)):
            if res and not is_overlap(intervals[i], res[-1]):
                res.append(intervals[i])
            else:
                res[-1][0] = min(res[-1][0], intervals[i][0])
                res[-1][1] = max(res[-1][1], intervals[i][1])
        
        return res
