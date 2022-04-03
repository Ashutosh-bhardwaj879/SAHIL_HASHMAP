import java.util.*;

class Solution349 {
    public int[] intersection(int[] arr1, int[] arr2) {
        // K--> ARRAY ELEMTS
        // V->T or F
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        // map dod not contains elemnts of arr1 put it in and put true also
        // but just 1 time it will put
        for (int key : arr1) {
            if (!map.containsKey(key)) {
                map.put(key, true);
            }
        }
        ArrayList<Integer> al = new ArrayList<>();

        // if map(filled before with arr1 elments) contains elemnt of arr2 and
        // those lements are true also then
        // fill those alements in AL<> al and put false in map for those elemnts
        for (int key : arr2) {
            if (map.containsKey(key) && map.get(key) == true) {
                al.add(key);
                map.put(key, false);
            }

        }
        int n = al.size();

        int[] arr = new int[n];
        // int[] arr = al.stream().mapToInt(i -> i).toArray();

        for (int i = 0; i < n; i++) {
            arr[i] = al.get(i);
        }

        return arr;
    }
}