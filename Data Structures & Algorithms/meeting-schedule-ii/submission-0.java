/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals == null || intervals.size() == 0) return 0;

        // sort by start time
        intervals.sort((a, b) -> a.start - b.start);

            PriorityQueue<Integer> endT=new PriorityQueue<>();
              endT.add(intervals.get(0).end);

            for(int i=1;i<intervals.size();i++){
          
            if(intervals.get(i).start>=endT.peek()){
                endT.poll();
            }
            endT.add(intervals.get(i).end);

            }
            return endT.size();



    }
}
