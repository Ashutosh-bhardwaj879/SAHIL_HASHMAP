
//https://leetcode.com/problems/rabbits-in-forest/
import java.util.*;

class RabbitsInForest {
    public int numRabbits(int[] answers) {
        /**
         *
         * !TC O(N) SC O(N)
         */
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

        double answer = 0;

        for (int currentElem : answers) {
            if (memo.containsKey(currentElem)) {
                memo.put(currentElem, memo.get(currentElem) + 1);
            } else {
                memo.put(currentElem, 1);
            }
        }

        for (Integer Key : memo.keySet()) {
            double groupSize = Key + 1; // ! 2's groupsize => _ _ _
            /**
             * !this is important we have to take ceil to accomodate
             * * the number of rabbits
             * * group Size = 2 + 1 = 3
             * ! numGroup = 4 / 3 => 2
             */
            double numGroups = Math.ceil(memo.get(Key) / groupSize);
            answer += (numGroups * groupSize);
        }

        return (int) answer;
    }
}