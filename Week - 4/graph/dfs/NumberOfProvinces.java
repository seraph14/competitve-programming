class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] isVisited = new boolean[isConnected.length];        
        int current = 0;
        int province = 1;
        Stack<Integer> stack = new Stack<>();
        
        stack.push(current);
        while (!stack.isEmpty()) {
            current = stack.pop();
            
            for (int i = 0; i < isConnected.length; i++) {
                if (!isVisited[i] && isConnected[current][i] == 1) {
                    isVisited[i] = true;
                    stack.push(i);
                }
            }
            
            if (stack.isEmpty()) {
                int i = 0;
                for (boolean v : isVisited) {
                    if (!v) {
                        stack.push(i);
                        break;
                    }  
                    i++;
                }
                
                if (!stack.isEmpty()) {
                    province++;
                }
            }
            
        }
        
        return province;
    }
}
