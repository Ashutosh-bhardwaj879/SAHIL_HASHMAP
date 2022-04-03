import java.util.*;
//https://leetcode.com/problems/intersection-of-two-arrays-ii/
class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> al = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int key : nums1) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (int key : nums2) {
            if (map.containsKey(key) && map.get(key) > 0) {
                al.add(key);
                map.put(key, map.get(key) - 1);
            }
        }
        // converting arraylist to array
        int[] arr = al.stream().mapToInt(i -> i).toArray();
        // TC o(m+n)
        // SC-O(m+n)
        return arr;
    }
}