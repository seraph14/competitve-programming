class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:        
        
        def isValidState(state):
            return sum(state) == target        
        
        def getCandidates(state):
            if not state:
                return candidates.copy()
            
            remainingCandidates = []
            for candidate in candidates:
                if state[-1] >= candidate:
                    remainingCandidates.append(candidate)
            return remainingCandidates
        
        def search(state, solutions):            
            if isValidState(state):
                solutions.append(state.copy())
                return
            
            if sum(state) > target:
                return
            
            for candidate in getCandidates(state):
                state.append(candidate)
                search(state, solutions)
                state.pop()
            
        solutions = []
        search([], solutions)
    
        return solutions
