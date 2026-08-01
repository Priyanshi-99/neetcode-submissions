class MedianFinder {
    private PriorityQueue<Integer> min=new PriorityQueue<>();
    private PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {

        
    }
    boolean even=true;
    
    public void addNum(int num) {
        if(even){
            min.add(num);
            max.add(min.poll());
        }
        else{
            max.add(num);
            min.add(max.poll());
        }
        even=!even;
        
    }
    
    public double findMedian() {
        if(even){
            return (max.peek()+min.peek())/2.0;
        }
        return max.peek();
        
    }
}
