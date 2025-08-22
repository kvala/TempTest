

public class Q123_BuySell {

    public int maxPrice2(int[] prices){
        int buy1 = -prices[0], buy2=-prices[0];
        int profit1=0, finalProfit = 0;

        for(int price : prices){
            buy1 = Math.max(buy1,-price);
            profit1 = Math.max( profit1 , buy1 + price );
            buy2 = Math.max(buy2, profit1 - price);
            finalProfit = Math.max(finalProfit, price + buy2);
        }
        return finalProfit;


    }


    public int maxPrice(int[] prices){
        int sellTwo = 0;
        int holdTwo = Integer.MIN_VALUE;
        int sellOne = 0;
        int holdOne = Integer.MIN_VALUE;

        for (final int price : prices) {
            sellTwo = Math.max(sellTwo, holdTwo + price);
            holdTwo = Math.max(holdTwo, sellOne - price);
            sellOne = Math.max(sellOne, holdOne + price);
            holdOne = Math.max(holdOne, -price);
        }

        return sellTwo;
    }

    public static void main(String[] args){
        Q123_BuySell s = new Q123_BuySell();
        int[] input = {3,3,5,0,0,3,1,4};
        System.out.println(s.maxPrice2(input));
    }
}
