public class OblyOne {
    public static int onlyOne(int[] arr){
        int result = arr[0];
        // 利用异或运算来找出其中的单独的数字，n^n = 0 n^n^n = n
        for(int i = 1;i < arr.length; i++){
            result = result^arr[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,2,4,6,6,1};
        System.out.println(onlyOne(arr));
    }
}
