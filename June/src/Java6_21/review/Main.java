package Java6_21.review;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            // 输入 T 组数据
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                // 每一组有 2n 个数据，每组洗牌 k 次
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                int[] card = new int[2 * n];
                for (int j = 0; j < 2 * n; j++) {
                    card[j] = scanner.nextInt();
                }
                // 洗牌 k 次
                shuffle(card, k);
            }
        }
    }

    /*
        洗牌操作：传入牌以及洗牌次数
     */
    private static void shuffle(int[] card, int k) {
        // 左手的牌
        int[] leftCard = new int[card.length / 2];
        // 右手的牌
        int[] rightCard = new int[card.length / 2];
        while (k != 0) {
            // 初始化左手的牌
            for (int i = 0; i < card.length / 2; i++) {
                leftCard[i] = card[i];
            }
            // 初始化右手的牌
            for (int i = card.length / 2; i < card.length; i++) {
                rightCard[i - card.length / 2] = card[i];
            }
            // 左手洗牌到那一张牌，记录的是下标
            int left = 0;
            int right = 0;
            for (int i = 0; i < card.length; i++) {
                if (i % 2 == 0){
                    card[i] = leftCard[left];
                    left++;
                }else {
                    card[i] = rightCard[right];
                    right++;
                }

            }
            // 每洗一次牌就减少一次洗牌操作
            k--;
        }
        for (int i = 0; i < card.length - 1; i++) {
            System.out.print(card[i] + " ");
        }
        System.out.println(card[card.length -1]);
    }
}
