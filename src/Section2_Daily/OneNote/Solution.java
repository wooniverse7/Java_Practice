package Section2_Daily.OneNote;

public class Solution {
    public static void main(String[] args) {
        int total = 10;
        int[] coins = new int[]{1, 5};
        int output = coinChange(total, coins);
        System.out.println(output); // --> 3

        total = 10;
        coins = new int[]{1, 2, 5};
        output = coinChange(total, coins);
        System.out.println(output); // --> 10

        total = 4;
        coins = new int[]{1, 2, 3};
        output = coinChange(total, coins);
        System.out.println(output); // --> 4 ([1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3])
    }

    public static int coinChange(int total, int[] coins) {
        // TODO :
        // DP
        /**
         *   dp[i]는 i원까지의 동전의 경우의 수
         *   dp[i] += dp[i-coin] 식은 j원이 되기 위해서 추가되는 동전의 수
         *
         *   예를 들어 j가 10이고 동전 1,2,5를 갖고 있을 때의 경우의 수
         *   dp[9] + 1 원
         *   dp[8] + 2 원
         *   dp[5] + 5 원
         *
         *  dp[9], d[8], dp[5] 또한 각각 해당 인덱스까지의 모든 경우의 수 이기 때문에 전부 더해주면
         *  dp[10] 의 총 경우의 수
         */
        int[] dp = new int[total + 1];

        dp[0] = 1;

        for(int coin : coins){
            // {1, 2, 5}, 10
            for (int i = coin; i <= total; i++) {
                dp[i] += dp[i-coin];
                // coin : 1
                // dp[] : , 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
                // coin : 2
                // dp[] : , 1, 2, 2, 3, 3, 4, 4, 5, 5, 6
                // coin : 5
                // dp[] : , 1, 2, 2, 3, 4, 5, 6, 7, 8, 10
            }
        }

        return dp[total];
    }
}