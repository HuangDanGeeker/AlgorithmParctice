/**
 * Created by HuangDanGeeker on 2018/10/11.
 */
public class BestTimetoBuyandSellStock_123 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        int max = 0, res;
        for(int i = 0; i < len; i++){
            res = findMax(prices, 0, i) + findMax(prices, i+1, len-1);
            max = Math.max(max, res);
        }
        return max;

    }

    public int findMax(int prices[], int start, int end){
        if(start >= end)
            return 0;

        int max = 0, diff;
        int i = start, j;
        for(j = i+1; j <= end; j++){
            diff = prices[j] - prices[i];
            if(0 < diff){
                if(diff > max)
                    max = diff;
            }else{
                i = j;
            }
        }
        return max;
    }

    public static void main(String[] args){
        BestTimetoBuyandSellStock_123 s = new BestTimetoBuyandSellStock_123();
        int result  = s.maxProfit(new int[]{1,2,3,4,5});
        System.out.print(result);
    }
}
