package Java6_5.review;

public class Solution {
    public int count(int[] A, int n) {
        if (A == null || n == 0) {
            return 0;
        }
        return mergeSortRescursion(A, 0, n - 1);
    }

    private int mergeSortRescursion(int[] arr, int left, int right) {
        // 当排序数组长度为 1 时，递归开始回溯，进行 merge 操作
        if (left == right) {
            return 0;
        }
        int mid = (left + right) / 2;
        /*
            逆序对的总数 = 左边数组中逆序对数量
                        + 右边数组中逆序对数量
                        + 左右结合成新的顺序数组时出现的逆序对数量
         */
        return mergeSortRescursion(arr, left, mid) + mergeSortRescursion(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    // 返回合并过程中累加逆序对
    private int merge(int[] arr, int left, int mid, int right) {
        // 辅助存储空间
        int[] tmp = new int[right - left + 1];
        int index = 0;
        int i = left;
        int j = mid + 1;
        // 新增，用来累加数组逆序对
        int inverseNum = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[index++] = arr[i++];
            } else {
                // 当前一个数组元素大于后一个元素时累加逆序对
                // s[i] > s[j] 推导出 s[i]...s[mid] > s[j]
                inverseNum += (mid - i + 1);
                tmp[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[index++] = arr[i++];
        }
        while (j <= right) {
            tmp[index++] = arr[j++];
        }
        for (int k = 0; k < tmp.length; k++) {
            arr[left++] = tmp[k];
        }
        return inverseNum;
    }

}
