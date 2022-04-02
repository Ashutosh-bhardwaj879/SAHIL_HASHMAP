import java.util.*;

class countElement {
    public static void main(String[] args) {

        int nums[] = { 1, 2, 3, 4, 5, 1, -1, 0, 2, 3 };

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int key : nums) {

            if (map.containsKey(key)) {
                int value = map.get(key);
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }
        System.out.println(map);
    }
}