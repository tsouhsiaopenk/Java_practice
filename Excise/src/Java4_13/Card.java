package Java4_13;

import java.util.Comparator;
import java.util.Objects;

public class Card implements Comparable<Card> {
    public String rank; // 点数
    public String suit; // 花色
    @Override
    public int compareTo(Card o) {
        if (o == null){
            return 1;
        }
        int rank1 = this.getValue();
        int rank2 = o.getValue();
        return rank1 - rank2;
    }

    public int getValue() {
        int value = 0;
        if ("J".equals(rank)){
            return 11;
        }else if ("Q".equals(rank)){
            return 12;
        }else if ("K".equals(rank)){
            return 13;
        }else if ("A".equals(rank)){
            return 14;
        }else{
            value = Integer.parseInt(rank);
        }
        return value;
    }

    @Override
    public boolean equals(Object o) {
        // 1.自己和自己比较的情况
        if (this == o) return true;
        // 2.o 为 null 认为结果为false
        if (o == null ) return false;
        // 3.o 这个类型是不是当前 Card 类型
        if (getClass() != o.getClass()) return false;
        // 或者也可以这样写
        // if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        // 我们只比较一下值得关系
        return Objects.equals(rank, card.rank);
    }

}

class CardComparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        if (o1 == o2){
            return 0;
        }
        if (o1 == null){
            return -1;
        }
        if (o2 == null){
            return 1;
        }
        int value1 = o1.getValue();
        int value2 = o2.getValue();
        return value1 - value2;
    }
}

