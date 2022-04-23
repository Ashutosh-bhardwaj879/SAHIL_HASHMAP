
//https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1
import java.util.*;

class PairGivenDifference {
    public boolean findPair(int nums[], int size, int diff) {
        // code here.
        // a-b = diff
        // a=diff+b --->1
        // b = a-diff --->2
        HashMap<Integer, Integer> memo = new HashMap<>();

        for (int i = 0; i < size; i++) {

            int complement1 = diff + nums[i];
            int complement2 = nums[i] - diff;
            if (memo.containsKey(complement1) || memo.containsKey(complement2))
                return true;

            memo.put(nums[i], 1);
            // tc o(n) sc o(n)
        }

        return false;
    }
}