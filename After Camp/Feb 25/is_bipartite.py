class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        n = len(graph)
        partitions = [0 for _ in range(n)]
        visited = [False for _ in range(n)]

        def dfs(node, partition):
            nonlocal partitions, visited
            
            visited[node] = True
            for neighbor in graph[node]:
                if (partitions[neighbor] and 
                    partitions[neighbor] != partition):
                    return False
                
                partitions[neighbor] = partition
                if not visited[neighbor]:
                    if not dfs(neighbor, partitions[node]):
                        return False
            
            return True
        
        for i in range(n):
            if not visited[i]:
                partitions[i] = 1
                if not dfs(i, 2):
                    return False

        return True
