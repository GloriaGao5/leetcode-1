/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer n1, Integer n2){
                if(Math.abs(n1) != Math.abs(n2)) return Math.abs(n1) - Math.abs(n2);
                else{
                    return n1-n2;
                }
            }
        });
        
        for(Interval interval : intervals){
            pq.offer(interval.start);
            pq.offer(-interval.end);
        }
        
        int maxRoom = 0;
        int count = 0;
        while(!pq.isEmpty()){
            int cur = pq.poll();
            if(cur > 0) count++;
            else count--;
            maxRoom = Math.max(maxRoom, count);
        }
        return maxRoom;
    }
}