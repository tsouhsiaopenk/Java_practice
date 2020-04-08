package Java4_8;

public class Solution {
    public static int lastStoneWeight(int[] stones) {
        MyPriorityQueue queue = new MyPriorityQueue();
        for (int i = 0; i < stones.length; i++) {
            queue.offer(stones[i]);
        }
        while (queue.getSize() > 1) {
            int x = queue.poll();
            int y = queue.poll();
            // 保证 y 是大的一个
            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            if (x != y) {
                queue.offer(y - x);
            }
            if (queue.isEmpty()){
                return 0;
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        //[2,7,4,1,8,1]
        int[] array = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(array));
    }
}

