package Java3_28;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};

public class Solution {
    /**
     * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
     * 由于需要不断地搜索每个下属列表以及下属的下属列表，那么可以借用队列来实现
     *
     * @param employees
     * @param id
     * @return
     */
    public int getImportance(List<Employee> employees, int id) {
        // 队列中存放的是下属列表id
        Queue<Integer> queue = new LinkedList<>();
        // 先找到id（参数id）的重要度和直属下属
        int result = 0; // 返回的结果
        // 1.计算传进来的id的重要度，并且将下属列表中的重要度添加进列表中
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).id == id) {
                result = employees.get(i).importance;
                List<Integer> sub = employees.get(i).subordinates;
                // 若下属列表中为空，不用进行队列添加操作，由于id唯一，因此，循环就不用进行遍历
                if (sub == null){
                    break;
                }
                // 将初始id的下属列表添加到队列中
                for (int j = 0; j < sub.size(); j++) {
                    queue.add(sub.get(j));
                }
            }
        }
        // 2.若没有下属,返回的是id自己的重要度
        if (queue.isEmpty()){
            return result;
        }

        // 3.取出队列中的元素id，计算重要度，同时将其下属列表添加到队列中
        while(!queue.isEmpty()){
            // (1)取队首元素
            int curId = queue.poll();
            // (2)找到该id的重要度
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).id == curId){
                    //(3) 进行重要度累加计算
                    result += employees.get(i).importance;
                    // (4)得到该id对应的下属列表
                    List<Integer> sub = employees.get(i).subordinates;
                    // (5)若下属列表中为空，不用进行队列添加操作，由于id唯一，因此，循环就不用进行遍历
                    if (sub == null){
                        break;
                    }
                    // (6)将该id的下属列表添加到队列中
                    for (int j = 0; j < sub.size(); j++) {
                        queue.add(sub.get(j));
                    }
                }
            }
        }
        return result;
    }
}
