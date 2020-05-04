package Java5_4;

public class Solution3 {
    public int minArray(int[] numbers) {
        int index = numbers.length-1;
        while (true){
            if (index >= 1 && numbers[index] >= numbers[index-1]){
                index--;
            }else{
                return numbers[index];
            }
        }
        //return -1;
    }
}
