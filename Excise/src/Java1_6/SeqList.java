package Java1_6;

public class SeqList {
    // 初始化长度为100
    private int[] datas = new int[100];
    // 有效长度
    private int size = 0;

    public int getSize() {
        // size 通过后面的增删方法来维护
        return size;
    }

    // 依次打印线性表中每个元素，形如：[1,2,3,4]
    public void display() {
        String string = "[";
        for (int i = 0; i < size; i++) {
            string += datas[i];
            if (i != size - 1) {
                string += ",";
            }
        }
        string += "]";
        System.out.println(string);
    }

    /*
        pos 表示新元素插入的下标
        data 表示新元素的值
     */
    public void add(int pos, int data) {
        // 判断pos是否为有效的值
        if (pos < 0 || pos > size) {
            return;
        }
        // 扩容，顺序表如果容量不够了，就能进行扩容
        if (size >= datas.length) {
            int[] newDatas = new int[2 * datas.length];
            for (int i = 0; i < datas.length; i++) {
                newDatas[i] = datas[i];
            }
            datas = newDatas;
        }
        // 尾插的情况，把新元素放在size的位置上
        if (pos == size) {
            datas[pos] = data;
            size++;
            return;
        }
        // 普通插入的情况
        for (int i = size - 1; i >= pos; i--) {
            // 将 pos 位置起的元素全部往后挪一个单位
            datas[i + 1] = datas[i];
        }
        datas[pos] = data;
        size++;
    }

    // 判断是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < size; i++) {
            if (datas[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < size; i++) {
            if (datas[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if (pos < 0 || pos > size) {
            return -1;
        }
        return datas[pos];
    }

    // 给pos位置的元素设置为 value
    public void setPos(int pos, int value) {
        datas[pos] = value;
    }

    // 删除第一次出现的关键词key
    public void remove(int toRemove) {
        // 先找到要删除元素的下标
        int pos = search(toRemove);
        if (pos == -1) {
            // 没有找到要删除的元素,即要产出的元素不存在
            return;
        }
        // 如果下标是最后一个元素，
        if (pos == size - 1) {
            size--;// 逻辑删除
            return;
        }
        // 中间元素，需要先搬运，在删除
        for (int i = pos; i < size - 1; i++) {
            datas[i] = datas[i + 1];
        }
        size--;
    }
    // 清空顺序表
    public void clear(){
        size = 0;
    }
}
