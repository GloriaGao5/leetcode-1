public class MovingAverage {
    Queue<Integer> queue;
    int size;
    int curSum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
        this.curSum = 0;
    }
    
    public double next(int val) {
        if(queue.size() < size){
            curSum += val;
            queue.offer(val);
            return (double)curSum / queue.size();
        }else{
            curSum -= queue.poll();
            curSum += val;
            queue.offer(val);
            return (double)curSum / size;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */