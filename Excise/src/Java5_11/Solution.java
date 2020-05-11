package Java5_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean isNumber(String s) {
        int[][] stateTable={{1,2,7,-1,-1,0},
                {-1,2,7,-1,-1,-1},
                {-1,2,3,4,-1,9},
                {-1,3,-1,4,-1,9},
                {6,5,-1,-1,-1,-1},
                {-1,5,-1,-1,-1,9},
                {-1,5,-1,-1,-1,-1},
                {-1,8,-1,-1,-1,-1},
                {-1,8,-1,4,-1,9},
                {-1,-1,-1,-1,-1,9}
        };
        Map<String,Integer> col=new HashMap<String ,Integer>(){
            {
                put("sign",0);
                put("number",1);
                put(".",2);
                put("exp",3);
                put("other",4);
                put("blank",5);
            }
        };
        int state=0;
        List<Integer> legalState=new ArrayList<Integer>(){{
            add(2);
            add(3);
            add(5);
            add(8);
            add(9);
        }};
        for(int i=0;i<s.length();i++){
            state=stateTable[state][col.get(getCol(s.charAt(i)))];
            if(state==-1) return false;
        }
        if (legalState.contains(state)) return true;
        return false;

    }
    public String getCol(char c){
        if (c=='+'||c=='-') return "sign";
        if (c>='0'&&c<='9') return "number";
        if (c=='.') return ".";
        if (c=='E'||c=='e') return "exp";
        if (c==' ') return "blank";
        return "other";
    }
}
