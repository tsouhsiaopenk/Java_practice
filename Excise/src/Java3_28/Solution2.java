package Java3_28;

public class Solution2 {
    /*
        所有人都信任法官 说明他的入度为 n -1
        法官不信任任何人 说明他地出度为 0
        注意：如果这个人没有描述，则默认他不信任任何人
     */
    public int findJudge(int N, int[][] trust) {
        // 定义一个数组来保存 1-N这些人的度（下标0的位置没有用）
        int[] cnt = new int[N + 1];
        // 计算入度和出度
        for (int[] index:trust){
            cnt[index[0]]--; // 出度
            cnt[index[1]]++; // 入度
        }
        // 查找入度为0，且入度为N-1的元素
        for (int i = 1; i <= N ; i++) {
            if (cnt[i] == N-1){
                return i;
            }
        }
        // 若没有找到，返回 -1
        return -1;
    }
}
