import java.util.*;

class largestSubarray {

    int maxLen(int[] arr, int n) {
        // Your code here
        int prefixSum = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(prefixSum, -1);

        for (int i = 0; i < n; i++) {

            if (arr[i] == 0)
                prefixSum += -1;
            else
                prefixSum += 1;

            if (map.containsKey(prefixSum)) {

                int currentIndex = i;
                int lastIndex = map.get(prefixSum);

                ans = Math.max(ans, currentIndex - lastIndex);

            } else {
                int currentIndex = i;
                map.put(prefixSum, currentIndex);
            }
        }
        return ans;
    }
}