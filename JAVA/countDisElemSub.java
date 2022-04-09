
//https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1#
import java.util.*;

class SolutioncountDis {
    ArrayList<Integer> countDistinct(int A[], int n, int k) {
        int distinct = 0;
        ArrayList<Integer> answer = new ArrayList<Integer>();
        HashMap<Integer, Integer> memo = new HashMap<>();

        for (int i = 0; i < k; i++) {

            int currentVal = A[i];

            if (memo.containsKey(currentVal)) {
                memo.put(currentVal, memo.get(currentVal) + 1);
            } else {
                memo.put(currentVal, 1);
                distinct += 1;
            }

        }

        answer.add(distinct);

        int release = 0;

        for (int acquire = k; acquire < n; acquire++) {

            int discard = A[release];

            if (memo.containsKey(discard)) {
                memo.put(discard, memo.get(discard) - 1);
            }

            if (memo.get(discard) == 0) {
                memo.remove(discard);
                distinct -= 1;
            }

            release++;

            int currentVal = A[acquire];

            if (memo.containsKey(currentVal)) {
                memo.put(currentVal, memo.get(currentVal) + 1);
            } else {
                memo.put(currentVal, 1);
                distinct += 1;
            }

            answer.add(distinct);
        }
        return answer;

    }
}