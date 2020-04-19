package Java4_19;

import java.util.*;

import static jdk.nashorn.internal.objects.NativeString.search;

public class Solution {
    public static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };
    // 同构字符串
    public boolean isIsomorphic(String s, String t) {
        // 如果 s 和 t 的长度不一样，返回 fasle
        if (s.length() != t.length()) {
            return false;
        }
        // 建立一个 HashMap ，key 中存s中的字符， value 中存 t 中的字符
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map.get(sc) == null) { // 保证 S 中当前元素没有建立映射
                // 保证 T 中的元素没有建立映射
                if (map.containsValue(tc)) {
                    return false;
                }
                // 建立 S 中当前元素和 T 中元素的一一映射
                map.put(sc, tc);
            } else if (map.get(sc) != tc) {
                return false;
            }
        }
        return true;
    }

    // 给定两个数组，编写一个函数来计算它们的交集。
    public static int[] intersect(int[] nums1, int[] nums2) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; j < nums2.length; j++) {
//                if (nums1[i] == nums2[j]) {
//                    arrayList.add(nums2[j]);
//                }
//            }
//        }
//        int[] result = new int[arrayList.size()];
//        for (int i = 0; i < arrayList.size(); i++) {
//            result[i] = arrayList.get(i);
//        }
//        return result;
        // 使用集合实现
//        List<Integer> list1 = new ArrayList<>();
//        for (int num: nums1 ) {
//            list1.add(num);
//        }
//        List<Integer> list2 = new ArrayList<>();
//        for (int num: nums2) {
//            if (list1.contains(num)){
//                list2.add(num);
//                // 移除的是该元素，不是该下标的元素
//                list1.remove(Integer.valueOf(num));
//            }
//        }
//        int[] result = new int[list2.size()];
//        for (int i = 0; i <list2.size() ; i++) {
//            result[i] = list2.get(i);
//        }
//        return result;
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        // 将 nums1 出现的数值及频次放入映射中
        for (int num : nums1) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, count + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            Integer count = map.get(num);
            if (count != null && count != 0) {
                list.add(num);
                map.put(num, count - 1);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    // 给定两个数组，编写一个函数来计算他们的交集
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> n1 = new HashSet<>();
        for (int num : nums1) {
            n1.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (n1.contains(num)) {
                list.add(num);
                n1.remove(num);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    // 字符串中的第一个唯一字符 "loveleetcode"
    public int firstUniqChar(String s) {
        // 统计出出现的每个字符出现的次数，然后找出第一个字符的下标
        Map<Character, Integer> map = new HashMap<>(26);
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                Integer count = map.get(c);
                map.put(c, count + 1);
            }
        }
        for (int i = 0; i <chars.length ; i++) {
            if (map.get(chars[i]) == 1){
                return i;
            }
        }
        return -1;
    }
    /*
        class Solution {
            private Map<Integer,Employee> map = new HashMap<>();
            public int getImportance(List<Employee> employees, int id) {
                for(Employee e: employees) map.put(e.id,e);
                System.out.println(map);
                return search(employees,id);
            }
            public int search(List<Employee> employees, int id){
                Employee e = map.get(id);
                int result = e.importance;
                for(int i: e.subordinates){
                    result += search(employees,i);
                }
                return result;
            }
        }
     */

    // 创建一个 map 对象
    private Map<Integer,Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee e:employees){
            map.put(e.id,e);
        }
        System.out.println(map);
        return search(employees,id);
    }
    private int search(List<Employee> employees,int id){
        Employee e = map.get(id);
        int result = e.importance;
        for(int i : e.subordinates){
            result += search(employees,i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
