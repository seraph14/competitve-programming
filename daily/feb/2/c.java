class Solution {
    public String[] reorderLogFiles(String[] logs) {
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator() {
           public int compare(Object o1, Object o2) {
               if (o1 == null && o2 == null) return 0;
               if (o1 == o2) return 0;
               if (o1 == null) return 1;
               if (o2 == null) return -1;
               String a = o1.toString();
               String b = o2.toString();
               String[] temp1 = a.split(" ");
               String[] temp2 = b.split(" ");
               String s1 = "";
               String s2 = "";
               for (int i = 1; i < temp1.length; i++) {
                   s1 += " " + temp1[i];
               }

               for (int i = 1; i < temp2.length; i++) {
                   s2 += " "  + temp2[i];
               }
               int c = s1.compareTo(s2);
               System.out.println(s1 + " " + s2 + " " + c);
               if (c == 0) 
                return temp1[0].compareTo(temp2[0]);
               return c;
           } 
        });
        
        Queue<String> queue = new LinkedList<>();
        
        String[] temp;
        for (String log : logs) {
            temp = log.split(" ");
            if (Character.isDigit(temp[1].charAt(0))) {
                queue.add(log);
            } else {
                pq.offer(log);    
            }
            
        }
        
        String[] res = new String[logs.length];
        int i = 0;
        while (pq.size() > 0) {
            res[i] = pq.poll();
            i++;
        }
        
        while (!queue.isEmpty()) {
            res[i] = queue.remove();
            i++;
        }
        
        return res;
    }
}
