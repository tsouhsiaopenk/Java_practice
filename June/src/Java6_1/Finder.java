package Java6_1;

import org.junit.Test;

import java.util.*;

public class Finder {

    public int findKth1(int[] a, int n, int K) {
        if (a.length != n){
            return -1;
        }
        PriorityQueue priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
            priorityQueue.offer(a[i]);
        }
        for (int i = 1; i < K ; i++) {
            priorityQueue.poll();
        }
        return (int)priorityQueue.poll();
    }
    @Test
    public void t1(){
        int[] arr = {1, 3, 5, 2, 2};
        int n = 5;
        int k = 3;
        System.out.println(findKth1(arr, n, k));
    }
    public int findKth(int[] a, int n, int K) {
        // 将 int 型数组转化为 Integer 型数组
        Integer[] arr = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = new Integer(a[i]);
        }
        // 降序排序
        Arrays.sort(arr, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        Set<Integer> set = new LinkedHashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        Iterator<Integer> iterator = set.iterator();
        int i = 0;
        int result = 0;
        while (iterator.hasNext()) {
            if (i == 3){
                result = iterator.next();
            }
            iterator.next();
        }
        return result;
    }

    @Test
    public void t() {
        int[] arr = {1, 3, 5, 2, 2};
        int n = 5;
        int k = 3;
        System.out.println(findKth(arr, n, k));
    }
}
