class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || numRows>=s.length()) return s;

        int currentIndex=0;
        int dir=1;//going up to down
        List<StringBuilder> ls=new ArrayList<>();
        StringBuilder res=new StringBuilder();
        for(int i=0;i<numRows;i++){
            ls.add(new StringBuilder());
        }

        for(char c:s.toCharArray()){
            ls.get(currentIndex).append(c);
            if(currentIndex==0){
                dir=1;
            }
            if(currentIndex==numRows-1){
                dir=-1;
            }
            currentIndex+=dir;

        }
        for(StringBuilder i:ls){
            res.append(i);
            

        }
        return res.toString();

        
    }
}