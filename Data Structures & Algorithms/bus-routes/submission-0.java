class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target){
            return 0;
        }
        //stop to bus ->us stop pr ane vali buses
        Map<Integer,List<Integer>> stopToBuses=new HashMap<>();
        for(int bus=0;bus<routes.length;bus++){
            for(int stop: routes[bus]){
                stopToBuses
                    .computeIfAbsent(stop,key->new ArrayList<>())
                    .add(bus);
            }   
        }
        //BFS queue mein woh stops honge jaha hum curr pauch skte hai
        Queue<Integer> q=new ArrayDeque<>();

        //Starting point
        q.offer(source);

        //Ek stop ko dobbara traverse na kre uske liye set leneg
        Set<Integer> visitedStop=new HashSet<>();
        visitedStop.add(source);
        /*
         Ek bus ko sirf ek baar process karna hai.
         Agar bus 0 ko stop 1 se process kar liya,
         to stop 2 ya 7 se dobara process nahi karenge.
        */
        Set<Integer> visitedBuses=new HashSet<>();
        int busTaken=0;
        while(!q.isEmpty()){
            //queue ke current element same bfs level pr hai, ek level process krne ke bad hume exactly ek bus aur lenge
            int stopInCurr=q.size();
            busTaken++;
            for(int i=0;i<stopInCurr;i++){
                int currStop=q.poll();
                //current stop pe konsi bus ati h
                List<Integer> busAtStop=stopToBuses.getOrDefault(
                        currStop,
                        Collections.emptyList()
                    );
                for(int bus:busAtStop){
                    if(visitedBuses.contains(bus)){
                        continue;
                    }
                    //mark bus visited
                    visitedBuses.add(bus);
                    for(int nextStop:routes[bus]){
                        if(nextStop==target){
                            return busTaken;
                        }
                        //agar stop pehle visit nahi hua toh bfs queue m add kro
                        if(visitedStop.add(nextStop)){
                            q.offer(nextStop);
                        }
                    }
                }
            }
        }

    return -1;


        
    }
}