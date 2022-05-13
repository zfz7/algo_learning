package org.zfz7.easy;

public class BuySellStock {
//  https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
  public static int maxProfit(int[] prices) {
    //Buy low sell high
    int maxProfit = 0;
    int left = 0;
    int right = 0;
    while (right < prices.length) {
      int profit = prices[right] - prices[left];
      if (profit > maxProfit) {
        maxProfit = profit;
      } else if (profit < 0) {
        left = right;
      }
      right++;
    }
    return maxProfit;
  }
}
