package Java6_6.Review;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Com {

    public static void DFS(List<Integer> candidate, String prefix) {
        if (prefix.length() != 0) {
            System.out.println(prefix);
        }

        for (int i = 0; i < candidate.size(); i++) {
            List<Integer> temp = new LinkedList<Integer>(candidate);
            int item = (int) temp.remove(i);  // 取出被删除的元素，这个元素当作一个组合用掉了
            DFS(temp, prefix + item);
        }
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2};
        List<Integer> list = Arrays.asList(array);
        DFS(list, "");
    }
}
