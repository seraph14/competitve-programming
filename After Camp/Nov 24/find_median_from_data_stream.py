class MedianFinder:

    def __init__(self):
        self.lower = []
        self.upper = []
        self.count = 0

    def addNum(self, num: int) -> None:
        self.count += 1
        
        if self.lower:
            largest = -heapq.heappop(self.lower)
            
            if largest > num:
                heapq.heappush(self.upper, largest)
                heapq.heappush(self.lower, -num)
            else:
                heapq.heappush(self.lower, -largest)
                heapq.heappush(self.upper, num)
        
        else:
            heapq.heappush(self.upper, num)    
            
        mid = (self.count) // 2
        mid += 1
        
        while len(self.upper) > mid:
            curr = heapq.heappop(self.upper)
            heapq.heappush(self.lower, -curr)

    def findMedian(self) -> float:
        isEven = self.count % 2 == 0
        
        if isEven:
            first = heapq.heappop(self.upper)
            second = heapq.heappop(self.upper)
            
            heapq.heappush(self.upper, first)
            heapq.heappush(self.upper, second)
            median = (first + second) / 2
            
        else:
            median = heapq.heappop(self.upper)
            heapq.heappush(self.upper, median)
        
        return median
        


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
