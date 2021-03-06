class MedianFinder {
    int size;
    double median;
    PriorityQueue<Integer> left, right;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        left  = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        right = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        
        size = 0;
        median = 0;
    }
    
    public void addNum(int num) {
        size ++;
        if (num < median) 
            left.add(num);
        else right.add(num);
        if (left.size() > size / 2)
            right.add(left.poll());
        if (right.size() > (size + 1) / 2)
            left.add(right.poll());
        
        if (size % 2 == 0)
            median = (double)(left.peek() + right.peek()) / 2;
        else median = (double)right.peek();
    }
    
    public double findMedian() {
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */