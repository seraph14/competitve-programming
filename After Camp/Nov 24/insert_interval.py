class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        def is_overlap(a, b):
            return a[0] <= b[0] <= a[1] or b[0] <= a[0] <= b[1]
        
        def is_after(a, b):
            return a[1] > b[1]
        
        res = []        
        i = 0
                
        while i < len(intervals):
            if not (is_after(newInterval, intervals[i]) 
                    or is_overlap(intervals[i], newInterval)):
                break
                
            interval = intervals[i]
            
            if is_overlap(interval, newInterval):
                newInterval[0] = min(interval[0], newInterval[0])
                newInterval[1] = max(interval[1], newInterval[1])
            else:
                res.append(interval)            
            
            i += 1
        
        res.append(newInterval)
        res.extend(intervals[min(i, len(intervals)):])
            
        return res
