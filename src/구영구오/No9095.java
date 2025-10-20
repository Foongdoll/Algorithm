package 구영구오;

/**
 * BOJ 9095 · 1, 2, 3 더하기
 * - 문제 요약: 주어진 정수 n을 1, 2, 3의 합으로 만들 수 있는 순서 있는 조합의 수를 구한다.
 * - 알고리즘: 동적 계획법 (1, 2, 3 더하기 점화식)
 * - 시간 복잡도: O(요청된 n의 최댓값)
 * - 공간 복잡도: O(요청된 n의 최댓값)
 * - 사용 이유: 작은 수에서 큰 수로 전개하면 중복 호출 없이 모든 테스트케이스를 처리할 수 있다.
 * - 기타: 입력에서 최댓값을 미리 파악해 필요한 범위만큼만 점화식을 채운다.
 */

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
