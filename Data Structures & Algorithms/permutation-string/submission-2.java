class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()> s2.length()){
            return false;
        }
        int[] arr=new int[26];
        int[] arr2=new int[26];
        for(int i=0;i<s1.length();i++){
             arr[s1.charAt(i)-'a']++;
              arr2[s2.charAt(i)-'a']++;
        }
        if(java.util.Arrays.equals(arr, arr2)){
            return true;
        }
        int l=0;
        for(int r=s1.length();r<s2.length();r++){
            arr2[s2.charAt(r)-'a']++;
            arr2[s2.charAt(l)-'a']--;
            l++;
            if(java.util.Arrays.equals(arr, arr2)){
            return true;
        }
            
        
        }
       return false; 
    }
}
