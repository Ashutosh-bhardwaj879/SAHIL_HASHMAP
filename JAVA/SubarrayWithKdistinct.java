import java.util.*;

//https://leetcode.com/problems/subarrays-with-k-different-integers/
class Solution992 {

    public int subarraysWithKDistinct(int[] nums, int k) {
        int AtMostK = subarraysWithATMOSTKDistinct(nums, k);
        int AtMostKminusOne = subarraysWithATMOSTKDistinct(nums, k - 1);
        // to find exactly k we minus atmost k and atmostk-1
        return AtMostK - AtMostKminusOne;
    }

    private int subarraysWithATMOSTKDistinct(int[] nums, int k) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        int distinct = 0;
        int ans = 0;
        int release = 0;

        for (int acq = 0; acq < nums.length; acq++) {

            Integer currentElem = nums[acq];

            if (memo.containsKey(currentElem)) {
                memo.put(currentElem, memo.get(currentElem) + 1);
            } else {
                memo.put(currentElem, 1);
                distinct += 1;
            }

            while (distinct > k) {

                Integer discard = nums[release];
                memo.put(discard, memo.get(discard) - 1);
                release += 1;
                if (memo.get(discard) == 0) {
                    memo.remove(discard);
                    distinct -= 1;
                }

            }
            ans += (acq - release + 1);
        }

        return ans;
    }
}
