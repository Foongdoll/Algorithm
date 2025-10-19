package 구영구오;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
 *
 * 1+1+1+1
 * 1+1+2
 * 1+2+1
 * 2+1+1
 * 2+2
 * 1+3
 * 3+1
 * 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
 * */
public class No9095 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] sn = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            sn[i] = Integer.parseInt(br.readLine());
            if (max < sn[i]) max = sn[i];
        }

        int[] dp = new int[max + 1];
        dp[0] = 1;

        int[] coins = {1,2,3};
        for(int i = 1; i <= max; i++) {
            for(int coin : coins) {
                if(i >= coin) dp[i] += dp[i - coin];
            }
        }

        for(int s : sn) System.out.println(dp[s]);
    }
}
