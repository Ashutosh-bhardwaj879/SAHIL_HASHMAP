import java.util.*;
//https://leetcode.com/problems/two-sum/
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> memo = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            
            int complement = target - nums[i];
            
            if(memo.containsKey(complement))
                return new int[]{memo.get(complement),i};
            
            memo.put(nums[i],i);
            //tc o(n)  sc o(n)
        }
        
        return new int[2];
    }
}