package Java6_22.OJ;

import java.util.Arrays;

public class Substr {
    public static void main(String[] args) {
        String[] p = {"a", "b", "c", "d"};
        String s = "abc";
        boolean [] res = new boolean[p.length];
        res = chkSubStr(p,p.length,s);
        System.out.println(Arrays.toString(res));
    }

    public static boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] hasSub = new boolean[n];
        for (int i = 0; i < n; i++) {
            hasSub[i] = s.contains(p[i]);
        }
        return hasSub;
    }
}
