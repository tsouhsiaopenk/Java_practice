package Java4_13;

public class Solution {
    public int[] singleNumber(int[] nums){
        // 1.先把所有结果都异或到一起
        int ret = 0;
        for (int x : nums){
            ret ^= x;
        }
        // 2.此时的结果相当于 a ^ b ,值一定给不为零
        //  就可以从中找到某个为 1 的比特位
        int bit = 1;
        int i = 0;
        for (; i < 32;i++){
            if ((ret & bit << i) != 0){
                break;
            }
        }
        // 3. 进行分组
        int a = 0;
        int b = 0;
        // 异或结果为 1 的 位置处，a 和 b 的该位肯定不一样，这样就能分散在两组中进行计算
        for (int x :nums) {
            if ((x & (bit << i)) != 0){
                // 第一组，指定位置为 1
                a ^= x;
            }else{
                // 第二组，指定位置为 0
                b ^= x;
            }
        }
        int[] arr = {a,b};
        return arr;
    }
}
