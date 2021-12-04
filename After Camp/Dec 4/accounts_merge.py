class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        parents = [-1 for _ in range(len(accounts))]
        
        def root(account):    
            while parents[account] >= 0:
                account = parents[account]
            return account
        
        def union(u, v):
            u, v = root(u), root(v)
            if u == v: return
            
            if parents[u] < parents[v]:
                parents[u] += parents[v]
                parents[v] = u
            else:
                parents[v] += parents[u]
                parents[u] = v
        
        emails = {}
        for i, account in enumerate(accounts):
            for j in range(1, len(account)):
                if account[j] in emails:
                    union(emails[account[j]], i)
                else:
                    emails[account[j]] = i
        
        newAccounts = defaultdict(list)
        
        for i, parent in enumerate(parents):
            account = root(i)
            newAccounts[account].extend(accounts[i][1:])
        
        result = []
        for account, emails in newAccounts.items():                
            uniqueEmails = list(set(emails))
            result.append([accounts[account][0]] + sorted(uniqueEmails))
        
        return result
