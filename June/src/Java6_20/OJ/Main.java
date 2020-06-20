package Java6_20.OJ;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 1.输入基因序列
            String geneSequence = scanner.next();
            // 2.输入字串长度
            int subStringLength = scanner.nextInt();
            // 3.计算 GC-Ratio 最高的子序列
            String res = maxGCRatio(geneSequence, subStringLength);
            // 4.输出结果
            System.out.println(res);
        }
    }
    /*
        计算 GC-Ratio 最高的子序列
     */
    private static String maxGCRatio(String geneSequence, int subStringLength) {
        // 特殊情况一：基因序列没有给定子串长
        if (geneSequence.length() < subStringLength) {
            return null;
        }
        // 特殊情况二：基因序列和给定子串一样长
        if (geneSequence.length() == subStringLength) {
            return geneSequence;
        }
        // 返回的结果
        String res = null;
        double MaxRatio = 0;
        for (int i = 0; i < geneSequence.length() - subStringLength; i++) {
            String string = geneSequence.substring(i, i + subStringLength);
            double currentRatio = GCRation(string);
            if (currentRatio > MaxRatio){
                res = string;
                MaxRatio = currentRatio;
            }
        }
        return res;
    }

    private static double GCRation(String string) {
        int GCNum = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == 'G' || c == 'C') {
                GCNum++;
            }
        }
        return (GCNum*1.0) / string.length();
    }


}
