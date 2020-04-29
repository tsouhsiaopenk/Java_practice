package Java4_29;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = 0;
        for (int num : nums) {
            if (set.contains(num)){
                repeat = num;
                break;
            } else{
              set.add(num);
            }
        }
        return repeat;
    }
}
