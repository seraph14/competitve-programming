class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        self.s = s
        self.p = p
        
        @cache
        def match(p_idx, s_idx):
            if (s_idx == len(self.s) and
                p_idx == len(self.p)):
                return True
            
            if p_idx == len(self.p):
                return False
            
            next_p_idx = 1
            if (p_idx + 1 < len(self.p) and
                self.p[p_idx + 1] == "*"):
                if match(p_idx + 2, s_idx):
                    return True
                next_p_idx = 0
            
            if s_idx < len(self.s) and (
                self.p[p_idx] == "." or 
                self.p[p_idx] == self.s[s_idx]):
                return match(p_idx + next_p_idx, s_idx + 1)
            
            return False
        
        return match(0, 0)
