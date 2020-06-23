package Java6_23.OJ;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
                map.put(gifts[i],map.getOrDefault(gifts[i],0)+1);
        }
        for (Map.Entry<Integer,Integer> entry :map.entrySet()){
            if (entry.getValue() > n/2){
                return entry.getKey();
            }
        }
        // 这个地方写成了 -1，（习惯性的），纠正花了不少时间
        return 0;
    }

    @Test
    public void Test(){
        int[] gifts = {1,2,3,21,2};
        int n = gifts.length;
        Gift gift = new Gift();
        int res = gift.getValue(gifts,n);
        System.out.println(res);
    }
}
