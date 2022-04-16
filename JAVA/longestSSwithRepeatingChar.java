//https://leetcode.com/problems/longest-substring-without-repeating-characters/
import java.util.*;
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        //FOR COUNT -- we check:: frequence
        //FOR LENGTH -- we maintian :: indexes
        int release = 0;
        HashMap<Character,Integer> memo = new HashMap<Character,Integer>();
        
        for(int acq =0 ;acq < s.length();acq ++){
            Character currentChar = s.charAt(acq);
            
            //we can release character till no repeation is there
            if(memo.containsKey(currentChar) && release <= memo.get(currentChar)){
                release = memo.get(currentChar) + 1;
            }
            //we can put character if no repetiion is found
            //but we should mainitina its index also which is nothign but acquire
            memo.put(currentChar,acq);
            ans = Math.max(ans,acq - release + 1);
        }
        return ans;
    }
}
//TestCase FOR [release <= memo.get(currentChar)] CONDITION CHECK "bb"
/*
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        //FOR COUNT -- we check:: frequence
        //FOR LENGTH -- we maintian :: indexes
        int release = 0;
        HashMap<Character,Integer> memo = new HashMap<Character,Integer>();
        
        for(int acq =0 ;acq < s.length();acq ++){
            Character currentChar = s.charAt(acq);
            
            //we can release character till no repeation is there
            // if(memo.containsKey(currentChar) && release <= memo.get(currentChar)){
            //     release = memo.get(currentChar) + 1;
            // }
            
            while(release < acq && memo.containsKey(currentChar)){
                Character discard = s.charAt(release);
                memo.remove(discard);
                release +=1;
            }
            
            //we can put character if no repetiion is found
            //but we should mainitina its index also which is nothign but acquire
            memo.put(currentChar,acq);
            ans = Math.max(ans,acq - release + 1);
        }
        return ans;
    }
}
//TestCase FOR [release <= memo.get(currentChar)] CONDITION CHECK "bb"
//TC - O(2N)
*/