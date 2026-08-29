class Tweet{
   
    int id;
    int time;
    public Tweet(int id,int time){
        this.id=id;
        this.time=time;
    }
}
class FeedEntry{
    Tweet tweet;
    int userId;
    int index;
    FeedEntry(Tweet tweet,int userId,int index){
        this.tweet=tweet;
        this.userId=userId;
        this.index=index;
    }
}

class Twitter {
    private int timestamp=0;
    private HashMap<Integer,List<Tweet>> tweets=new HashMap<>();
    private HashMap<Integer,Set<Integer>> followMap=new HashMap<>();

    public Twitter() {
   
    }
    
    public void postTweet(int userId, int tweetId) {
       tweets.computeIfAbsent(userId,k->new ArrayList<>()).add(new Tweet(tweetId,timestamp++));
        
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result=new ArrayList<>();
        followMap.computeIfAbsent(userId,k->new HashSet<>()).add(userId);

        PriorityQueue<FeedEntry> maxHeap=new PriorityQueue<>((a,b)->Integer.compare(b.tweet.time,a.tweet.time));
        for(int followeeId: followMap.get(userId)){
            List<Tweet> userTweets=tweets.get(followeeId);
            if(userTweets==null || userTweets.isEmpty()){
                continue;
            }

            int newestIndex=userTweets.size()-1;
            maxHeap.offer(new FeedEntry(userTweets.get(newestIndex),followeeId,newestIndex));
        }
        //repeatadly take the most recent avaiaalbe tweet
        while(!maxHeap.isEmpty() && result.size()<10){
            FeedEntry current=maxHeap.poll();
            result.add(current.tweet.id);
            //add the next older tweet from the same user
            if(current.index>0){
                List<Tweet> userTweets=tweets.get(current.userId);
                int previousId=current.index-1;
                maxHeap.offer(new FeedEntry(userTweets.get(previousId),current.userId,previousId));
            }
        }
      
        return result;


        
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        followMap.computeIfAbsent(followerId,k->new HashSet()).add(followeeId);
        
        
    }
    
    public void unfollow(int followerId, int followeeId) {

        if(followeeId==followerId) return;
        if(followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }

        
    }
}
