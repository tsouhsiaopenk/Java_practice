package Java7_23.OJ;
import java.util.HashMap;
import java.util.Map;

/**
 * 超过数组中一半的数字
 */
public class Solution {
    public int MoreThanHalfNum_Solution1(int [] array) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i < array.length;i++){
            map.put(array[i],map.getOrDefault(array[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            if(m.getValue() > array.length / 2){
                return m.getKey();
            }
        }
        return 0;
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        // 合法性检查
        if (array == null || array.length == 0){
            return 0;
        }
        int target = array[0];
        int times = 1;

        for (int i = 0; i < array.length; i++) {
            if (times == 0){ // times == 0就说明当前已被抵消完
                target = array[i];
                times = 1;
            } else if (target == array[i]){
                times++;
            }else{
                times--;
            }
        }
        times = 0;
        for (int i = 0; i < array.length; i++) {
            if (target == array[i]){
                times++;
            }
        }
        return times > array.length / 2 ? target : 0;
    }
}
