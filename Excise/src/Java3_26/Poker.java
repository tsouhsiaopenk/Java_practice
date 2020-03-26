package Java3_26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card {
    private String rank; // 点数
    private String suit; // 花色

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "[" + this.suit + ":" + this.rank + "]";
    }
}

public class Poker {
    public static void main(String[] args) {
        // 1,创建一副牌
        List<Card> poker = buyPoker();
        // 2,洗牌 ： 把poker中的元素打乱
        // 自定义方法：从后往前遍历 List，取出当前元素，和一个任意位置上的元素进行交换
        // 直接使用Colletions.shuffle方法
        Collections.shuffle(poker);
        // 3，发牌
        // 假设有三个玩家，没人发五张牌
        // 每个玩家就是一个 List ， 就可以把每个人的手牌放到List中
        List<List<Card>> players = new ArrayList<>();
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        // 每人发五张(注意：发牌是一人一张发的)
        for (int i = 0; i < 5; i++) {
            // 给三个玩家发牌
            for (int j = 0; j < 3; j++) {
                List<Card> player = players.get(j);
                Card card = poker.remove(0);
                player.add(card);
            }
        }
        // 查看手牌
        for (int i = 0; i < 3; i++) {
            System.out.println("玩家" + i + ":" + players.get(i));
        }
    }

    // 创建一幅扑克
    private static List<Card> buyPoker() {
        List<Card> poker = new ArrayList<>();

        // 红桃，黑桃，梅花，方块
        String[] suits = {"♥", "♠", "♣", "♦"};
        // 循环四次，对应处理的四种花色,每种花色有13张牌，暂时不考虑大小王
        for (int i = 0; i < 4; i++) {
            // 先构造2~10这几张牌
            for (int j = 2; j < 11; j++) {
                poker.add(new Card("" + j, suits[i]));
            }
            // 再构造剩下的牌
            poker.add(new Card("J", suits[i]));
            poker.add(new Card("Q", suits[i]));
            poker.add(new Card("K", suits[i]));
            poker.add(new Card("A", suits[i]));
        }
        return poker;
    }
}
