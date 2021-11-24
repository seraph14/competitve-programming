class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        def is_overlap(a, b):
            return a[0] <= b[1] <= a[1] or b[0] <= a[1] <= b[1] 
        
        res = []
        
        first_ptr = 0
        second_ptr = 0
        
        while first_ptr < len(firstList) and second_ptr < len(secondList):
            first_interval = firstList[first_ptr]
            second_interval = secondList[second_ptr]

            if is_overlap(first_interval, second_interval):
                start = max(first_interval[0], second_interval[0])
                end = min(first_interval[1], second_interval[1])
                res.append([start, end])
                
            if first_interval[1] < second_interval[1]:
                first_ptr += 1
            else:
                second_ptr += 1                

        return res
