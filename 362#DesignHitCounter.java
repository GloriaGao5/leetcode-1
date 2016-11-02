public class HitCounter {
    int totalCounter = 0;
    LinkedHashMap<Integer, Integer> bucketMap = new LinkedHashMap<>();
    int minTimestamp = 0;
    
    /** Initialize your data structure here. */
    public HitCounter() {
    }
    
    private void cleanup(int timestamp) {
        int cleanupCounter = 0;

        Iterator<Map.Entry<Integer, Integer>> entries = bucketMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> me = entries.next();
            cleanupCounter++;
            if (timestamp - me.getKey() >= 300) {
                totalCounter -= me.getValue();
                entries.remove();
            } else {
                minTimestamp = me.getKey();
                break;
            }
        }
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(timestamp > minTimestamp){
            cleanup(timestamp);
        }
        bucketMap.put(timestamp, bucketMap.getOrDefault(timestamp, 0) + 1);
        totalCounter ++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if(timestamp > minTimestamp){
            cleanup(timestamp);
        }
        return totalCounter;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */