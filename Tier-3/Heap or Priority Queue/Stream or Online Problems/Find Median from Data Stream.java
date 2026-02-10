// stream -> 4 4 8 2 0 9 2 3 1 7 3 


class MedianFinder {
    PriorityQueue<Integer> maxLeft;
    PriorityQueue<Integer> minRight;
    double median = 0;

    public MedianFinder() {
        maxLeft = new PriorityQueue<>(Collections.reverseOrder());
        minRight = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxLeft.size()==minRight.size()){  //oddth num
            minRight.add(num);
            maxLeft.add(minRight.remove());
        }else{  //eventh num
            maxLeft.add(num);
            minRight.add(maxLeft.remove());
        }
    }
    
    public double findMedian() {
        if(maxLeft.size()==minRight.size()){  //even values
            median = (maxLeft.peek()+minRight.peek())/2.0;
        }else{  //odd values
            median = maxLeft.peek()*1.0;
        }
        
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
