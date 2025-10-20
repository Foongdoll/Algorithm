package 일사육삼;

/**
 * BOJ 1463 · 1로 만들기
 * - 문제 요약: 세 연산만 사용해 주어진 수를 1로 만드는 최소 연산 횟수를 구한다.
 * - 알고리즘: 동적 계획법 (반복 DP)
 * - 시간 복잡도: O(N)
 * - 공간 복잡도: O(N)
 * - 사용 이유: 1부터 N까지 최소 연산 횟수를 누적하면 각 상태를 한 번씩만 계산하면 된다.
 * - 기타: 3과 2로 나눌 수 있는 경우를 각각 비교하며 재귀를 제거해 안정적으로 동작한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 *
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 *
 * */
public class No1463 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = 0;
        for (int x = 2; x <= N; x++) {
            int best = dp[x - 1] + 1;
            if (x % 2 == 0) best = Math.min(best, dp[x / 2] + 1);
            if (x % 3 == 0) best = Math.min(best, dp[x / 3] + 1);
            dp[x] = best;
        }
        System.out.println(dp[N]);
    }
}
