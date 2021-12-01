class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        
        def isValidPath(state, position, emptyCells):
            nonlocal grid
            row, col = position
            return grid[row][col] == 2 and len(state)-2 == emptyCells
        
        def isValidMove(state, row, col):
            nonlocal grid
            return (0 <= row < len(grid) and
                    0 <= col < len(grid[row]) and
                    grid[row][col] != -1 and
                   (row, col) not in state)
        
        def getCandidates(state, row, col):            
            directions = ((0, -1), (-1, 0), (1, 0), (0, 1))
            candidates = set()
            
            for dx, dy in directions:
                nextRow, nextCol = row + dx, col + dy
                
                if isValidMove(state, nextRow, nextCol):
                    candidates.add((nextRow, nextCol))
                    
            return candidates
        
        paths = 0
        def search(state, row, col, emptyCells):
            nonlocal grid, paths
            if isValidPath(state, (row, col), emptyCells):
                paths += 1
                return
            
            for nextRow, nextCol in getCandidates(state, row, col):
                position = (nextRow, nextCol)
                state.add(position)
                search(state, nextRow, nextCol, emptyCells)
                state.remove(position)
                
        
        state = set()
        
        emptyCells = 0
        row, col = -1, -1
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 1:
                    row, col = i, j
                    state.add((row, col))
                    
                if grid[i][j] == 0:
                    emptyCells += 1
        
        search(state, row, col, emptyCells)
        return paths
