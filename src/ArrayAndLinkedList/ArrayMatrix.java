package ArrayAndLinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ustbwjw
 * @create 2021-08-01 22:12
 */
public class ArrayMatrix {

    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, 0);
        }

        for (Integer num : nums) {
            if (map.containsKey(num)) {
                if (map.get(num) == 0) map.put(num, 1);
                else if (map.get(num) == 1) map.put(num, 2);
            }
        }

        int[] ints = new int[2];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()==0){
                ints[1]=entry.getKey();
            }else if (entry.getValue()==2){
                ints[0]=entry.getKey();
            }
        }
        return ints;
    }

}
