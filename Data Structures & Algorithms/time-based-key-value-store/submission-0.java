
class TimeMap {
    private String key;
    HashMap<String,TreeMap<Integer,String>> hm;
    

    public TimeMap() {
        hm=new HashMap<>();
        
 
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer,String> tmap=new TreeMap<>();
        if(!hm.containsKey(key)){
            tmap.put(timestamp,value);
            hm.put(key,tmap);

        }
        else{
        hm.get(key).put(timestamp,value);
        }

    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer,String> temp=hm.get(key);
        if(!hm.containsKey(key)){
            return "";
           
        }
        Integer timestampValue=temp.floorKey(timestamp);
        if(timestampValue!=null)return temp.get(timestampValue);
        else return "";
        
    }
}
