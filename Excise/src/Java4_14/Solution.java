package Java4_14;

import java.util.*;

public class Solution {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        // 1.遍历旧链表，把旧链表每个结点依次插入map中
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        // 2.再次遍历链表，修改新链表中的 next 和 random
        for (Node cur = head; cur != null; cur = cur.next) {
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
        }
        // 3.返回新链表的头节点
        return map.get(head);
    }

    public int numJewelsInStones(String J, String S) {
        Set<Character> jewelsSet = new HashSet<>();
        // 这里可不可以用addAll，一会试一下
        for (char c : J.toCharArray()) {
            jewelsSet.add(c);
        }
        int ret = 0;
        for (char c : S.toCharArray()) {
            if (jewelsSet.contains(c)) {
                ret++;
            }
        }
        return ret;
    }

    public List<String> topKFrequent(String[] words, int k) {
        // 1.先统计每个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            Integer count = map.getOrDefault(s,0);
            map.put(s,count+1);
        }
        // 2.把刚才这里统计到的字符串内容放在 ArrayList 中
        ArrayList<String> arrayList = new ArrayList<>(map.keySet());
        // 3.排序
        Collections.sort(arrayList,new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                // o1 < o2 返回 < 0       o1 - o2 < 0
                // o1 > o2 返回 > 0       o1 - o2 > 0
                // o1 == o2 返回 0        o1 - o2 = 0
                int count1 = map.get(o1);
                int count2 = map.get(o2);
                if (count1 == count2){
                    return o1.compareTo(o2);
                }
                return count2 - count1;
            }
        });


        return arrayList.subList(0,k);
    }
}
