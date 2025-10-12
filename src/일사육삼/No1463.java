package 일사육삼;

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
