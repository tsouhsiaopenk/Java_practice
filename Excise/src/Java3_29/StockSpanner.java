package Java3_29;

import java.util.Stack;

public class StockSpanner {
    private Stack<Integer> prices; // 股票价格
    private Stack<Integer> stockSpans;   // 股票跨度

    public StockSpanner() {
        prices = new Stack<Integer>();
        stockSpans = new Stack<Integer>();
    }

    public int next(int price) {
        // 自身跨度为1
        int stockSpan = 1;
        // 不断查看前面有几天小于等于price
        while (!prices.empty() && prices.peek() <= price) {
            // 从栈中舍弃掉该数字
            prices.pop();
            // 跨度累加计算
            stockSpan += stockSpans.pop();
        }
        prices.push(price);
        stockSpans.push(stockSpan);
        return stockSpan;
    }
}
