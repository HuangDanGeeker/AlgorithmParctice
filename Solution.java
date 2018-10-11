import sun.applet.Main;

/**
 * Created by HuangDanGeeker on 2018/10/10.
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len <= 1 || k <= 0) return 0;
        return findMax(prices, 0, len-1, 1, k);
    }


    public int findMax(int prices[], int start, int end){
        return findMax(prices, start, end, 0, 0);
    }

    public int findMax(int prices[], int start, int end, int flag, int k){

        int max = 0;
        if(flag == k){
            System.out.print(start + "-" + end + " ");
            if(start >= end){
                System.out.println(max);
                return 0;
            }


            int diff;
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
            System.out.println(max);
            return max;
        }else{
            int res;
//            if(k - flag == 1){
//                int res_split_left = findMax(prices, start, i, k-2, k) + findMax(prices, i + 1, end);
//            }
//            res =
//            max = Math.max(max, res);
            for(int i = start; i <= end; i++) {
                res =  findMax(prices, start, i, flag + 1, k) + findMax(prices, i + 1, end, flag + 1, k);
                max = Math.max(max, res);
            }
        }
        return max;

    }

    public static void main(String[] args){
        Solution s = new Solution();
        int result  = s.maxProfit(3, new int[]{2,6,8,7,8,7,9,4,1,2,4,5,8});
        System.out.print(result);
//        int[] a = new int[]{1,2,3,4,5};
//        for(int i = 1; i < 4; i++){
//            System.out.print(i);
//        }

        //0-(2,4) (3,5)-6 8-12
        //0-2     3-6
        //0-4     5-6
    }
}