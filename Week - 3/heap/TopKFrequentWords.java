class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator() {
            public int compare(Object o1, Object o2) {
                if (o1 == null && o2 == null) return 0;
                if (o1 == o2) return 0;
                String a = o1.toString();
                String b = o2.toString();
                if (map.get(a) == map.get(b)) {
                    return b.compareTo(a);
                } return map.get(a) - map.get(b);
            }
        });
        for (String key : map.keySet()) {
            pq.offer(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        List<String> res = new ArrayList<String>(Collections.nCopies(k, ""));
        int i = k - 1;
        while (pq.size() > 0) {
            res.set(i--, pq.poll());
        }
        
        return res;
    }
}
