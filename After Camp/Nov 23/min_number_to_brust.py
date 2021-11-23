class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort(key=lambda point: point[1])
        curr_end = points[0][1]
        
        count = 1
        for i in range(1, len(points)):
            if points[i][0] > curr_end:
                count += 1
                curr_end = points[i][1]
        return count
        
