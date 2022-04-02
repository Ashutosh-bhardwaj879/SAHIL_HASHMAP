
//https://www.codingninjas.com/codestudio/problems/subarrays-with-zero-sum_3161876?leftPanelTab=0
import java.util.*;

public class subarrayWithZeroSum {

    public static int countSubarrays(int n, int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int ans = 0;
        int prefixSum = 0;

        map.put(prefixSum, 1);

        // count we check occurence

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (map.containsKey(prefixSum)) {

                int count = map.get(prefixSum);
                ans += count;
                map.put(prefixSum, count + 1);
            } else {
                map.put(prefixSum, 1);
            }
        }

        return ans;
    }

}
